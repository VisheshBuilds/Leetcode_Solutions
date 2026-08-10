class Solution {
    public int countHomogenous(String s) {
        // M1
        // int ans=0,l=0,n=s.length(),mod=1000000007;
        // for(int r=0;r<n;r++){
        //     if(s.charAt(l)==s.charAt(r)) ans = (ans + (r-l+1))%mod;
        //     else {
        //         l=r;
        //         ans++;
        //     }
        // }
        // return ans;


        //M2
         
        int ans=0,len=0,mod=1000000007,n=s.length();
        for(int i=0;i<n;i++){
            if(i>0 && s.charAt(i)==s.charAt(i-1)) len++;
            else len=1;

            ans = (ans+len)%mod;
        }
        return ans;
    }
}