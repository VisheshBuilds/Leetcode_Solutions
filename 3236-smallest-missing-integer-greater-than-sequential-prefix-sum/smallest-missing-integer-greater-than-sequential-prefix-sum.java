class Solution {
    public int missingInteger(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int max=nums[0],n=nums.length;
        for(int i=1;i<n;i++){
            if(nums[i]==nums[i-1]+1) max +=nums[i];
            else break;
        }
        for(int ele:nums) set.add(ele);
        while(set.contains(max)){
            max++;
        }
        return max;
    }
}