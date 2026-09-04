class Solution {
    public int networkDelayTime(int[][] times, int n, int src) {
        int[] ans=new int[n+1];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[src]=0;
        for(int i=1;i<n;i++){
            for(int[] val:times){
                int u=val[0],v=val[1],wt=val[2];

                if(ans[u]!=Integer.MAX_VALUE && ans[v]> ans[u]+wt)
                   ans[v]=ans[u]+wt;
            }
        }

        int max=-1;
        for(int i=1;i<=n;i++){
            if(ans[i]==Integer.MAX_VALUE) return -1;
            max=Math.max(max,ans[i]);
        }
        return max;

    }
}