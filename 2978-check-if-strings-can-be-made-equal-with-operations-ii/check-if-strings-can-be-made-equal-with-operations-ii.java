class Solution {
    public boolean checkStrings(String s1, String s2) {
        HashMap<Character,Integer> map_even=new HashMap<>();
        HashMap<Character,Integer> map_odd=new HashMap<>();

        for(int i=0;i<s1.length();i++){
            if(i%2==0) map_even.put(s1.charAt(i),map_even.getOrDefault(s1.charAt(i),0)+1);
            else map_odd.put(s1.charAt(i),map_odd.getOrDefault(s1.charAt(i),0)+1);
        }
        for(int i=0;i<s2.length();i++){
            if(i%2==0){
                if(map_even.getOrDefault(s2.charAt(i),0)==0) return false;
                map_even.put(s2.charAt(i),map_even.get(s2.charAt(i))-1);
            } 
            else {
                if(map_odd.getOrDefault(s2.charAt(i),0)==0) return false;
                map_odd.put(s2.charAt(i),map_odd.get(s2.charAt(i))-1);
            }
        }
        return true;

    }
}