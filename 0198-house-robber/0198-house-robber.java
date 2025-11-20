class Solution {
    public int rob(int[] nums) {
        //METHOD 1 (RECUSION + MEMOIZATION)

        // int n=nums.length;
        // int[] dp=new int[n];
        // Arrays.fill(dp,-1);
        // return helper(nums,0,dp);

        //METHOD 2(TABULATION)
        
        int n=nums.length;
        int[] dp=new int[n];
        dp[0]=nums[0];
        for(int i=1;i<n;i++){
            if(i==1) dp[i]=Math.max(nums[i],dp[i-1]);
            else dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[n-1];
    }
    public int helper(int[] nums,int i,int[] dp){
        if(i>=nums.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int take=nums[i]+helper(nums,i+2,dp);
        int skip=helper(nums,i+1,dp);
        return dp[i]=Math.max(take,skip);
    }
}