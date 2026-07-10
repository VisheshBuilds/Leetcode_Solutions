class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(k,n,ans,new ArrayList<>(),1);
        return ans;
    }
    public void helper(int k,int target,List<List<Integer>> ans,List<Integer> temp,int s){
        if(temp.size()>k ) return;
        if(temp.size()==k && target==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(target<0) return;
        for(int i=s;i<=9;i++){
            if(i > target) continue;
            temp.add(i);
            helper(k,target-i,ans,temp,i+1);
            temp.remove(temp.size()-1);
        }
    }
}