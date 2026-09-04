class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length,sidx=-1;
        int[] ma=new int[n];
        int[] mi=new int[n];

        ma[0]=nums[0];
        for(int i=1;i<n;i++){
            ma[i]=Math.max(ma[i-1],nums[i]);
        }

        mi[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            mi[i]=Math.min(mi[i+1],nums[i]);
        }

        for(int i=0;i<n;i++){
            if(ma[i]-mi[i] <= k){
                sidx=i;
                break;
            }
        }

        return sidx;
    }
}