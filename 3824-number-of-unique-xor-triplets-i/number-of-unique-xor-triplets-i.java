class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n=nums.length,ans=1;
        if(n<=2) return n;
        while(ans <= n){
            ans <<=1;
        }
        return ans;
    }
}