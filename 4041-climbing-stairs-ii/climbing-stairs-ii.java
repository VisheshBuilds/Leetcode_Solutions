class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,0,costs,dp);
    }
    public int solve(int n,int i, int[] costs,int[] dp){
        if(i>n) return Integer.MAX_VALUE;
        if(i==n) return 0;
        if(dp[i]!=-1) return dp[i];
        int one=(costs[i]+1)+solve(n,i+1,costs,dp);
        int two=(i+2)<=n ? (costs[i+1]+4)+solve(n,i+2,costs,dp):Integer.MAX_VALUE;
        int three=(i+3)<=n ? (costs[i+2]+9)+solve(n,i+3,costs,dp):Integer.MAX_VALUE;

        return dp[i]=Math.min(one,Math.min(two,three));
    }
}