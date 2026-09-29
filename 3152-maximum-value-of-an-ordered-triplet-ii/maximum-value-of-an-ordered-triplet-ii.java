class Solution {
    public long maximumTripletValue(int[] nums) {
        long ans=0;
        int n=nums.length;
        int[] prefix=new int[n];
        int[] suffmax=new int[n];

        prefix[0]=0;
        for(int i=1;i<n;i++){
            prefix[i]=Math.max(prefix[i-1],nums[i-1]);
        }
        
        suffmax[n-1]=0;
        for(int i=n-2;i>=0;i--){
            suffmax[i]=Math.max(suffmax[i+1],nums[i+1]);
        }

        for(int i=1;i<n-1;i++){
            long val=(long)(prefix[i]-nums[i])*suffmax[i];
            ans=Math.max(ans,val);
        }
        
        return ans;
    }
}