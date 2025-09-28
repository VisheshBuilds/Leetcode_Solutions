class Solution {
    public int largestPerimeter(int[] nums) {
        int ans=0,n=nums.length,i=n-1,j=n-2,k=n-3;
        Arrays.sort(nums);
        while(k>=0){
            int sum=nums[i]+nums[j]+nums[k];
            if(nums[i]<nums[j]+nums[k]) return sum;
            i--;j--;k--;
        }
        return 0;
    }
    public boolean isValid(int x,int y,int z){
        if(x+y > z && x+z >y && y+z >x) return true;
        return false;
    }
}