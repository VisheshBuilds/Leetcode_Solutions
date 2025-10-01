class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int dB=numBottles,rb=numBottles,n=numExchange;
        while(rb >=n){
            int rem=rb%n;
            dB +=rb/n;
            rb = rb/n +rem;
        }
        return dB;
    }
}