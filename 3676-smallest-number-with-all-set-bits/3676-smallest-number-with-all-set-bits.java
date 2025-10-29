class Solution {
    public int smallestNumber(int n) {
        int count=0,ans=0,j=1;
        while(n>0){
            count++;
            n=n/2;
        }
        for(int i=1;i<=count;i++){
            if(i==1) ans +=1;
            else {
                ans += 2*j;
                j *=2;
            }
        }
        return ans;
    }
}