class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length(),ans=0;
        HashMap<Character,Integer> map=new HashMap<>();
        int i=0,j=0,maxchar=0;
        while(j<n){
            char ch=s.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);
            maxchar=Math.max(maxchar,map.get(ch));
            while((j-i+1)-maxchar > k){
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                i++;
            }
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}