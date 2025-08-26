class Solution {
    public int areaOfMaxDiagonal(int[][] arr) {
        int m=arr.length;
        double diag=Integer.MIN_VALUE;
        int res=0;
        for(int i=0;i<m;i++)
        {
            int len=arr[i][0];
            int bred=arr[i][1];
            double d=Math.sqrt(len*len + bred*bred);
            if(d==diag) 
            {
                diag=d;//
                res=Math.max(res,len*bred);//48
            }  
            else if(d>diag){
                diag=d;//
                res=len*bred;//48
            }           
        }
        return res;
    }
}