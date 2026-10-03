class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res=new ArrayList<>();
        
        int i=0,n=intervals.length;
        while(i<n && intervals[i][1] < newInterval[0]){
            res.add(intervals[i]);
            i++;
        }
        int s=newInterval[0],e=newInterval[1];
        while(i<n && intervals[i][0] <= e ){
            s=Math.min(s,intervals[i][0]);
            e=Math.max(e,intervals[i][1]);
            i++;
        }
        res.add(new int[]{s,e});

        while(i<n){
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][]);
    }
}