class Solution {
    public int minimumDeletions(int[] nums) {
        int min=0,max=0,n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[min]> nums[i]) min=i;

            if(nums[max]<nums[i]) max=i;
        }

        if(min==max) return 1;
        int fromfront=Math.max(min,max)+1;
        int fromback=n-Math.min(min,max);
        int frombothend= Math.min(min,max)+1 + n-Math.max(min,max);

        return Math.min(fromfront,Math.min(fromback,frombothend));
    }
}