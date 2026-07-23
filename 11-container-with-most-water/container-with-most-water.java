class Solution {
    public int maxArea(int[] height) {
        int n=height.length,ans=0;
        int i=0,j=n-1;
        while(i<j){
            int h=Math.min(height[i],height[j]);
            int w=j-i;
            ans = Math.max(ans,h*w);

            if(height[i] <= height[j]) i++;
            else j--;
        }
        return ans;
    }
}