class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int ans=0,n=cardPoints.length;
        int[] prefix=new int[n];

        prefix[0]=cardPoints[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+cardPoints[i];
        }

        if(n==k) return prefix[n-1];
        int j=n,right=0,left=0;
        while(k>=0){
            if(k>0) left=prefix[k-1];
            if(j<n) right +=cardPoints[j];

            ans=Math.max(ans,left+right);
            k--; j--; left=0;
        }
        return ans;
    }
}