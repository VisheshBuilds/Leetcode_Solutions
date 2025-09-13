class Solution {
    public int maxFreqSum(String s) {
        int[] alpha=new int[26];
        int vwl=0,cnsnt=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            alpha[ch-'a']++;
            if(ch=='a'||ch=='e'||ch=='o'||ch=='i'||ch=='u'){
                if(vwl < alpha[ch-'a']) vwl=alpha[ch-'a'];
            }
            else {
                if(cnsnt<alpha[ch-'a']) cnsnt=alpha[ch-'a'];
            }
        }
        return vwl+cnsnt;
    }
}