class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> set=new HashSet<>();
        for(int i=0;i<brokenLetters.length();i++){
            char ch=brokenLetters.charAt(i);
            set.add(ch);
        }
        String[] words=text.split(" ");
        int ans=0;
        for(String word:words){
            boolean flag=true;
            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                if(set.contains(ch)){
                   flag=false;
                   break;
                }
            }
            if(flag) ans++;
        }
        return ans;
    }
}