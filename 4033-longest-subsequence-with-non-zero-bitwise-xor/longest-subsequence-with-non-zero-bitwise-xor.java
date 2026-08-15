class Solution {
    public int longestSubsequence(int[] nums) {
        int n=nums.length,xor=0;
        boolean allzero=true;
        for(int i=0;i<n;i++){
            xor ^=nums[i];
            if(nums[i]!=0) allzero=false;
        }
        if(allzero) return 0;

        return xor==0 ? n-1:n;
    }
}