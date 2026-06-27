class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
                     //Method 1
        // int n=arr.length,m=queries.length;
        // int[] ans=new int[m];
        // for(int i=0;i<m;i++){
        //     int left=queries[i][0],right=queries[i][1];
        //     for(int j=left;j<=right;j++){
        //          ans[i]^=arr[j];
        //     }
        // }
        // return ans;


                     //Method 2
        int n=arr.length,m=queries.length;
        for(int i=1;i<n;i++){
           arr[i]^=arr[i-1];
        }    
        int[] ans=new int[m];
        for(int i=0;i<m;i++){
            int left=queries[i][0],right=queries[i][1];
            if(left==0) ans[i] = arr[right];
            else ans[i] = arr[left-1]^arr[right];
        }         
        return ans;
    }
}