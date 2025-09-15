class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        // Set<Character> set=new HashSet<>();
        //     for(int i=0;i<brokenLetters.length();i++){
        //     char ch=brokenLetters.charAt(i);
        //     set.add(ch);
        // }
        boolean[] broken = new boolean[26];
        for (int i = 0; i < brokenLetters.length(); i++) {
            broken[brokenLetters.charAt(i) - 'a'] = true;
        }

        String[] words=text.split(" ");
        int ans=0;
        for(String word:words){
            boolean flag=true;
            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                if(broken[ch-'a']){
                   flag=false;
                   break;
                }
            }
            if(flag) ans++;
        }
        return ans;
    }
}