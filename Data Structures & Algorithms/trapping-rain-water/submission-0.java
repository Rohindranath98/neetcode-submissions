class Solution {
    public int trap(int[] height) {
        if(height==null || height.length==0){
            return 0;
        }
        int l=0, r=height.length-1;
        int leftmax=height[l], rightmax=height[r];
        int res=0;
        while(l<r){
        if(leftmax<rightmax){
            l++;
            leftmax=Math.max(leftmax, height[l]);
            res+=leftmax-height[l];
        }else{
            r--;
            rightmax=Math.max(rightmax, height[r]);
            res+=rightmax-height[r];
        }
        }
        return res;
    }
}
