class Solution {
        int[] parent;
    int[] size;
    public int find(int a){
        if(parent[a]==a) return a;
        return parent[a]=find(parent[a]);
    }
    public boolean union(int a,int b){
        a=find(a);
        b=find(b);
        if(a==b) return false;
        else{
            if(size[a]>size[b]){
                parent[b]=a;
                size[a]+=size[b];
            }
            else{
                parent[a]=b;
                size[b]+=size[a];
            }
        }
        return true;
    }
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
        ArrayList<Triplet> list=new ArrayList<>();
        int sum=0,n=points.length;
        parent=new int[n];
        size=new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }

        for(int u=0;u<n;u++){
            for(int v=u+1;v<n;v++){
                int x1=points[u][0],y1=points[u][1];
                int x2=points[v][0],y2=points[v][1];
                int dis=Math.abs(x1-x2)+Math.abs(y1-y2);
                list.add(new Triplet(u,v,dis));
            }
        }
        Collections.sort(list);

        for(int i=0;i<list.size();i++){
            Triplet top=list.get(i);
            int node=top.node,parent=top.parent,dist=top.dist;
            if(find(node)!=find(parent)){
                sum +=dist;
                union(node,parent);
            }
        }
        return sum;
    }
}