
class Solution {
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        
        max=Math.max(max,level(root.left)+level(root.right));
        if(root.left!=null) diameterOfBinaryTree(root.left);
        if(root.right!=null) diameterOfBinaryTree(root.right);
        
        return max;
    }
    public int level(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(level(root.left),level(root.right));
    }
}