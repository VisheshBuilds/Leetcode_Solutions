class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return same(p,q);
    }
    public boolean same(TreeNode p,TreeNode q){
        if(p==null && q==null) return true;
        if((p!=null && q==null)||(p ==null && q!=null)) return false;
        if(p.val !=q.val) return false;
 
        if((p.left !=null && q.left==null)||(p.left ==null && q.left!=null)) return false;
        if((p.right !=null && q.right==null)||(p.right ==null && q.right!=null)) return false;
        if(((p.left!=null && q.left!=null) && (q.left.val!=q.left.val ))||((p.right!=null && q.right!=null) && (q.right.val!=q.right.val ))){
           return false;
        }

        return (same(p.left,q.left) && same(p.right,q.right));
    }
}