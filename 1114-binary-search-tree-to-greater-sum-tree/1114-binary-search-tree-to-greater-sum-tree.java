class Solution {
    public int sum=0;
    public TreeNode bstToGst(TreeNode root) {
        helper(root);
        return root;
    }
    public void helper(TreeNode root){
        if(root==null){
            return ;
        } 
        helper(root.right);
        root.val +=sum;
        sum =root.val;
        helper(root.left);
        return;
    }
}