class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
             //METHOD 1(RECURSIVE)
        // List<Integer> ans=new ArrayList<>();
        // preorder(root,ans);
        // return ans;

             //METHOD 2(USING STACK)
        
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        if(root!= null) st.push(root);
        while(st.size()>0){
            TreeNode temp=st.pop();
            list.add(temp.val);

            if(temp.right!=null) st.push(temp.right);
            if(temp.left!=null) st.push(temp.left);
        }
        return list;
    }
    private static void preorder(TreeNode root,List<Integer> ans){
        if(root==null) return;  //base case
        // System.out.print (root.val + " ");
        ans.add(root.val);
        preorder(root.left,ans);
        preorder(root.right,ans);
    }
}