class Solution {
    public int bitwiseComplement(int n) {
        String b=Integer.toBinaryString(n);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<b.length();i++){
             if(b.charAt(i)=='0') sb.append('1');
             else sb.append('0');
        }
        int ans=Integer.parseInt(sb.toString(),2);
        return ans;
    }
}