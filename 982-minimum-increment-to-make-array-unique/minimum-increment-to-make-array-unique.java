class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int ans=0,n=nums.length;
        HashSet<Integer> set=new HashSet<>();
        set.add(nums[0]);
        for(int i=1;i<n;i++){
            int val=0;
            if(set.contains(nums[i])){
                val=nums[i-1]+1;
                ans +=val-nums[i];
                nums[i]=val;
            }
            
            set.add(nums[i]);
        }
        return ans;
    }
}