class Solution {
    public long countCommas(long n) {
        if(n<1000) return 0;
        long ans=0;
        if(n> 999) ans +=n-999;
        if(n> 999999) ans +=n-999999;
        if(n> 999999999) ans +=n-999999999;
        if(n> 999999999999L) ans +=n-999999999999L;
        if(n> 999999999999999L) ans +=n-999999999999999L;

        return ans;
    }
}