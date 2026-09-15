class Solution {
    class Pair{
        int i;
        int parent;
        Pair(int i,int parent){
            this.i=i;
            this.parent=parent;
        }
    }
    public int findShortestCycle(int n, int[][] edges) {
        int ans=Integer.MAX_VALUE,m=edges.length;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<m;i++){
            int u=edges[i][0],v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for(int i=0;i<n;i++){
            boolean[] visit=new boolean[n];
            int[] count=new int[n];
            Queue<Pair> q=new LinkedList<>();

            count[i]=0;
            visit[i]=true;
            q.add(new Pair(i,-1));

            while(q.size()>0){
                Pair top=q.remove();
                int c=top.i,parent=top.parent;
                for(int ele:adj.get(c)){
                    if(ele==parent) continue;
                    if(visit[ele]){
                        ans=Math.min(ans,count[ele]+count[c]+1);
                        continue;
                    }
                
                    visit[ele]=true;
                    count[ele]=count[c]+1;
                    q.add(new Pair(ele,c));
                    
                }
            }
        }
        
        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
}