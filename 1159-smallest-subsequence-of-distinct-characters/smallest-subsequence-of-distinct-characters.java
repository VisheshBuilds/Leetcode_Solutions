class Solution {
    public String smallestSubsequence(String s) {
        boolean[] stored=new boolean[26];
        int[] lastidx=new int[26];
        StringBuilder sb=new StringBuilder();
        int i=0,n=s.length();

        for(i=0;i<n;i++){
            char ch=s.charAt(i);
            lastidx[ch-'a']=i;
        }
        i=0;
        Stack<Character> st=new Stack<>();
        while(i<n){
            char ch=s.charAt(i);
            if (stored[ch - 'a']) {
                i++;
                continue;
            }
            if(st.isEmpty()){
                st.push(ch);
                stored[ch-'a']=true;
            }
            else {
                if(ch > st.peek()){
                    st.push(ch);
                    stored[ch-'a']=true;
                }
                else {
                    while(!st.isEmpty() && st.peek() > ch && lastidx[st.peek()-'a'] > i){
                        stored[st.peek()-'a']=false;
                        st.pop();
                    }
                    st.push(ch);
                    stored[ch-'a']=true;
                }
            }
            i++;
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}