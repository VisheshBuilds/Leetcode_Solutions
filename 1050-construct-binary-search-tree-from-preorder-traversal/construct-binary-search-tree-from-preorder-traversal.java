
class Solution {

    public TreeNode bstFromPreorder(int[] preorder) {
        int n=preorder.length;
        int[] inorder=preorder.clone();
        Arrays.sort(inorder);

        return helper(preorder,inorder,0,n-1,0,n-1);
    }
    public TreeNode helper(int[] preorder,int[] inorder,int inlo,int inhi,int prelo,int prehi){
        if(prelo>prehi || inlo>inhi) return null;
        int idx=inlo;
        while(preorder[prelo]!=inorder[idx]) idx++;
        TreeNode root=new TreeNode(preorder[prelo]);
        int leftsize=idx-inlo;

        root.left=helper(preorder,inorder,inlo,idx-1,prelo+1,prelo+leftsize);
        root.right=helper(preorder,inorder,idx+1,inhi,prelo+leftsize+1,prehi);
        return root;
    }
}