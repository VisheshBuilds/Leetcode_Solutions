class Solution {
    public int triangularSum(int[] nums) {
        int j=1,n=nums.length-1;
        while(j<nums.length){
            for(int i=0;i<n;i++){
                nums[i]= (nums[i]+nums[i+1])%10;
            }
            n--; j++;
        }
        return nums[0]%10;  
    }
}