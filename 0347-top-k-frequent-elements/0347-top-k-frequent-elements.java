class Solution {
    public int[] topKFrequent(int[] nums, int k) {
                //METHOD 1 
        // HashMap<Integer,Integer> map=new HashMap<>();
        // for(int i=0;i<nums.length;i++){
        //     map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        // }
        // int[][] arr=new int[map.size()][2];
        // int i=0;
        // for(int key:map.keySet()){
        //     arr[i][0]=key;
        //     arr[i][1]=map.get(key);
        //     i=i+1;
        // }
        // Arrays.sort(arr,(a,b)->b[1]-a[1]);
        
        // int[] ans=new int[k];
        // for(int j=0;j<k;j++){
        //     ans[j]=arr[j][0];
        // }
        // return ans; 

        //METHOD 2

        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(int key:map.keySet()){
            int value=map.get(key);
            pq.add(new Pair(key,value));
            if(pq.size()> k) pq.remove();
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