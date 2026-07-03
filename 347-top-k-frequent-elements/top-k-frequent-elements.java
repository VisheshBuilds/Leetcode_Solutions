class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(int key:map.keySet()){
            int val=map.get(key);
            pq.add(new Pair(key,val));
            if(pq.size()>k) pq.remove();
        }
        int[] ans=new int[k];
        int i=0;
        while(pq.size()>0){
            Pair p=pq.poll();
            ans[i]=p.num;
            i++;
        }
        return ans;

    }
    public class Pair implements Comparable<Pair>{
        int num;
        int freq;
        Pair(int num,int freq){
            this.num=num;
            this.freq=freq;
        }
        public int compareTo(Pair p){
            return this.freq-p.freq;
        }
    }
}