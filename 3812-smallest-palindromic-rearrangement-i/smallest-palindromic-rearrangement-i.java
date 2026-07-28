class Solution {
    public String smallestPalindrome(String s) {
        int n=s.length();
        int[] count=new int[26];
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            count[ch-'a']++;
        }
        StringBuilder left=new StringBuilder();
        char mid='0';
        for(int i=25;i>=0;i--){
            char ch=(char)('a'+i);
            if(count[i]%2 !=0){
                mid=ch;
                count[i]--;
            }
            while(count[i]!=0 ){
                left.append(ch);
                count[i] -=2;
            }
        }
        StringBuilder ans=new StringBuilder(new StringBuilder(left).reverse());
        if(mid!='0') ans.append(mid);
        ans.append(left);


        return ans.toString();
    }
}