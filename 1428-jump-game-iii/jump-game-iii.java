class Solution {
    public boolean canReach(int[] arr, int start) {
        int n=arr.length,travel=0;
        if(start<0 || start>n-1) return false;
        if(arr[start]==0) return true;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        boolean[] visit=new boolean[n];
        pq.add(start);
        visit[start]=true;
        while(pq.size()>0){
            int top=pq.remove();
            if(arr[top]==0) return true;

            if((top + arr[top] >=0 && top +arr[top] <n )&& !visit[top+arr[top]]){
                pq.add(top+arr[top]);
                visit[top+arr[top]]=true;
            } 
            if((top - arr[top] >=0 && top -arr[top] <n )&& !visit[top-arr[top]]){
                pq.add(top-arr[top]);
                visit[top-arr[top]]=true;
            } 
        }
        return false;
    }
}