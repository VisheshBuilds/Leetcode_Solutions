class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
             //METHOD 1(RECURSIVE)
        // List<Integer> ans=new ArrayList<>();
        // inorder(root,ans);
        // return ans;

              //METHOD 2(USING STACK)
        List<Integer> ans=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        TreeNode temp=root;
        while(true){
            if(temp!=null){
                st.push(temp);
                temp=temp.left;
            }
            else{
                if(st.isEmpty()) break;
                TreeNode top=st.pop();
                ans.add(top.val);
                temp=top.right;
            }
        }
        return ans;

    }
    private static void inorder(TreeNode root,List<Integer> ans){
        if(root==null) return;  //base case
        inorder(root.left,ans);
        ans.add(root.val);
        inorder(root.right,ans);
    }
}