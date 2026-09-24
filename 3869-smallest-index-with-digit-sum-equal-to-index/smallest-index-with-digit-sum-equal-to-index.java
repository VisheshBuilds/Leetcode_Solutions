class Solution {
    public int smallestIndex(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            int val=digit(nums[i]);
            if(val==i){
                return i;
            }
        }
        return -1;
    }
    public int digit(int n){
        int sum=0;
        while(n>0){
             sum +=n%10;
             n /=10;
        }
        return sum;
    }
}