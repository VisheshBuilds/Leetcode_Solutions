class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        helper(0,ans,candidates,target,new ArrayList<>());
        return ans;
    }
        public void helper(int s,List<List<Integer>> ans,int[] candidates,int target,List<Integer> temp){
        if(target==0){
            // if(ans.contains(temp)) return;
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(s>=candidates.length){
            return;
        }
        if(target<0) return;
        for(int i=s;i<candidates.length;i++){
            if (i > s && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > target) break; 
             temp.add(candidates[i]);
             helper(i+1,ans,candidates,target-candidates[i],temp);
             temp.remove(temp.size()-1);
        }

    }
}