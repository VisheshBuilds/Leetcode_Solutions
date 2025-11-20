class Solution {
    public int rob(int[] nums) {
                //TABULATION
        
        int n=nums.length;
        if(n==1) return nums[0];
        int ans1=helper(nums,0,n-1);
        int ans2=helper(nums,1,n);
        return Math.max(ans1,ans2);
    }
    public int helper(int[] nums,int l,int r){
        if(l>r) return 0;
        int len = r-l;
        if(len==1) return nums[l];
        int[] dp=new int[len];
        dp[0]=nums[l];
        dp[1]=Math.max(nums[l],nums[l+1]);
        for(int i=2;i<len;i++){
            dp[i]=Math.max(nums[l+i]+dp[i-2],dp[i-1]);
        }
        return dp[len-1];
    }
  
}