class Solution {
    HashMap<Integer,Integer> map=new HashMap<>();
    Boolean[][] dp;
    public boolean canCross(int[] stones) {
        int n=stones.length;
        if(stones[1]!=1) return false;
        dp=new Boolean[2001][2001];

        
        for(int i=0;i<n;i++) map.put(stones[i],i);
        
        return helper(1,1,stones);
    }
    public boolean helper(int prevjump,int curridx,int[] stones){
        if(curridx==stones.length-1) return true;
        if(!map.containsKey(stones[curridx])) return false;
        if(dp[curridx][prevjump]!=null) return dp[curridx][prevjump]; 
        
        boolean res=false;
        for(int jump=prevjump-1;jump<=prevjump+1;jump++){
            if(jump<=0) continue;
            int val=stones[curridx]+jump;
            if(map.containsKey(val)){
                res=res|| helper(jump,map.get(val),stones);
            }
        }
        
        return dp[curridx][prevjump]=res;
    }
}