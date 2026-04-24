class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int ans=0,n=moves.length();
        int left=0,right=0;
        for(int i=0;i<n;i++){
            if(moves.charAt(i)=='L') left++;
            else if(moves.charAt(i)=='R') right++;
            else ans++;
        }
        return Math.abs(left-right)+ans;
    }
}