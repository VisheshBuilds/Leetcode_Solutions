class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums,0,target);
    }
    public int helper(int[] nums,int i, int target){
        if(i==nums.length){
            if(target==0) return 1;
            else return 0;
        }
        return helper(nums,i+1,target-nums[i])+helper(nums,i+1,target+nums[i]);
    }
}