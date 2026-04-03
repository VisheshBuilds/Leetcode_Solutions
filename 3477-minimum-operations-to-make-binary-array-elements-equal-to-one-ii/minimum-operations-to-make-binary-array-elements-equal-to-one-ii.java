class Solution {
    public int minOperations(int[] nums) {
        int ans=0,i=0,n=nums.length;
        while(i< n && nums[i]==1){
               i++;
        }
        for(int j=i;j<n;j++){
            while(j< n && nums[j]==0){
               j++;
            }
            ans++;
            if(j<n){
                while(j< n && nums[j]==1){
                 j++;
                }
                ans++;
            }
            j--;
        }
        return ans;
    }
}