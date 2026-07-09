class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int maxlen=0,i=0,j=0;
        for(j=0;j<s.length();j++){
            char ch=s.charAt(j);
              if(map.containsKey(ch) && map.get(ch)>=i){
                int len=j-i;
                maxlen= Math.max(len,maxlen);
                i=map.get(ch)+1;
              }
              map.put(ch,j);
        }
        int len=j-i;
        maxlen=Math.max(len,maxlen);
        return maxlen;
    }
}