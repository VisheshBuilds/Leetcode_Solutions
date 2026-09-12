class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        if(n==1) return intervals;

        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));  
        List<int[]> ans=new ArrayList<>();

        for(int i=0;i<n;i++){
            int start=intervals[i][0],end=intervals[i][1];

            if(ans.size()>0 && end <= ans.get(ans.size()-1)[1]){
               continue;
            }
            for(int j=i+1;j<n;j++){
                if(intervals[j][0] <= end){
                    end=Math.max(end,intervals[j][1]);
                }
                else break;
            }

            ans.add(new int[]{start,end});
        }

        int len=ans.size();
        int[][] res=new int[len][2];
        for(int i=0;i<len;i++){
            res[i]=ans.get(i);
        }
         
         return res;
    }
}