class Solution {
    public int maxOperations(String s) {
        int ans=0,ones=0;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='1'){
                ones++;
                if(s.charAt(i+1)=='0'){
                    ans +=ones;
                }
            }
        } 
        return ans;
    }
}