class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        return helper(preorder,inorder,0,n-1,0,n-1);
    }
    public TreeNode helper(int[] preorder, int[] inorder,int prelo,int prehi,int inlo,int inhi){
        if(inlo>inhi || prelo>prehi) return null;
        TreeNode root=new TreeNode(preorder[prelo]);
        int r=0;
        while(preorder[prelo]!=inorder[r]) r++;
        int leftsize=r-inlo;
        root.left=helper(preorder,inorder,prelo+1,prelo+leftsize,inlo,r-1);
        root.right=helper(preorder,inorder,prelo+leftsize+1,prehi,r+1,inhi);
        return root;
    }
}