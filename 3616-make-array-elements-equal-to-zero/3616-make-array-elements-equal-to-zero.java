class Solution {
    public int countValidSelections(int[] nums) {
        int n=nums.length,count=0;
        int[] left=new int[n];
        int[] right=new int[n];
        left[0]=nums[0];       right[n-1]=nums[n-1];
        for(int i=1;i<n;i++){
            left[i] =left[i-1] + nums[i];
            right[n-i-1] =right[n-i] +nums[n-i-1];
            } 

        for(int i=0;i<n;i++){
            if(nums[i]!=0) continue;
            if(left[i]==right[i]) count +=2;
            else if (Math.abs(left[i] - right[i]) == 1) count += 1;
        }
        return count;
    }
}