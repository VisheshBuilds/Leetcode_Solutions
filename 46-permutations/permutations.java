class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        
        return helper(ans,new ArrayList<>(),nums);
    }
    public List<List<Integer>> helper(List<List<Integer>> ans,List<Integer> tempList,int[] nums){
        if(tempList.size()==nums.length){
            ans.add(new ArrayList<>(tempList));
        }
        else {
            for(int i=0;i<nums.length;i++){
                if(tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                helper(ans,tempList,nums);
                tempList.remove(tempList.size()-1);
            }
        }
        return ans;
    }
}