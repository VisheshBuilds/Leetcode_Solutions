class Solution {
    public int numSub(String s) {
              //METHOD 1 (TLE)
        // int ans=0;
        // for(int i=0;i<s.length();i++){
        //     int j=i;
        //     if(s.charAt(i)=='1'){
        //         while(j<s.length() && s.charAt(j)=='1'){
        //             j++;
        //         }
        //         ans +=((j-i)*(j-i+1))/2;
        //     }
        //     i=j-1;
        // }
        // return ans;


                //METHOD 2 
        int ans=0,mod=1000000007,count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                count++;
                ans = (ans + count)%mod;
            }
            else count=0;
        }
        return ans;        
    }
}
