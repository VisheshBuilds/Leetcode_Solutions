class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums,k)-helper(nums,k-1);
    }
    public int helper(int[] nums,int k){
        if(k<0) return 0;
        int ans=0,i=0,j=0,n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(i<n){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            while(map.size()>k){
                int freq=map.get(nums[j]);
                if(freq==1) map.remove(nums[j]);
                else map.put(nums[j],freq-1);

                j++;
            }
            ans +=i-j+1;
            i++;
        }
        return ans;
    }
}