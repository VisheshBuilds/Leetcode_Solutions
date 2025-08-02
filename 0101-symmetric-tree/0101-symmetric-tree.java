class Solution {
    public boolean isSymmetric(TreeNode root) {
      if(root==null || (root.left==null && root.right==null)) return true;
      if(root.left==null || root.right==null) return false;
      if(root.left.val !=root.right.val) return false;
      TreeNode temp1=root.left,temp2=invert(root.right);
      
      return same(temp1,temp2);
    }
    public TreeNode invert(TreeNode root){
        if(root == null) return null;
        TreeNode temp1=root.left,temp2=root.right;
        root.left=temp2; root.right=temp1;
        invert(root.left);
        invert(root.right);
        return root;
    }
    public boolean same(TreeNode p,TreeNode q){
        if(p==null && q==null) return true;
        if((p!=null && q==null)||(p ==null && q!=null)) return false;
        if(p.val !=q.val) return false;
 
        return (same(p.left,q.left) && same(p.right,q.right));
    }
}