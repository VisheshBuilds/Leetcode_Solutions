class Solution {
    public boolean doesAliceWin(String s) {
        int vwl=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') vwl++;
        }
        if(vwl==0) return false;
        return true;
    }
}