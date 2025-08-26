class Solution {
    public int areaOfMaxDiagonal(int[][] arr) {
        int m=arr.length;
        double diaSq=Integer.MIN_VALUE;
        int res=0;
        for(int i=0;i<m;i++)
        {
            int len=arr[i][0];
            int bred=arr[i][1];
            int d=len*len + bred*bred;
            if(d==diaSq) 
            {
                res=Math.max(res,len*bred);
            }  
            else if(d>diaSq){
                diaSq=d;
                res=len*bred;
            }           
        }
        return res;
    }
}