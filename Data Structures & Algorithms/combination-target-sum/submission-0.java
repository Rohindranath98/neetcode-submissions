class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> cur=new ArrayList<>();
        backtrack(nums,target,cur,0,res);
        return res;
    }
    public void backtrack(int[] nums, int target, List<Integer> cur, int i, List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList<>(cur));
            return;
        }
        if(target<0 || i>=nums.length){
            return;
        }
        cur.add(nums[i]);
        backtrack(nums, target-nums[i], cur,i,res);
        cur.remove(cur.size()-1);
        backtrack(nums, target, cur,i+1,res);
    }
}
