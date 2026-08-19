class Solution {
    public int numberOfSubstrings(String s) {
        int ans=0,i=0,j=0,n=s.length();
        int[] c=new int[3];
        while(j<n){
            char ch=s.charAt(j);
            c[ch-'a']++;
            while(c[0]>0 && c[1]>0 && c[2]>0){
                ans +=n-j;
                c[s.charAt(i)-'a']--;
                i++;
            }
            j++;
        }
        return ans;
    }
}