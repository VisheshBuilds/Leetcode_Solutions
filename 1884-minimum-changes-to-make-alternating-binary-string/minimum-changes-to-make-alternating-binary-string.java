class Solution {
    public int minOperations(String s) {
        int s0=0,s1=0;
        for(int i=0;i<s.length();i++){
            char e0=i%2==0 ? '0':'1';
            char e1=i%2==0 ? '1':'0';
            if(s.charAt(i)!= e0) s0++;
            if(s.charAt(i)!= e1) s1++;

        }
        return Math.min(s0,s1);
    }
}