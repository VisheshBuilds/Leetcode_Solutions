class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long upper=0,lower=0,total=0,left=0,right=0;
        int m=grid.length,n=grid[0].length;
        int[] row=new int[m];
        int[] col=new int[n];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                total +=grid[i][j];
                row[i] +=grid[i][j];
                col[j] +=grid[i][j];
            }
        }
         
        if(total %2!= 0) return false;

        for(int i=0;i<row.length;i++){
            upper +=row[i];
            lower=total-upper;
            if(upper == lower) return true;
        }
        for(int  i=0;i<col.length;i++){
            left +=col[i];
            right = total-left;
            if(left==right) return true;
        }
        return false;


    }
}