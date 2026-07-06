class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n=intervals.length;
        int ans=n;
        boolean[] visit=new boolean[n];
        for(int i=0;i<n-1;i++){
            if(visit[i]) continue;
            for(int j=i+1;j<n;j++){
                if(visit[j]) continue;
                int a=intervals[i][0],b=intervals[i][1];
                int c=intervals[j][0],d=intervals[j][1];
                if(c<=a && b<=d){
                    ans--;
                    break;
                }
                else if(a<=c && d<=b){
                    ans--;
                    visit[j]=true;
                }
            }
        }
        return ans;
    }
}