class Solution {
    public int smallestNumber(int n, int t) {
        int rem=1,num=0;
        for(int i=n;i<=(n+10);i++){
            rem=1;
            num=i;
            while(num>0){
                rem= rem*(num%10);
                num /=10;
            }
            if(rem%t==0) return i;
        }
        return rem;
    }
}