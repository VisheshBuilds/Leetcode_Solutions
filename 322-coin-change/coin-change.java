class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] mincoin=new int[amount+1];
        Arrays.fill(mincoin,amount+1);
        mincoin[0]=0;
        int n=coins.length;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<n;j++){
                if(i-coins[j]>=0){
                    mincoin[i]=Math.min(mincoin[i],1+mincoin[i-coins[j]]);
                }
            }
        }
        return mincoin[amount]==amount+1 ? -1:mincoin[amount];
    }
}