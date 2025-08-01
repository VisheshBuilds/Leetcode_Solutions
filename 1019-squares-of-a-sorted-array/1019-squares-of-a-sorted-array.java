class Solution {
    public int[] sortedSquares(int[] nums) {
                //METHOD 1

        // for(int i=0;i<nums.length;i++){
        //     nums[i] = nums[i]*nums[i];
        // }
        // Arrays.sort(nums);
        // return nums;

                //METHOD 2

        int n=nums.length;
        int[] ans=new int[n];
        int s=0,e=n-1;
        for(int i=n-1;i>=0;i--){
             if(Math.abs(nums[s])>=Math.abs(nums[e])){
                ans[i]=nums[s]*nums[s];
                s++;
             }
             else{
                ans[i]=nums[e]*nums[e];
                e--;
             }
        }
        return ans;
    }
}