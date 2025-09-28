class Solution {
    public int bs(int[] nums,int l,int h,int target){
        int k=-1;
        while(l<=h){
            int mid=(h+l)/2;
            if(nums[mid]<target){
                k=mid;
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        return k;
    }
    public int triangleNumber(int[] nums) {
        int ans=0,n=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            if(nums[i]==0) continue;
            for(int j=i+1;j<n-1;j++){
                int k=bs(nums,j+1,n-1,nums[i]+nums[j]);
                if(k!=-1) ans +=k-j;
            }
        }
        return ans;
    }
}