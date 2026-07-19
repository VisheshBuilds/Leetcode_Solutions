class Solution {
    public String removeDuplicateLetters(String s) {
        int n=s.length();
        boolean[] visit=new boolean[26];
        int[] lastidx=new int[26];

        for(int i=0;i<n;i++) lastidx[s.charAt(i)-'a']=i;
        
        Stack<Character> st=new Stack<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(visit[ch-'a']) continue;

            while(!st.isEmpty() && st.peek()>ch && lastidx[st.peek()-'a']>i){
                visit[st.pop()-'a']=false;
            }

            st.push(ch);
            visit[ch-'a']=true;
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()) sb.append(st.pop());

        return sb.reverse().toString();
    }
}