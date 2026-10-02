
class Solution {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;

        int left=countleft(root.left);
        int right=countright(root.right);
        if(left==right) return (1 << (left+1))-1;

        return countNodes(root.left) + countNodes(root.right) +1;
    }
    public int countleft(TreeNode root){
        if(root==null) return 0;
        return 1+countleft(root.left);
    }
    public int countright(TreeNode root){
        if(root==null) return 0;
        return 1+countright(root.right);
    }
}