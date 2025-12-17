class Solution {
    public long getDescentPeriods(int[] prices) {
        long count=1,ans=0;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i]==prices[i+1]+1) {
                count++;
            }
            else {
                long tsa=(count * (count +1))/2;
                ans +=tsa;
                count=1;
            }
        }
        ans +=(count * (count + 1))/2;
        return ans;
    }
}