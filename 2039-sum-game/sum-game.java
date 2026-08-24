class Solution {
    public boolean sumGame(String s) {
        int n=s.length();
        int leftsum=0,rightsum=0,leftqmark=0,rightqmark=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='?'){
                if(i< n/2) leftqmark++;
                else rightqmark++;
            }
            else{
                if(i< n/2) leftsum +=(int)(s.charAt(i)-'0');
                else rightsum +=(int)(s.charAt(i)-'0');
            }
        }
        if((leftqmark + rightqmark)%2 !=0) return true;

        int left=2*leftsum + 9*leftqmark;
        int right=2*rightsum + 9*rightqmark;

        if(left==right) return false;
        return true;
    }
}