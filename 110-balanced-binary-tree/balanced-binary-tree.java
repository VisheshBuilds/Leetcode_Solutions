
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        return helper(root);
    }
    public boolean helper(TreeNode root){
        if(root==null) return true;
        if( Math.abs(level(root.left)-level(root.right)) >1 ) return false;
        return helper(root.left)&&helper(root.right);
    }
    public int level(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(level(root.left),level(root.right));
    }
}