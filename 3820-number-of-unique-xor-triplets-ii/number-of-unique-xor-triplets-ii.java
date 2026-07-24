class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n=nums.length;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                set.add(nums[i]^nums[j]);
            }
        }
        HashSet<Integer> ans=new HashSet<>();
        for(int key: set){
            for(int i=0;i<n;i++){
                ans.add(key^nums[i]);
            }
        }

        return ans.size();
    }
}