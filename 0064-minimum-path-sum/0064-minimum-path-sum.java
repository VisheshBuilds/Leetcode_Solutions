class Solution {
    public int minPathSum(int[][] arr) {
            //METHOD 1 (TABULATION)

        // int m=arr.length;
        // int n=arr[0].length;
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         if(i==0 && j==0) continue;
        //         else if(i==0) arr[i][j]=arr[i][j]+arr[i][j-1];
        //         else if(j==0) arr[i][j]=arr[i][j]+arr[i-1][j];
        //         else arr[i][j] +=Math.min(arr[i][j-1],arr[i-1][j]);
        //     }
        // } 
        // return arr[m-1][n-1];

            //METHOD 2(RECURSION + MEMOIZATION)

        int m=arr.length;
        int n=arr[0].length;
        int[][] dp=new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(m,n,0,0,dp,arr);  
    }
    public int helper(Integer m,Integer n,int i,int j,int[][] dp,int[][] arr){
        if(i==m-1 && j==n-1) return arr[i][j];
        if(i>=m || j>=n) return Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        int right=helper(m,n,i,j+1,dp,arr);
        int left=helper(m,n,i+1,j,dp,arr);
        
        return dp[i][j]=arr[i][j] + Math.min(right,left);
    }
}