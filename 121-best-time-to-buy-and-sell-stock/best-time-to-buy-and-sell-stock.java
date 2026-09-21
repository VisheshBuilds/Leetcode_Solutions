class Solution {
    public int maxProfit(int[] prices) {
        int mini=prices[0],n=prices.length,ans=0;
        for(int i=1;i<n;i++){
            if(mini>prices[i]) mini=prices[i];
            else{
                ans=Math.max(ans,prices[i]-mini);
            }
        }
        return ans;
    }
}