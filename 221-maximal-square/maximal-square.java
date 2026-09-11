class Solution {
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length,n=matrix[0].length,ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1') ans=1;
            }
        }
        int[][] mat=new int[m][n];
        for(int i=0;i<n;i++) mat[0][i]=(int)matrix[0][i]-'0';
        for(int i=0;i<m;i++) mat[i][0]=(int)matrix[i][0]-'0';

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                int val=Math.min(mat[i-1][j],Math.min(mat[i-1][j-1],mat[i][j-1]));
                if(matrix[i][j]!='0'){
                    mat[i][j] = val + 1;
                    ans=Math.max(ans,mat[i][j]);
                } 
                
            }
        }
        return ans*ans;
    }
}