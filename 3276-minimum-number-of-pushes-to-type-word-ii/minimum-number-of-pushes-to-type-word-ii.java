class Solution {
    public int minimumPushes(String word) {
        int ans=0,count=1,n=word.length();
        int[] cnt=new int[26];
        for(int i=0;i<n;i++){
            char ch=word.charAt(i);
            cnt[ch-'a']++;
        }
        Arrays.sort(cnt);
        for(int i=25;i>=0;i--){
            if(count<9){
                ans +=cnt[i]*1;
                count++;
            }
            else if(count>=9 && count<=16){
                ans +=cnt[i]*2;
                count++;
            }
            else if(count>=17 && count<=24){
                ans +=cnt[i]*3;
                count++;
            }
            else {
                ans +=cnt[i]*4;
                count++;
            }
        }

        return ans;
    }
}