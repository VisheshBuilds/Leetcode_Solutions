class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b)-> Integer.compare(a[1],b[1]));
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int totaltime=0;
        for(int i=0;i<courses.length;i++){
            if(courses[i][0] > courses[i][1]) continue;
            else{
                if(totaltime + courses[i][0] <= courses[i][1]){
                    pq.add(courses[i][0]);
                    totaltime +=courses[i][0];
                }
                else{
                    if(pq.peek() > courses[i][0]){
                        totaltime -=pq.remove();
                        totaltime +=courses[i][0];
                        pq.add(courses[i][0]);
                    }
                }
            }
        } 
        return pq.size();
    }
}