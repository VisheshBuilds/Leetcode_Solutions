class Solution {
    public int jump(int[] nums) {
        int far=0,n=nums.length,jump=0,current=0;
        for(int i=0;i<n-1;i++){
            far=Math.max(far,i+nums[i]);
            if(i==current){
                jump++;
                current=far;
            }
        }
        return jump;
    }
}