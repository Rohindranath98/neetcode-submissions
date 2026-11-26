class Solution {

    private int[][] directions = {
        {1, 0},   // Down
        {-1, 0},  // Up
        {0, 1},   // Right
        {0, -1}   // Left
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // DFS from Pacific boundaries
        for (int c = 0; c < cols; c++) {
            dfs(0, c, heights, pacific);          // Top row
            dfs(rows - 1, c, heights, atlantic);   // Bottom row
        }

        for (int r = 0; r < rows; r++) {
            dfs(r, 0, heights, pacific);          // Left column
            dfs(r, cols - 1, heights, atlantic);   // Right column
        }

        // Find cells visited by both oceans
        List<List<Integer>> result = new ArrayList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int r, int c, int[][] heights, boolean[][] visited) {

        int rows = heights.length;
        int cols = heights[0].length;

        // Boundary check
        if (r < 0 || c < 0 || r >= rows || c >= cols) {
            return;
        }

        // Already visited
        if (visited[r][c]) {
            return;
        }

        // Mark visited
        visited[r][c] = true;

        // Explore all 4 directions
        for (int[] dir : directions) {

            int nr = r + dir[0];
            int nc = c + dir[1];

            // Reverse water flow:
            // Move to equal or higher height
            if (nr >= 0 && nc >= 0 &&
                nr < rows && nc < cols &&
                heights[nr][nc] >= heights[r][c]) {

                dfs(nr, nc, heights, visited);
            }
        }
    }
}