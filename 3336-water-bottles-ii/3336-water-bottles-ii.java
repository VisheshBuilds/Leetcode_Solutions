class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int dB=numBottles,rb=numBottles,n=numExchange;
        while(rb >=n){
            int rem=rb-n;
            dB +=1;
            rb = rem+1;
            n++;
        }
        return dB;
    }
}