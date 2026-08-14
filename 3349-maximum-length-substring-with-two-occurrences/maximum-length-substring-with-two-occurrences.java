class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int n=s.length(),i=0,j=0,ans=0;
        while(i<n){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.get(ch)>2){
                char c=s.charAt(j);
                map.put(c,map.get(c)-1);
                j++;
            }
            ans = Math.max(ans,i-j+1);
            i++;
        }
        return ans;
    }
}