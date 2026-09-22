class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n][2][k+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                for(int p=0;p<=k;p++){
                    dp[i][j][p]=-1;
                }
            }
        }
        return solve(0,1,k,prices,dp,n);
    }
    public int solve(int idx,int buy,int cap,int[] prices,int[][][] dp,int n){
        if(idx==n || cap==0) return 0;
        if(dp[idx][buy][cap]!=-1) return dp[idx][buy][cap];

        if(buy==1){
            return dp[idx][buy][cap]=Math.max(-prices[idx]+solve(idx+1,0,cap,prices,dp,n),
                               0+solve(idx+1,1,cap,prices,dp,n));
        }
        return dp[idx][buy][cap]=Math.max(prices[idx]+solve(idx+1,1,cap-1,prices,dp,n),
                               0+solve(idx+1,0,cap,prices,dp,n));
    }
}