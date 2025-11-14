class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] mat=new int[n][n];
        for(int i=0;i<queries.length;i++){
            int a=queries[i][0]; int b=queries[i][1];  int c=queries[i][2]; int d=queries[i][3];
             for(int  j=a;j<=c;j++){
                for(int k=b;k<=d;k++){
                    mat[j][k] +=1;
                }
             }
        }
        return mat;
    }
}