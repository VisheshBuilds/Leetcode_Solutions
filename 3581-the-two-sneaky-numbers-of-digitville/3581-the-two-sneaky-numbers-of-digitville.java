class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] ans=new int[2];
        int j=0;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                ans[j]=nums[i];
                j++;
                if(j==2) break;
            }
            set.add(nums[i]);
        }
        return ans;
    }
}