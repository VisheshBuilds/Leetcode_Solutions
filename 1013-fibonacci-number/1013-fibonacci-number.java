class Solution {
    static int[] dp;
    public int fib(int n) {
        dp=new int[n+1]; //0 to n
        return fibo(n);
    }
    public int fibo(int n){
        if(n<=1) return n;
        if(dp[n]!=0) return dp[n];  //directly return value
        int ans=fibo(n-1)+ fibo(n-2);
        dp[n]=ans;    //store the value
        return ans;
    }
}