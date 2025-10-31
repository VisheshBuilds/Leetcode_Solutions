class Solution {
    public class Pair implements Comparable<Pair>{
        int diff;
        int num;
        Pair(int diff,int num){
            this.diff=diff;
            this.num=num;
        }
        public int compareTo(Pair p){
            if(this.diff==p.diff) return this.num-p.num;
            return this.diff- p.diff;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>(Collections.reverseOrder());
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            int diff=Math.abs(arr[i]-x);
            pq.add(new Pair(diff,arr[i]));
            if(pq.size()>k) pq.remove();
        }
        while(pq.size()>0){
            Pair p=pq.poll();
            ans.add(p.num);
        }
        Collections.sort(ans);
        return ans;
    
    }
}