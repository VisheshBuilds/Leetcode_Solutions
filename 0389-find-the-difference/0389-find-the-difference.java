class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character,Integer> map1=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }
        HashMap<Character,Integer> map2=new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }
        for(Character key:map2.keySet()){
           int val1=map1.getOrDefault(key,0);
           int val2=map2.get(key);
           if(val1!=val2) return key;
        }
        return 'a';
    }
}