class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n=s.length(),i=0,j=0,count=0;
        String ans="";
        while(i<n){
            if(s.charAt(i)=='1') count++;

            while(count>k){
                if(s.charAt(j)=='1') count--;
                j++;
            }

            while(j<i && s.charAt(j)=='0') j++;

            if(count==k){
                String temp=s.substring(j,i+1);
                if( ans.length()==0 || temp.length() < ans.length() || (temp.length() == ans.length() && temp.compareTo(ans)<0 )){
                    ans=temp;
                }
            }
            i++;
        }
        return ans;
    }
}