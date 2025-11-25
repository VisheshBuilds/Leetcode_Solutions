class Solution {
    public int uniquePaths(int m, int n) {
             //METHOD 1 (D.P)
        // int[][] dp=new int[m][n];
        // Arrays.fill(dp,-1);
        // return helper(0,0,m,n,dp);

            //METHOD 2 (TABULATION)
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0) dp[i][j]=1;
                else dp[i][j]=dp[i][j-1]+ dp[i-1][j];
            }
        }    
        return dp[m-1][n-1];
    }
    public int helper(int i,int j,int m, int n,int[][] dp) {
        if(i==m-1 || j==n-1) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        int right=helper(i,j+1,m,n,dp);
        int down=helper(i+1,j,m,n,dp);
        return dp[i][j]=right+down;
    }
}