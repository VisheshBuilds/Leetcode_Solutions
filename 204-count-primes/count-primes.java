class Solution {
    public int countPrimes(int n) {
        if(n<2) return 0;
        int ans=0;
        boolean[] notPrime=new boolean[n];
        for(int i=2;i<n;i++){
            if(notPrime[i]) continue;
            else {
                ans++;
                for(int j=i;j<n;j +=i){
                    notPrime[j]=true;
                }
            }
        }
        return ans;
    }
}