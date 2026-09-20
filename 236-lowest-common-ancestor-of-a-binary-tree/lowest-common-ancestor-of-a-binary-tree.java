class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p==root || q==root) return root;

        boolean pinleft=exist(root.left,p);
        boolean qinleft=exist(root.left,q);
        if(qinleft && pinleft ) return lowestCommonAncestor(root.left,p,q);
        if(!qinleft && !pinleft) return lowestCommonAncestor(root.right,p,q);

        return root;
    }
    public boolean exist(TreeNode root, TreeNode p){
        if(root==p) return true;
        if(root==null) return false;
        return exist(root.left,p)|| exist(root.right,p);
    }
}