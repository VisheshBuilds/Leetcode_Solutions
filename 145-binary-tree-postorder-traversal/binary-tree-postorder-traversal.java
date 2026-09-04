class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        st.push(root);
        TreeNode curr=root;
        while(!st.isEmpty()){
            TreeNode c=st.pop();
            ans.add(c.val);
            if(c.left!=null) st.push(c.left);
            if(c.right!=null) st.push(c.right);
        }
        Collections.reverse(ans);
        return ans;
    }
}