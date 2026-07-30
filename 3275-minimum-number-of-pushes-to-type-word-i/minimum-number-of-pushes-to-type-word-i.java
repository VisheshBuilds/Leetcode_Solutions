class Solution {
    public int minimumPushes(String word) {
        int n=word.length(),ans=0;
        for(int i=0;i<n;i++){
            if(i<8) ans++;
            else if(i>=8 && i<=15) ans +=2;
            else if(i>=16 && i<=23) ans +=3;
            else ans +=4;
        }
        return ans;
    }
}