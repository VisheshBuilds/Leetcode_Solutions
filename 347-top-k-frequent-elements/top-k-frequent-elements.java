class Solution {
    class Pair implements Comparable<Pair>{
        int key;
        int val;
        Pair(int key,int val){
            this.key=key;
            this.val=val;
        }
        public int compareTo(Pair p){
            return p.val-this.val;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        if(n==k) return nums;
        for(int ele:nums) map.put(ele,map.getOrDefault(ele,0)+1);

        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(int key:map.keySet()){
            int val=map.get(key);
            pq.add(new Pair(key,val));
        }
        int[] ans=new int[k];
        for(int i=0;i<k;i++){
            Pair top=pq.remove();
            ans[i]=top.key;
        }
        return ans;

    }
}