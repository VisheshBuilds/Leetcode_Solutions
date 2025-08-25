class Solution {
    public int level(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(level(root.left),level(root.right));
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        return preorder(root);
    }
    public boolean preorder(TreeNode root){
        if(root==null) return true;
        if(Math.abs(level(root.left)-level(root.right))>1) return false;
        if(!preorder(root.left)) return false;
        if(!preorder(root.right)) return false;
        return true;
    }
}