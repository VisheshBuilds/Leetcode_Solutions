class Solution {
    class Pair implements Comparable<Pair>{
        int num;
        int freq;
        Pair(int num,int freq){
            this.num=num;
            this.freq=freq;
        }
        public int compareTo(Pair p){
            if(this.freq==p.freq) return this.num -p.num;
            return this.freq -p.freq;
        }

    }
    public int[] findXSum(int[] nums, int k, int x) {
        int n=nums.length;
        int[] ans=new int[n-k+1];
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<k;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        ans[0]=getXSum(map,x);

        for(int i=k;i<n;i++){
            int out=nums[i-k];
            map.put(out,map.get(out)-1);
            if(map.get(out)==0) map.remove(out);
            int in=nums[i];
            map.put(in ,map.getOrDefault(in,0)+1);
            ans[i-k+1]=getXSum(map,x);

        }
        return ans;

    }
     private int getXSum(HashMap<Integer, Integer> map, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (var e : map.entrySet()) {
            pq.add(new Pair(e.getKey(), e.getValue()));
        }

        int sum = 0;
        int count = 0;
        while (!pq.isEmpty() && count < x) {
            Pair p = pq.poll();
            sum += p.num * p.freq; // multiply value by frequency if needed
            count++;
        }

        return sum;
    }
}