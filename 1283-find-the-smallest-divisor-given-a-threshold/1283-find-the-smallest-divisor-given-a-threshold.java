class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int ans=0;
        int max=Integer.MIN_VALUE,min=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max) max=nums[i];
        }
        while(min <= max){
            int mid = min + (max - min) / 2;
            int check=helper(nums,mid);
            if(check <= threshold){
                ans=mid;
                max= mid-1;
            }
            else min=mid+1;
        }
        return ans;
    }
    public int helper(int[] nums,int mid){
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%mid==0) ans +=nums[i]/mid;
            else ans +=nums[i]/mid +1;
        }
        return ans;
    }
}