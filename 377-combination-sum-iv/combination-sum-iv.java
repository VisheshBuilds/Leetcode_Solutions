class Solution {
    int ans=0;
    int[] dp=new int[1001];
    public int combinationSum4(int[] nums, int target) {
        Arrays.fill(dp,-1);
        
        return helper(nums,target);
    }
    public int helper(int[] nums,int target){
        if(target==0){
            return 1;
        }
        if(target<0) return 0;
        if(dp[target]!=-1) return dp[target];

        int currCombination=0;

        for(int i=0;i<nums.length;i++){

            currCombination +=helper(nums,target-nums[i]);
        }

        return dp[target]=currCombination;
    }
}