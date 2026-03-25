class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m=grid.length,n=grid[0].length,mod=12345;
        int size= m*n;
        int[][] ans=new int[m][n];
        
        int[] flat=new int[size];
        int idx=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                flat[idx++]=grid[i][j]%mod;
            }
        }

        int[] prefix=new int[size];
        prefix[0]=1;
        for(int i=1;i<size;i++){
            prefix[i] = (prefix[i-1] * flat[i-1])%mod;
        }
        int[] suffix=new int[size];
        suffix[size-1]=1;
        for(int i=size-2;i>=0;i--){
            suffix[i] = (suffix[i+1]*flat[i+1])%mod;
        }

        idx=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans[i][j] = (suffix[idx]*prefix[idx])%mod;
                idx++;
            }
        }
        return ans;
    }
}