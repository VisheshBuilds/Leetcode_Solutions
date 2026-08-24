class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map=new int[26];
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b) -> b-a);

        for(int i=0;i<tasks.length;i++) map[tasks[i]-'A']++;

        for(int i=0;i<26;i++){
            if(map[i]>0) pq.add(map[i]);
        }

        int ans=0;
        while(!pq.isEmpty()){
            int taskcycle=0,cycle=n+1;
            List<Integer> list=new ArrayList<>();
            while(cycle >0 && !pq.isEmpty()){
                int top=pq.remove();
                top--;
                taskcycle++;
                cycle--;
                if(top>0) list.add(top);
            }

            for(int ele:list) pq.add(ele);

            ans +=pq.isEmpty()?  taskcycle : n+1; 
        }
        return ans;
    }
}