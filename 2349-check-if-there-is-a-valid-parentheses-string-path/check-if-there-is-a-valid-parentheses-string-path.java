class Solution {
    Boolean[][][] dp;
    public boolean hasValidPath(char[][] grid) {
        int m=grid.length,n=grid[0].length;
        if((m+n-1)%2!=0) return false;
        
        dp=new Boolean[m][n][m+n];

        return helper(grid,0,0,0);
    }
    public boolean helper(char[][] grid,int i,int j,int val){
        int m=grid.length,n=grid[0].length;
        if(i>=m || j>=n) return false;

        if(grid[i][j]=='(') val++;
        else val--;

        if(val<0) return false;
        if(i==m-1 && j==n-1) return val==0;

        int remaining=(m-i-1)+(n-j-1);
        if(val>remaining) return false;

        if(dp[i][j][val] != null) return dp[i][j][val];
        
        boolean res=helper(grid,i+1,j,val)|| helper(grid,i,j+1,val);
        return dp[i][j][val]=res;
    }
}