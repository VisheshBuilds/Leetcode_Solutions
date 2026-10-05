class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=inorder.length;
        return helper(inorder,postorder,0,n-1,0,n-1);
    }
    public TreeNode helper(int[] inorder, int[] postorder,int inlo,int inhi,int polo,int pohi){
        if(inlo>inhi || polo>pohi) return null;
        TreeNode root=new TreeNode(postorder[pohi]);
        int idx=0;
        while(postorder[pohi]!=inorder[idx]) idx++;
        int len=idx-inlo;

        root.left=helper(inorder,postorder,inlo,idx-1,polo,polo+len-1);
        root.right=helper(inorder,postorder,idx+1,inhi,polo+len,pohi-1);

        return root;
    }
}