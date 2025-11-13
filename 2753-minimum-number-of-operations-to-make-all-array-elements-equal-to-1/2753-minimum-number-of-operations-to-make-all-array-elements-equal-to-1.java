class Solution {
    public int minOperations(int[] nums) {
        int gcd=nums[0],n=nums.length,ones=0,diff=0;
        for(int i=0;i<n;i++){
            if(nums[i]==1) ones++;
            else diff++;

            gcd=GCD(gcd,nums[i]);
        }
        if(ones!=0) return diff;
        if(gcd!=1) return -1;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n-1;i++){
           gcd=nums[i];
           for(int j=i+1;j<n;j++){
               gcd=GCD(gcd,nums[j]);
               if(gcd==1){
                  ans=Math.min(ans,j-i+ diff-1);
                  break;
               }
           }
        }

        return ans;
    }
    public int GCD(int a,int b){
        if(b==0) return a;
        return GCD(b,a%b);
    }
}