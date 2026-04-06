class Solution {
    public boolean judgeCircle(String moves) {
              //METHOD 1
        // int[] ans=new int[4];
        // for(int i=0;i<moves.length();i++){
        //     char ch= moves.charAt(i);
        //     if(ch=='U') ans[0]++;
        //     else if(ch=='D') ans[1]++;
        //     else if(ch=='L') ans[2]++;
        //     else ans[3]++;
        // }
        // if(ans[0]==ans[1] && ans[2]==ans[3]) return true;
        // return false;

             //METHOD 2
        int x=0,y=0;
        for(int i=0;i<moves.length();i++){
            char ch= moves.charAt(i);
            if(ch=='U') x++;
            else if(ch=='D') x--;
            else if(ch=='L') y++;
            else y--;
        }
        return x==0 && y==0;
    }
}