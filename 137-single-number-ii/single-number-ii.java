class Solution {
    public int singleNumber(int[] nums) {
        int ans=0,n=nums.length;
        for(int k=0;k<32;k++){
            int zero=0,ones=0;
            for(int i=0;i<n;i++){
                int val=(1<<k) & nums[i];
                if(val==0) zero++;
                else ones++;
            }
            if(ones%3==1){
                ans = ans | (1<<k);
            }
            
        }
        return ans;
    }
}