class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans=new ArrayList<>();
        List<List<Integer>> adj=new ArrayList<>();
        int n=graph.length;
        int[] indegree=new int[n];

        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(graph[i][j]).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0) q.add(i);
        }
        while(!q.isEmpty()){
            int front=q.remove();
            ans.add(front);
            for(int ele:adj.get(front)){
                indegree[ele]--;
                if(indegree[ele]==0) q.add(ele);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}