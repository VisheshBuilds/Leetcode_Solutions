class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums,k)-helper(nums,k-1);
    }
    public int helper(int[] nums,int k){
        if(k<0) return 0;
        int l=0,r=0,n=nums.length,sum=0,count=0;
        while(r<n){
            sum +=(nums[r]%2==0)? 0:1;
            while(sum>k){
                sum -=(nums[l]%2==0)? 0:1;
                l++;
            }
            count +=r-l+1;
            r++;
        }
        return count;
    }
}