class Solution {
    // int[][] dp=new int[1001][1001];
    // public int solve1(String s,String t,int i,int j){
    //     if(j==t.length()) return 1;
    //     if(i==s.length()) return 0;
    //     if(s.charAt(i)==t.charAt(j)){
    //         return solve1(s,t,i+1,j+1)+solve1(s,t,i+1,j);
    //     }
    //     else return solve1(s,t,i+1,j);
    // }
    // public int solve2(String s,String t,int i,int j){
    //     if(j==t.length()) return dp[i][j]=1;
    //     if(i==s.length()) return dp[i][j]=0;
        
    //     if(dp[i][j]!=-1) return dp[i][j];
    //     if(s.charAt(i)==t.charAt(j)){
    //         return dp[i][j]=solve2(s,t,i+1,j+1)+solve2(s,t,i+1,j);
    //     }
    //     else return dp[i][j]=solve2(s,t,i+1,j);
    // }
    public int numDistinct(String s, String t) {
        if(s.length()<t.length()) return 0;
        int m=s.length(),n=t.length();
        //METHOD 1 (BRUTE FORCE)
        // return solve1(s,t,0,0);


        //METHOD 2(DP)
        // for(int i=0;i<1001;i++) Arrays.fill(dp[i],-1);
        // return solve2(s,t,0,0);

        //METHOD 3(TABULATION)
        int[][] dp=new int[m+1][n+1];

        for(int i=0;i<m+1;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<n+1;i++){
            dp[0][i]=0;
        }

        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                     dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }
}