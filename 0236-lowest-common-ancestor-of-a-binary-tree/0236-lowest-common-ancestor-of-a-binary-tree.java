class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p==root || q==root) return root;
        boolean pinLST=exist(root.left,p);
        boolean qinLST=exist(root.left,q);
        if(qinLST==true && pinLST==true) return lowestCommonAncestor(root.left,p,q);
        if(qinLST==false && pinLST==false) return lowestCommonAncestor(root.right,p,q);
        else return root;
    }
    public boolean exist(TreeNode root,TreeNode k){
        if(root == k) return true;
        if(root==null) return false;
        return exist(root.left,k)||exist(root.right,k);
    }
}