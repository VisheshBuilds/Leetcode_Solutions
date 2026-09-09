class Solution {
    public String countAndSay(int n) {
        String ans="1";
        for(int i=2;i<=n;i++){
            String temp=ans;
            ans=helper(temp);
        }
        return ans;
    }
    public String helper(String s){
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            int count=1;
            while(i<n-1 && s.charAt(i)==s.charAt(i+1)){
                count++; i++;
            }
            sb.append(count);
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}