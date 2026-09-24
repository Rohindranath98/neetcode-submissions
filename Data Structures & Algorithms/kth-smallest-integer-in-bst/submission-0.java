/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int[] tmp=new int[2]; //tmp[0] → how many nodes are still needed  tmp[1] → answer

        tmp[0]=k;
        dfs(root,tmp);
        return tmp[1];
    }
    private void dfs(TreeNode node, int[] tmp){
        if(node==null){
            return;
        }
        dfs(node.left,tmp);
        if(tmp[0]==0) return; // got the ans no need to process
        tmp[0] -=1;  //Decreases k
        if(tmp[0]==0){
            tmp[1]=node.val;
            return;
        }
        dfs(node.right,tmp);
    }
}
