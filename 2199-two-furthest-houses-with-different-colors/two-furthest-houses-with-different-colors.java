class Solution {
    public int maxDistance(int[] colors) {
        int n=colors.length;
        int max=0,j=n-1;
        for(int i=0;i<n;i++){
        while(i<j){
            if(colors[i]!=colors[j]) {
                max=Math.max(max, Math.abs(i-j));
                break;
            }    
            else j--;
        }
        j=n-1;
        }
        return max;
    }
}