class Solution {
    public int firstUniqChar(String s) {
        //METHOD 1(SELF)

        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            int val=map.get(ch);
            if(val==1) return i;
        }
        return -1;



        //METHOD 2(leetcode sol)

         
        // int[] freq = new int[26];
        // for (int i = 0; i < s.length(); i++) {
        //     freq[s.charAt(i) - 'a']++;
        // }
        // for (int j = 0; j < s.length(); j++) {
        //     if(freq[s.charAt(j) - 'a'] == 1) return j;
        // }
        // return -1;
    }
}