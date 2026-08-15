class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length,m=matrix[0].length;
        int[][] mat=new int[n][m];
        for(int i=0;i<m;i++){
            int last=0;
            for(int j=0;j<n;j++){
                int val=(matrix[j][i]=='0')? 0:1;
                if(val==0){
                    mat[j][i]=0;
                    last=0;
                }
                else mat[j][i] = last + val;
                last=(val==0)? 0:mat[j][i];
            }
        }
        
        int ans=0;
        for(int i=0;i<n;i++){
            int[] nsl=new int[m];
            int[] nsr=new int[m];
            Stack<Integer> st=new Stack<>();
            for(int j=0;j<m;j++){
                while(!st.isEmpty() && mat[i][st.peek()]>mat[i][j]){
                    st.pop();
                }
                if(st.isEmpty()) nsl[j]=-1;
                else nsl[j]=st.peek();
                st.push(j);
            }
            st.clear();
            for(int j=m-1;j>=0;j--){
                while(!st.isEmpty() && mat[i][st.peek()]>=mat[i][j]){
                    st.pop();
                }
                if(st.isEmpty()) nsr[j]=m;
                else nsr[j]=st.peek();
                st.push(j);
            }

            for(int j=0;j<m;j++){
                ans= Math.max(ans,(nsr[j]-nsl[j]-1)*mat[i][j]);
            }
        } 
         
         return ans;
    }
}