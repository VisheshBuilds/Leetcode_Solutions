class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=inorder.length;
        return helper(inorder,postorder,0,n-1,0,n-1);
    }
    public TreeNode helper(int[] inorder, int[] postorder,int postlo,int posthi,int inlo,int inhi){
        if(postlo>posthi || inlo> inhi) return null;
        TreeNode root=new TreeNode(postorder[posthi]);
        int r=0;
        while(postorder[posthi]!= inorder[r]) r++;
        int leftsize=r-inlo;
        root.left=helper(inorder,postorder,postlo,postlo+leftsize-1,inlo,r-1);
        root.right=helper(inorder,postorder,postlo+leftsize,posthi-1,r+1,inhi);
        return root;
    }
}