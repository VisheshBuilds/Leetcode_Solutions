class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0,product=1,k=n;
        while(n > 0){
            int digit=n%10;
            sum +=digit;
            product *=digit;
            n /=10;
        }
        if(k %(sum+product)==0) return true;
        return false;
    }
}