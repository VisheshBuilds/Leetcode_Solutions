class Solution {
    public String largestGoodInteger(String num) {
        String ans="";
        for(int i=0;i+2<num.length();i++){
           char ch=num.charAt(i);
           if(num.charAt(i)==num.charAt(i+1)&&num.charAt(i+1)==num.charAt(i+2)){
                String curr = "" + ch + ch + ch; // form the 3-digit substring
                if (ans.equals("") || curr.compareTo(ans) > 0) {
                ans = curr; // update if bigger
                }
            }
        }
      
        return ans;
    }
}