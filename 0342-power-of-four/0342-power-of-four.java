class Solution {
    public boolean isPowerOfFour(int n) {
        // if(n==1) return true;
        long i=1;
        while(i<=n){
           if(i==n) return true;
           i=i*4;
        }
        return false;
    }
}