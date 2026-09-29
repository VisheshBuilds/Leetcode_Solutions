class Solution {
    public String longestPalindrome(String s) {
        if(s.length()<2) return s;
        int maxlen=1,n=s.length();
        String maxstr=s.substring(0,1);

        for(int i=0;i<n;i++){
            for(int j=i+maxlen;j<=n;j++){
                if(j-i > maxlen && isPalindrome(s.substring(i,j))){
                    maxlen=j-i;
                    maxstr=s.substring(i,j);
                }
            }
        }
        return maxstr;
    }
    public boolean isPalindrome(String str){
        int left=0,right=str.length()-1;

        while(left<=right){
            if(str.charAt(left)!=str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}