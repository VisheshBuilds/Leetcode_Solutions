class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
           //METHOD 1(RECURSIVE)
        // List<Integer> ans=new ArrayList<>();
        // postorder(root,ans);
        // return ans;

            //METHOD 2(USING STACK)
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        if(root!=null) st.push(root);
        while(st.size()>0){
            TreeNode temp=st.pop();
            list.add(temp.val);
            if(temp.left!=null) st.push(temp.left);
            if(temp.right!=null) st.push(temp.right);
        }
        Collections.reverse(list);
        return list;
    }
    private static void postorder(TreeNode root,List<Integer> ans){
        if(root==null) return;  //base case
        postorder(root.left,ans);
        postorder(root.right,ans);
        ans.add(root.val);

    }
}