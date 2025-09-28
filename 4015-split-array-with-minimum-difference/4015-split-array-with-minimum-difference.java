class Solution {
    public long splitArray(int[] nums) {
       int n=nums.length;
        if(n<2) return -1;
        boolean[] prefixinc=new boolean[n];
        boolean[] suffixdec=new boolean[n];
        long[] prefixsum=new long[n];
        long[] suffixsum=new long[n];

        prefixsum[0]=nums[0];
        prefixinc[0]=true;
        for(int i=1;i<n;i++){
            prefixsum[i]=nums[i]+prefixsum[i-1];
            if(prefixinc[i-1] && (nums[i]>nums[i-1])){
                prefixinc[i]=true;
            }
        }

        suffixsum[n-1]=nums[n-1];
        suffixdec[n-1]=true;
        for(int i=n-2;i>=0;i--){
            suffixsum[i]=nums[i]+suffixsum[i+1];
            if(suffixdec[i+1] && (nums[i]>nums[i+1])){
                suffixdec[i]=true;
            }
        }

        long ans=Long.MAX_VALUE;
        for(int i=0;i<n-1;i++){
            if(prefixinc[i] && suffixdec[i+1]){
                ans=Math.min(ans,Math.abs(prefixsum[i]-suffixsum[i+1]));
            }
        }
        return ans==Long.MAX_VALUE ? -1:ans;
    }
}