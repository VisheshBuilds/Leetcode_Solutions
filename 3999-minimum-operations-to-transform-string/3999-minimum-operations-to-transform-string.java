class Solution {
    public int minOperations(String s) {
              //METHOD 1(SELF)
        // int[] alpha=new int[26];
        // for(int i=0;i<s.length();i++){
        //     char ch=s.charAt(i);
        //     alpha[ch-'a']++;
        // }
        // int ans=0;
        // for(int i=1;i<alpha.length;i++){
        //    if(alpha[i]!=0){
        //       ans=26-i;
        //       break;
        //    } 
        // }
        // return ans;

               //METHOD 2(SELF)

        int ans=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch!='a'){
            ans=Math.max(ans,26-(ch-'a'));
            }
        }       
        return ans;
    } 
}