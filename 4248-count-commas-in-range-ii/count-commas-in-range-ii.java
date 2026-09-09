class Solution {
    public long countCommas(long n) {
        if(n<1000) return 0;
        long ans=0,comma=1;
        long lower=1000;
        while(lower<=n){
            long upper=lower*1000 -1;
            if(upper>n) upper=n;
            long count=upper-lower+1;
            ans +=count*comma;
            comma++;
            lower=upper+1;
        }
        return ans;
    }
}