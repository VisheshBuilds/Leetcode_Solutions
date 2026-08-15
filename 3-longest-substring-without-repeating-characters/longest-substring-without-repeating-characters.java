class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans=0,n=s.length(),i=0,j=0;
        HashMap<Character,Integer> map=new HashMap<>();
        
        while(i<n){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.get(ch)>1){
                char c=s.charAt(j);
                map.put(c,map.get(c)-1);
                j++;
            }
            ans=Math.max(ans,i-j+1);
            i++;
        }
        return ans;
    }
}