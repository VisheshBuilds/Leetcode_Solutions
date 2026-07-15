class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int prefix=1,ans=0;
        int n=nums.length,i=0,j=0;
        if(k<=1) return 0;
        
        while(j<n){
            prefix *=nums[j];
            if(prefix >= k) {
                while(prefix >=k){
                    prefix =prefix/nums[i];
                    i++;
                }
            }
            ans +=j-i+1;
            j++;
        }
        return ans;
    }
}