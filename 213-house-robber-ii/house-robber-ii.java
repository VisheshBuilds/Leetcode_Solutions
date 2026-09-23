class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        int f=helper(nums,n-1,0,dp);
        Arrays.fill(dp,-1);
        int l=helper(nums,n,1,dp);
        return Math.max(f,l);
    }
    public int helper(int[] nums,int n,int idx,int[] dp){
        if(idx>=n) return 0;
        if(dp[idx]!=-1) return dp[idx];

        int take=nums[idx]+helper(nums,n,idx+2,dp);
        int skip=0+helper(nums,n,idx+1,dp);

        return dp[idx]=Math.max(take,skip);
    }
}