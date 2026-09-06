class Solution {
    public int find(int a){
        if(parent[a]==a) return a;
        return find(parent[a]);
    }
    public void union(int a,int b){
        int leadA=find(a);
        int leadB=find(b);
        if(leadA!=leadB){
            parent[leadA]=leadB;
        }
    }
    int[] parent;
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        parent=new int[n+1];

        for(int i=1;i<=n;i++) parent[i]=i;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && isConnected[i][j]==1){
                    union(i+1,j+1);
                }
            }
        }
        int count=0;
        for(int i=1;i<=n;i++){
            if(parent[i]==i) count++;
        }

        return count;
    }
}