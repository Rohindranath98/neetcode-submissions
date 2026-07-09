class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hmap=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int actualtarget= target-nums[i];
            if(hmap.containsKey(actualtarget)){
            return new int[]{hmap.get(actualtarget),i};
            }
        
         hmap.put(nums[i], i);
         }
         return new int[]{};
    }
         
}
