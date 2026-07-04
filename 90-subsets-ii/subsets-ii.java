class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        boolean[] visited=new boolean[n];
        List<List<Integer>> ans=new ArrayList<>();
        helper(ans,visited,nums,new ArrayList<>(),0);
        return ans;
    }
    public void helper(List<List<Integer>> ans,boolean[] visited,int[] nums,List<Integer> temp,int s){
        if(!ans.contains(temp))
            ans.add(new ArrayList<>(temp));

        for(int i=s;i<nums.length;i++){
            if(visited[i]) continue;
            temp.add(nums[i]);
            visited[i]=true;
            helper(ans,visited,nums,temp,i+1);
            temp.remove(temp.size()-1);
            visited[i]=false;
        }

    }
}