class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int count=0,n=trainers.length,m=players.length;
        for(int i=0;i<n;i++){
            pq.add(trainers[i]);
        }
        Arrays.sort(players);
        for(int i=0;i<m;i++){
            while(!pq.isEmpty() && pq.peek()< players[i]) pq.remove();
            if(!pq.isEmpty() && pq.peek()>= players[i]){
                count++;
                pq.remove();
            }
        }
        return count++;
    }
}