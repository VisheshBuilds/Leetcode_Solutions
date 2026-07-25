class Solution {
    public int maxProduct(int n) {
        int max1=0,max2=0;
        while(n>0){
            int num=n%10;
            if(max1 < num){
                max2=max1;
                max1=num;
            } 
            else if(max2 < num) max2=num;
            n=n/10;
        }
        return max1*max2;
    }
}