class Solution {
    public int trap(int[] height) {
        int n=height.length,ans=0;
        int[] leftmax=new int[n];
        int[] rightmax=new int[n];

        leftmax[0]=0;
        for(int i=1;i<n;i++){
            leftmax[i]=Math.max(leftmax[i-1],height[i-1]);
        }

        rightmax[n-1]=0;
        for(int i=n-2;i>=0;i--){
            rightmax[i]=Math.max(rightmax[i+1],height[i+1]);
        }

        for(int i=0;i<n;i++){
            if(Math.min(leftmax[i],rightmax[i])-height[i] > 0){
                ans +=Math.min(leftmax[i],rightmax[i])-height[i];
            }
        }
        return ans;
    }
}