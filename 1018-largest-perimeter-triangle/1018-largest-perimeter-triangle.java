class Solution {
    public int largestPerimeter(int[] nums) {
        int ans=0,n=nums.length,i=0,j=1,k=2;
        Arrays.sort(nums);
        // for(int i=0;i<n-2;i++){
        //     for(int j=i+1;j<n-1;j++){
        //         for(int k=j+1;k<n;k++){
        //             int sum=nums[i]+nums[j]+nums[k];
        //             if(isValid(nums[i],nums[j],nums[k]) && ans<sum) ans=sum;
        //         }
        //     }
        // }

        while(k<n){
            int sum=nums[i]+nums[j]+nums[k];
            if(isValid(nums[i],nums[j],nums[k]) && ans<sum) ans=sum;
            i++; j++; k++;
        }


        return ans;
    }
    public boolean isValid(int x,int y,int z){
        if(x+y > z && x+z >y && y+z >x) return true;
        return false;
    }
}