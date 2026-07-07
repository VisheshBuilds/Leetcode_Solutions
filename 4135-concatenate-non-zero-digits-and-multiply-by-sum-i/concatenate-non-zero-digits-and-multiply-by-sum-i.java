class Solution {
    public long sumAndMultiply(int n) {
        long ans=0,i=1,sum=0;
        while(n>0){
           int rem=n%10;
           if(rem!=0){
            sum +=rem;
             ans = ans + rem*i;
             i *=10;
           }
           n /=10;
        }
        return ans*sum;
    }
}