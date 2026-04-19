class Solution {
    public int mirrorDistance(int n) {
        if(n<10) return 0;
        String str=String.valueOf(n);
        String rev=new StringBuilder(str).reverse().toString();
        int num=Integer.valueOf(rev);

        return Math.abs(n-num);
    }
}