class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
              //METHOD 1(SELF)
    //    TreeNode temp=new TreeNode(val);
    //     if(root==null) return temp;
    //     helper(root,val);
    //     return root;

              //METHOD 2(SIR)
        if(root==null) return new TreeNode(val);
        if(root.val<val) root.right=insertIntoBST(root.right,val);
        else root.left=insertIntoBST(root.left,val);
        return root;
    }
    public void helper(TreeNode root, int val){
       TreeNode temp=new TreeNode(val);

        if(root.val > val && root.left ==null) {
            root.left=temp;
            return;
        }
        if(root.val < val && root.right ==null) {
            root.right=temp;
            return ;
        }
        if(root.val < val)  helper(root.right,val);
        if(root.val > val)  helper(root.left,val); 
        return;
    } 
}