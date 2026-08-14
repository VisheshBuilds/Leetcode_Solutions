class Solution {
    public int[] findOrder(int n, int[][] p) {
        int[] ans=new int[n];
        List<List<Integer>> adj=new ArrayList<>();
        int[] indegree=new int[n];

        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<p.length;i++){
            int a=p[i][0],b=p[i][1];
            adj.get(b).add(a);
            indegree[a]++;
        }
        
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0) q.add(i);
        }
        int i=0;
        while(!q.isEmpty()){
            int front=q.remove();
            ans[i]=front;
            i++;
            for(int ele:adj.get(front)){
                indegree[ele]--;
                if(indegree[ele]==0) q.add(ele);
            }
        }

        return (i==n)? ans:new int[0];
    }
}