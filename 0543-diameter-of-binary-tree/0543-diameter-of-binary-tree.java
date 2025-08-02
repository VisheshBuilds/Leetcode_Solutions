class Solution {
    private int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
               //method 1(self)
        // if(root==null) return 0;
        // traverse(root);
        // return max;


               //method 2 (sir)
        if(root==null) return 0;
        int mydia=levels(root.left)+levels(root.right);
        int leftdia=diameterOfBinaryTree(root.left);
        int rightdia=diameterOfBinaryTree(root.right);

        return Math.max(mydia,Math.max(leftdia,rightdia));      
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