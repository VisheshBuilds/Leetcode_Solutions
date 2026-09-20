class Solution {
    public int reverseDegree(String s) {
        int ans=0,n=s.length();
        int[] freq=new int[26];
        for(int i=0;i<26;i++) freq[i]=26-i;
        
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            ans +=freq[ch-'a']*(i+1);
        }
        return ans;
    }
}