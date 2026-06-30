class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        boolean[] visited=new boolean[nums.length];
        Arrays.sort(nums);
        return backtrack(ans,new ArrayList<>(),nums,visited);
    }
    public List<List<Integer>> backtrack(List<List<Integer>> ans,List<Integer> tempList,int[] nums,boolean[] visited){
        if(tempList.size()==nums.length ){
            ans.add(new ArrayList<>(tempList));
        }
        else{
            for(int i=0;i<nums.length;i++){
                if(visited[i]) continue;
                if(i!=0 && nums[i]==nums[i-1] && !visited[i-1]) continue;
                visited[i]=true;
                tempList.add(nums[i]);
                backtrack(ans,tempList,nums, visited);
                tempList.remove(tempList.size()-1);
                visited[i]=false;
            }
        }
        return ans;
    }
}