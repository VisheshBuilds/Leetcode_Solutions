class Solution {
    public boolean judgeCircle(String moves) {
        int[] ans=new int[4];
        for(int i=0;i<moves.length();i++){
            char ch= moves.charAt(i);
            if(ch=='U') ans[0]++;
            else if(ch=='D') ans[1]++;
            else if(ch=='L') ans[2]++;
            else ans[3]++;
        }

        if(ans[0]==ans[1] && ans[2]==ans[3]) return true;
        return false;
    }
}