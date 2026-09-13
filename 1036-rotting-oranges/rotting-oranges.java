class Solution {
    class Triplet implements Comparable<Triplet>{
        int i;
        int j;
        int time;
        Triplet(int i,int j,int time){
            this.i=i;
            this.j=j;
            this.time=time;
        }
        public int compareTo(Triplet t){
            return this.time-t.time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        PriorityQueue<Triplet> pq=new PriorityQueue<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2) pq.add(new Triplet(i,j,0));
            }
        }
        int maxtime=0;
        while(!pq.isEmpty()){
            Triplet top=pq.remove();
            int i=top.i,j=top.j,time=top.time;
            maxtime=Math.max(maxtime,time);
            

            if(i>0 && grid[i-1][j]==1){
                grid[i-1][j]=2;
                pq.add(new Triplet(i-1,j,time+1));
            }
            if(i<m-1 && grid[i+1][j]==1){
                grid[i+1][j]=2;
                pq.add(new Triplet(i+1,j,time+1));
            }
            if(j>0 && grid[i][j-1]==1){
                grid[i][j-1]=2;
                pq.add(new Triplet(i,j-1,time+1));
            }
            if(j<n-1 && grid[i][j+1]==1){
                grid[i][j+1]=2;
                pq.add(new Triplet(i,j+1,time+1));
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) return -1;
            }
        }

        return maxtime;
    }
}