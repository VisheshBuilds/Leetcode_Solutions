class Solution {
    public boolean areSimilar(int[][] mat, int k) {
             //METHOD 1

        int n=mat.length,m=mat[0].length;
        k=k%m;
        int[][] ans=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i%2==0){
                    ans[i][j]= mat[i][(j+k)%m];
                }
                else {
                     ans[i][j]= mat[i][(j-k+m)%m];
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(ans[i][j] != mat[i][j]) return false;
            }
        }
        return true;
  

        //   //METHOD 2
        // int n=mat.length,m=mat[0].length;
        // k=k%m;

        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         int x;
        //         if(i%2==0){
        //            x= mat[i][(j+k)%m];
        //         }
        //         else {
        //             x= mat[i][(j-k+m)%m];
        //         }
        //         if(mat[i][j]!=x) return false;
        //     }
        // }
        // return true;

    }
}