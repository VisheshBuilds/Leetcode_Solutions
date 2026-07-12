class Solution {
    public int minimumCost(int[] nums, int k) {
        Long mod=1000000007L;
        long ans=0,x=k;
        for(int i:nums){
            if(x<i){
                long add=(i-x+k-1L)/k;
                ans +=add;
                x +=add*k;
            }
            x -=i;
        }
        return (int)((((ans%mod)*((ans+1)%mod))/2)%mod);
    }
}