class Solution {
    public boolean canJump(int[] nums) {
        int fartest=0,n=nums.length;
        for(int i=0;i<n;i++){
            if(i>fartest) return false;
            fartest=Math.max(fartest,i+nums[i]);
        }
        return true;
    }
}