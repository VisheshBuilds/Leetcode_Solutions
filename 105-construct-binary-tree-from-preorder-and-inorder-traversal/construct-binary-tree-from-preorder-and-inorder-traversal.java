
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        return helper(preorder,inorder,0,n-1,0,n-1);
    }
    public TreeNode helper(int[] preorder, int[] inorder,int prelo,int prehi,int inlo,int inhi) {
        if(prelo>prehi || inlo > inhi) return null;
        TreeNode root=new TreeNode(preorder[prelo]);
        int r=0;
        while(inorder[r]!=preorder[prelo]) r++;
        int ls=r-inlo;
        root.left=helper(preorder,inorder,prelo+1,prelo+ls,inlo,r-1);
        root.right=helper(preorder,inorder,prelo+ls+1,prehi,r+1,inhi);
        return root;
    }
}