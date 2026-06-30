class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        return backtrack(ans,new ArrayList<>(),nums,0);
    }
    public List<List<Integer>> backtrack(List<List<Integer>> ans,List<Integer> tempList,int[] nums,int s){
        ans.add(new ArrayList<>(tempList));
        for(int i=s;i<nums.length;i++){
            tempList.add(nums[i]);
            backtrack(ans,tempList,nums,i+1);
            tempList.remove(tempList.size()-1);
        }
        return ans;
    }
}