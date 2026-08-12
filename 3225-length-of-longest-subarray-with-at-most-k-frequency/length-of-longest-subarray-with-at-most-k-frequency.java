class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length,j=0,ans=0;
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);

            while(map.get(nums[i])>k){
                    int val=map.get(nums[j]);
                    map.put(nums[j],val-1);
                    j++;
                }
            ans =Math.max(ans,i-j+1);
        }
        return ans;
    }
}