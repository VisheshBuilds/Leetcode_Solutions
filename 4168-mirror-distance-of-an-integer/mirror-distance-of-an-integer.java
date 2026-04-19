class Solution {
    public int mirrorDistance(int n) {
                //METHOD 1
        // if(n<10) return 0;
        // String str=String.valueOf(n);
        // String rev=new StringBuilder(str).reverse().toString();
        // int num=Integer.valueOf(rev);
        // return Math.abs(n-num);
        
               //METHOD 2
        int num=0,x=n;
        while(n>0){
            int rem=n%10;
            num = num*10 + rem;
            n /=10;
        }
        return Math.abs(x-num);
    }
}