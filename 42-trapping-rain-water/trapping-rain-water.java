class Solution {
    public int trap(int[] height) {
        int n=height.length,max=-1;
        int[] left=new int[n];
        int[] right=new int[n];
        for(int i=0;i<n;i++){
            if(max==-1) {
                left[i]=-1;
                max=height[i];
            }
            else if(max>height[i]){
                left[i]=max;
            }
            else{
                left[i]=height[i];
                max=height[i];
            }
        }
        max=-1;
        for(int i=n-1;i>=0;i--){
            if(max==-1) {
                right[i]=-1;
                max=height[i];
            }
            else if(max>height[i]){
                right[i]=max;
            }
            else{
                right[i]=height[i];
                max=height[i];
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            int val=Math.min(left[i],right[i]);
            if(val-height[i]>0){
                count +=val-height[i];
            }
        }
        return count;
    }
}