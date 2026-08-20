class Solution {
    public class triplet implements Comparable<triplet> {
        int row;
        int col;
        int effort;
        triplet(int row,int col,int effort){
            this.row=row;
            this.col=col;
            this.effort=effort;
        }
        public int compareTo(triplet t){
            if(this.effort==t.effort){
                if(this.row==t.row) return this.col-t.col;
                return this.row-t.row;
            }
            return this.effort-t.effort;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int hrow=heights.length,hcol=heights[0].length;
        int[][] ans=new int[hrow][hcol];
        for(int i=0;i<hrow;i++) Arrays.fill(ans[i],Integer.MAX_VALUE);
        ans[0][0]=0;

        PriorityQueue<triplet> pq=new PriorityQueue<>();
        pq.add(new triplet(0,0,0));

        while(!pq.isEmpty()){
            triplet top=pq.remove();
            int r=top.row,c=top.col, eff=top.effort;
            if(r==hrow-1 && c==hcol-1) break;
            if(eff > ans[r][c]) continue;
            
            if(r-1>=0){
                int abs=Math.max(eff,Math.abs(heights[r][c]-heights[r-1][c]));
                if(abs < ans[r-1][c]){
                    ans[r-1][c]=abs;
                     pq.add(new triplet(r-1,c,abs));
                } 
            }
            if(r+1<hrow){
                int abs=Math.max(eff,Math.abs(heights[r][c]-heights[r+1][c]));
                if(abs < ans[r+1][c]){
                    ans[r+1][c]=abs;
                     pq.add(new triplet(r+1,c,abs));
                } 
            }
            if(c-1>=0){
                int abs=Math.max(eff,Math.abs(heights[r][c]-heights[r][c-1]));
                if(abs < ans[r][c-1]){
                    ans[r][c-1]=abs;
                     pq.add(new triplet(r,c-1,abs));
                } 
            }
            if(c+1<hcol){
                int abs=Math.max(eff,Math.abs(heights[r][c]-heights[r][c+1]));
                if(abs < ans[r][c+1]){
                    ans[r][c+1]=abs;
                     pq.add(new triplet(r,c+1,abs));
                } 
            }
        }
        return ans[hrow-1][hcol-1];
    }
}