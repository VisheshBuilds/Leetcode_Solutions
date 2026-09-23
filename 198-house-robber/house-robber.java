class Solution {
    int[] dp;
    public int rob(int[] nums) {
        int n=nums.length;
        dp=new int[n];
        Arrays.fill(dp,-1);

        return helper(nums,n,0);
    }
    public int helper(int[] nums,int n,int idx){
        if(idx>=n) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int take=nums[idx]+helper(nums,n,idx+2);
        int skip=0+helper(nums,n,idx+1);

        return dp[idx]=Math.max(take,skip);
    }
}