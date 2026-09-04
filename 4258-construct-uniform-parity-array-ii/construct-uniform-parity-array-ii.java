class Solution {
    public boolean uniformArray(int[] nums) {
        int even=0,odd=0,oddsmall=Integer.MAX_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]%2==0) even++;
            else {
                odd++;
                oddsmall=Math.min(oddsmall,nums[i]);
            }
        }
        if(even==n || odd==n) return true;
        for(int i=0;i<n;i++){
            if(nums[i]%2==0 && nums[i]<oddsmall){
               return false;
            }
        }
        return true;
    }
}