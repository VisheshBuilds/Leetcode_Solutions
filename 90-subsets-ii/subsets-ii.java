class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        boolean[] visited=new boolean[n];
        List<List<Integer>> ans=new ArrayList<>();

         //METHOD 1
        // helper(ans,visited,nums,new ArrayList<>(),0);

          //METHOD 2
        helper2(ans,nums,new ArrayList<>(),0);  
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

    public void helper2(List<List<Integer>> ans,int[] nums,List<Integer> temp,int s){
            ans.add(new ArrayList<>(temp));

        for(int i=s;i<nums.length;i++){
            if(i>s && nums[i-1]==nums[i]) continue;
            temp.add(nums[i]);
            helper2(ans,nums,temp,i+1);
            temp.remove(temp.size()-1);
        }

    }
}