class Solution {
    private boolean ans;
    public boolean canFinish(int n, int[][] pre) {
        ans=true;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<pre.length;i++){
            int a=pre[i][0],b=pre[i][1];
            adj.get(b).add(a);
        }

        boolean[] visit=new boolean[n];
        boolean[] path=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visit[i]) dfs(i,adj,visit,path);
        }
           
        return ans;
    }
    public void dfs(int i,List<List<Integer>> adj,boolean[] visit,boolean[] path){
        visit[i]=true;
        path[i]=true;
        for(int ele:adj.get(i)){
            if(path[ele]==true){
                ans=false;
                return;
            }
            if(!visit[ele]) dfs(ele,adj,visit,path);
        }
        path[i]=false;
    }
}