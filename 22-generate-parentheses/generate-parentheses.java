class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        helper(n,0,0,"",ans);
        return ans;
    }
    public void helper(int n,int l,int r,String s,List<String> ans){
        if(l==n && r==n){
            ans.add(s);
            return;
        }
        if(l>n || r>n) return;
        helper(n,l+1,r,s+'(',ans);
        if(r<l){
            helper(n,l,r+1,s+')',ans);
        }
    }
}