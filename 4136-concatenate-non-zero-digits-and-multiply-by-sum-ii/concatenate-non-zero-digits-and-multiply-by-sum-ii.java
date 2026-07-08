class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n=s.length(),m=queries.length;
        long mod = 1000000007L;
        long[] value = new long[n];
        long[] prefixsum = new long[n];
        int[] countdigit=new int[n];
        int[] ans=new int[m];
        long[] pow10 = new long[n+1];

        pow10[0] = 1;
        for(int i=1;i<=n;i++)
            pow10[i] = (pow10[i-1] * 10) % mod;

        countdigit[0]=s.charAt(0)=='0'? 0:1;
        for(int i=1;i<n;i++){
            if(s.charAt(i)=='0') countdigit[i]=countdigit[i-1];
            else countdigit[i]=countdigit[i-1]+1;
        }
        
        prefixsum[0]=s.charAt(0)- '0';
        for(int i=1;i<n;i++){
            prefixsum[i]= prefixsum[i-1] + (s.charAt(i)-'0');
        }
        
        value[0]=s.charAt(0)- '0';
        for(int i=1;i<n;i++){
            int val=(int)s.charAt(i)-'0';
            if(s.charAt(i)=='0') value[i]=value[i-1];
            else {
                value[i]=(value[i-1]*10 + val)%mod;
            }
        }

        for(int i=0;i<m;i++){
            int l=queries[i][0];
            int r=queries[i][1];

            if(l==0){
                ans[i] = (int)((value[r]*prefixsum[r])%mod);
            }
            else {
                long x = pow10[countdigit[r]-countdigit[l-1]];
                long sum=(prefixsum[r]-prefixsum[l-1] + mod)% mod;
                long val=(value[l-1]*x)% mod;
                long diff=(value[r] - val % mod +mod)%mod;
                ans[i]= (int) ((diff * sum)% mod);
            }
        }

        return ans;

    }
}