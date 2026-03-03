class Solution {
    public char findKthBit(int n, int k) {
        if(n==1) return '0';
        String s=new String("0");
        while(k > s.length()){
            s= s + '1' + rev_invert(s);
        }
        return s.charAt(k-1);
    }
    public String rev_invert(String s){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0') sb.append('1');
            else sb.append('0');
        }
        sb.reverse();
        return sb.toString();
    }
}