class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<tasks.length;i++){
            map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
        }
        int ans=0;
        for(int key:map.keySet()){
            int value=map.get(key);
            if(value==1) return -1;
            ans +=helper(value,0);
        }
        return ans;
    }
    public int helper(int value,int step){
        // if(value==2 || value==3) return step+1;
        if(value%3==0) return step+value/3;
        else if(value%3==2) return step+value/3+1;
        return helper(value-2,step+1);
    }
}