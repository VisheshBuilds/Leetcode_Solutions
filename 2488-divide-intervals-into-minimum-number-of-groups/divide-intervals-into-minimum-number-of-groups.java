class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> {
            if(a[0]!=b[0]) return a[0]-b[0];
            return a[1]-b[1];
        });
        int n=intervals.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int[] interval:intervals){
            if(!pq.isEmpty() && pq.peek()< interval[0]){
                pq.poll();
            }
            pq.add(interval[1]);
        }
        return pq.size();
    }
}

// class Solution {
//     public int minGroups(int[][] intervals) {

//         Arrays.sort(intervals, (a, b) -> {
//             if (a[0] != b[0])
//                 return Integer.compare(a[0], b[0]);
//             return Integer.compare(a[1], b[1]);
//         });

//         int n = intervals.length;
//         int count = 0;
//         boolean[] visit = new boolean[n];

//         for (int i = 0; i < n; i++) {

//             if (visit[i])
//                 continue;

//             visit[i] = true;
//             count++;

//             int ph = intervals[i][1];

//             for (int j = i + 1; j < n; j++) {

//                 if (!visit[j] && ph < intervals[j][0]) {

//                     visit[j] = true;

//                     // Update the last interval of this group
//                     ph = intervals[j][1];
//                 }
//             }
//         }

//         return count;
//     }
// }