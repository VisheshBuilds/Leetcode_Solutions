class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        
        helper(0,ans,target,candidates,new ArrayList<>());
        return ans;
    }
    public void helper(int s,List<List<Integer>> ans,int target,int[] candidates,List<Integer> temp){
        if(target==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(s>=candidates.length || target<0) return;

        for(int i=s;i<candidates.length;i++){
            temp.add(candidates[i]);
            helper(i,ans,target-candidates[i],candidates,temp);
            temp.remove(temp.size()-1);
        }
    }
}