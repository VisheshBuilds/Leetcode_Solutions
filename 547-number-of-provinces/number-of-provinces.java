class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length,count=0;
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                bfs(visited,i,isConnected);
                count++;
            }
        }
        return count;
    }
    public void bfs(boolean[] visited,int num,int[][] isConnected){
        Queue<Integer> q=new LinkedList<>();
        q.add(num);
        visited[num]=true;
        while(!q.isEmpty()){
            int front=q.remove();
            for(int i=0;i<visited.length;i++){
                int val=isConnected[front][i];
                if(!visited[i] && val!=0){
                    q.add(i);
                    visited[i]=true;
                }
            }
        }
        
    }
}