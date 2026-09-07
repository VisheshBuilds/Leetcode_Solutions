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
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        parent=new int[n+1];
        size=new int[n+1];
        
        for(int i=1;i<=n;i++){
            parent[i]=i;
            size[i]=1;
        }

        for(int i=0;i<n;i++){
            if(!union(edges[i][0],edges[i][1])){
                return new int[]{edges[i][0],edges[i][1]};
            }
        }
        return new int[]{};
    }
}