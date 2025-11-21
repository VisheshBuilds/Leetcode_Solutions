class Solution {
    public int countPalindromicSubsequence(String s) {
        int count=0;
        HashMap<Character,Integer> map1=new HashMap<>();
        HashMap<Character,Integer> map2=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!map1.containsKey(ch)) map1.put(ch,i);
            map2.put(ch,i);
        }

        for(char ch: map1.keySet()){
            int idx1=map1.get(ch);
            int idx2=map2.get(ch);
            HashSet<Character> set=new HashSet<>();
            for(int i=idx1+1;i<idx2;i++){
                set.add(s.charAt(i));
            }
            count +=set.size();
        }
 
     return count;
    }
}