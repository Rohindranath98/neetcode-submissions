class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        List<int[]> arr=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            arr.add(new int[]{entry.getValue(), entry.getKey()});
        }
        arr.sort((a,b)-> b[0]-a[0]);
        int[] result=new int[k];
        for(int i=0;i<k;i++){
            result[i]=arr.get(i)[1];
        }
        return result;
    }
}
