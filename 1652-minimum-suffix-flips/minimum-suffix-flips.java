class Solution {
    public int minFlips(String target) {
        int ans=0,n=target.length(),i=0;

        while(i<n && target.charAt(i)=='0'){
               i++;
           }

        for(int j=i;j<n;j++){
            while(j< n && target.charAt(j)=='1'){
               j++;
            }
            ans++;

            if(j<n){
            while(j<n && target.charAt(j)=='0'){
               j++;
            }
            ans++;
            }
            j--;
        }

        return ans;
    }
}