class Solution {
    int[] dp;
    public int distinctSubseqII(String s) {
        int mod=1000000007,n=s.length();
        dp=new int[n+1];
        int[] prev=new int[n+1];
        Arrays.fill(dp,-1);
        int[] lastseen=new int[26];

        for(int i=1;i<=n;i++){
            int idx=s.charAt(i-1)-'a';
            prev[i]=lastseen[idx];
            lastseen[idx]=i;
        }
        dp[0]=1;

        for(int i=1;i<=n;i++){
            int total=(int)(2*dp[i-1])%mod;

            if(prev[i]!=0){
                int duplicate=dp[prev[i]-1];
                total =(total-duplicate+mod)%mod;
            }

            dp[i]=total;

        }

        return (dp[n]-1+mod)%mod;

    }
}