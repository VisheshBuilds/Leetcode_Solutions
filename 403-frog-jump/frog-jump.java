class Solution {
    Boolean[][] dp;
    public boolean canCross(int[] stones) {
        if(stones[1]!=1) return false;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<stones.length;i++) map.put(stones[i],i);
        dp=new Boolean[2001][2001];

        return helper(stones,1,1,map);
    }
    public boolean helper(int[] stones,int i,int prevjump,
               HashMap<Integer,Integer> map){
        int l=stones.length;
        if(i>=l || prevjump<=0) return false;
        if(i==l-1) return true;
        
        if(dp[i][prevjump]!=null) return dp[i][prevjump];
        boolean p=false,c=false,n=false;
        if(map.containsKey(stones[i]+prevjump-1)){
            p=helper(stones,map.get(stones[i]+prevjump-1),prevjump-1,map);
        }
        if(map.containsKey(stones[i]+prevjump)){
            c=helper(stones,map.get(stones[i]+prevjump),prevjump,map);
        }
        if(map.containsKey(stones[i]+prevjump+1)){
            n=helper(stones,map.get(stones[i]+prevjump+1),prevjump+1,map);
        }
        
        return dp[i][prevjump]= p || c || n;
    }
}