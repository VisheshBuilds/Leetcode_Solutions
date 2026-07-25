class Solution {
    public int[] singleNumber(int[] nums) {
        int n=nums.length;
        long m=0;
        if(n==2) return nums;
        for(int num:nums) m ^=num;

        long diff=(m & (m-1)) ^ m;
        int one=0,zero=0;
        for(int i=0;i<n;i++){
            if((nums[i]& diff)>0){
                 one ^=nums[i];
            }
            else zero ^=nums[i];
        }

        


        return new int[]{one,zero};
    }
}