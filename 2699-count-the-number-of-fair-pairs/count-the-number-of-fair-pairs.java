class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return helper(nums,upper)-helper(nums,lower-1);
    }
    public long helper(int[] nums,int target){
        int i=0,j=nums.length-1;
        long count=0;
        while(i<j){
            if(nums[i]+nums[j]<=target){
                count +=j-i;
                i++;
            }
            else j--;
        }
        return count;
    }
}