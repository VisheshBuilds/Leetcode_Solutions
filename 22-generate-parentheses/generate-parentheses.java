class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        helper(ans,"",n,0,0);
        return ans;
    }
    public void helper(List<String> ans,String temp,int n,int l,int r){
        if(l==n && r==n){
            ans.add(temp);
            return;
        }
        if(l>n || r>n) return;

        if(l<=n) helper(ans,temp+'(',n,l+1,r);
        if(r<l) helper(ans,temp+')',n,l,r+1);
    }
}