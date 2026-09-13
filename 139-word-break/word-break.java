class Solution {
    Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set=new HashSet<>();
        for(String key:wordDict) set.add(key);
        dp=new Boolean[301];
        // Arrays.fill(dp,-1);

        return check(s,set,0);
    }
    public boolean check(String s,HashSet<String> set,int idx){
        if(idx >= s.length()) return true;

        if(dp[idx] !=null) return dp[idx];

        for(int i=idx;i<s.length();i++){
            String temp=s.substring(idx,i+1);
            if(set.contains(temp)&& check(s,set,i+1)) return true;
        }
        return dp[idx]=false;
    }
}