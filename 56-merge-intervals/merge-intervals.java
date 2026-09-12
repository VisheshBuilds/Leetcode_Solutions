class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        if(n==1) return intervals;

        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));  
        List<int[]> ans=new ArrayList<>();

        for(int i=0;i<n;i++){

            if(!ans.isEmpty() && intervals[i][0]<=ans.get(ans.size()-1)[1]){
                ans.get(ans.size()-1)[1]=Math.max(ans.get(ans.size()-1)[1],intervals[i][1]);
            }
            else{
                ans.add(new int[]{intervals[i][0],intervals[i][1]});
            }

        }

        int len=ans.size();
        int[][] res=new int[len][2];
        for(int i=0;i<len;i++){
            res[i]=ans.get(i);
        }
         
         return res;
    }
}