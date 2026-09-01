class Solution {
    class Triplet implements Comparable<Triplet>{
        int node;
        int parent;
        int dist;
        Triplet(int node,int parent,int dist){
            this.node=node;
            this.parent=parent;
            this.dist=dist;
        }
        public int compareTo(Triplet t){
            if(this.dist==t.dist) return this.node-t.node;
            return this.dist-t.dist; //Integer.compare(this.dist,t.dist);
        }
    }
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Triplet> pq=new PriorityQueue<>();
        pq.add(new Triplet(0,-1,0));
        int sum=0,n=points.length;
        boolean[] visit=new boolean[n];

        while(pq.size()>0){
            Triplet top=pq.remove();
            int node=top.node,parent=top.parent,dist=top.dist;
            if(visit[node]==true) continue;
            sum+=dist;
            visit[node]=true;
            for(int i=0;i<n;i++){
                if(i==node || i==parent) continue;
                if(visit[i]==true) continue;
                int x1=points[node][0],y1=points[node][1];
                int x2=points[i][0],y2=points[i][1];
                int dis=Math.abs(x1-x2)+Math.abs(y1-y2);
                pq.add(new Triplet(i,node,dis));
            }
        }
        return sum;
    }
}