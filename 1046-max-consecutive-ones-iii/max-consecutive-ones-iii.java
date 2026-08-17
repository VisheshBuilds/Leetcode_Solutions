class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length,max=0,zero=0,j=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0) zero++;
            while(zero>k){
                if(nums[j]==0) zero--;
                j++;
            }
            
            max=Math.max(max,i-j+1);
        }
        return max;
    }
}