class Solution {
    public int countHomogenous(String s) {
        int ans=0,l=0,n=s.length(),mod=1000000007;
        for(int r=0;r<n;r++){
            if(s.charAt(l)==s.charAt(r)) ans = (ans + (r-l+1))%mod;
            else {
                l=r;
                ans++;
            }
        }
        return ans;
    }
}