class Solution {
    int[][][] dp;
    public int maxProfit(int[] prices) {
        int n=prices.length;
        dp=new int[n][2][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<3;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return helper(0,1,2,prices,n,dp);
    }
    public int helper(int idx,int buy,int cap,int[] prices,int n,int[][][] dp){
        if(idx==n || cap==0) return 0;
         
        if(dp[idx][buy][cap]!=-1) return dp[idx][buy][cap];
        if(buy==1){
            return dp[idx][buy][cap]=Math.max(-prices[idx]+helper(idx+1,0,cap,prices,n,dp),
              0+helper(idx+1,1,cap,prices,n,dp));
        }
        return dp[idx][buy][cap]=Math.max(prices[idx]+helper(idx+1,1,cap-1,prices,n,dp),
              0+helper(idx+1,0,cap,prices,n,dp));
    }
}