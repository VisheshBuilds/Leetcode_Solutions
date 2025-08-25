class Solution {
    static boolean ans;
    public int level(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(level(root.left),level(root.right));
    }
    public boolean preorder(TreeNode root){
        if(root==null) return true;
        if(Math.abs(level(root.left)-level(root.right))>1) return false;
        if(!preorder(root.left)) return false;
        if(!preorder(root.right)) return false;
        return true;
    }
    public int levels(TreeNode root){
        if(root==null) return 0;
        int lst=levels(root.left);
        int rst=levels(root.right);
        int diff=Math.abs(lst-rst);
        if(diff>1) ans=false;
        return 1+Math.max(lst,rst);
    }
    public boolean isBalanced(TreeNode root) {
                //METHOD 1(SELF)

        // if(root==null) return true;
        // return preorder(root);

                //METHOD 2(SIR)
        // if(root==null) return true;
        // if(Math.abs(level(root.left)-level(root.right))>1) return false;
        // return isBalanced(root.left) && isBalanced(root.right);
               
               //METHOD 3(SIR)
         
         ans=true;
         levels(root);
         return ans;

    }
  
}