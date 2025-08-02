class Solution {
    private int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        traverse(root);
        return max;

    }
    public void traverse(TreeNode root){
        if(root==null) return;
        max=Math.max(max,levels(root.left)+levels(root.right));
        traverse(root.left);
        traverse(root.right);
    }
    public int levels(TreeNode root){
        if(root==null) return 0;
        return 1+ Math.max(levels(root.left),levels(root.right));
    }
}