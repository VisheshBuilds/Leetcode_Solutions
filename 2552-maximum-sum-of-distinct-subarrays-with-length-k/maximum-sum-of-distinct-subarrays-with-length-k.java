class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long ans=0,sum=0;
        int n=nums.length,i=0,j=0;
        HashSet<Integer> set=new HashSet<>();
        while(i<n){
            sum +=nums[i];
            while(j<i && set.contains(nums[i])){
                sum -=nums[j];
                set.remove(nums[j]);
                j++;
            }
            set.add(nums[i]);
            if(set.size()>k){
                set.remove(nums[j]);
                sum -=nums[j];
                j++;
            }
            if(set.size()==k) ans=Math.max(ans,sum);
            i++;
        }
        return ans;
    }
}