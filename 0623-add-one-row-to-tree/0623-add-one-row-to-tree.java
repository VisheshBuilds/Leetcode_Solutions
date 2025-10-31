class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        TreeNode newroot=new TreeNode(val);
        if(depth==1) {
            newroot.left=root;
            return newroot;
        }
        helper(root,val,depth);
        return root;
    }
    public void helper(TreeNode root, int val, int depth){
        TreeNode newroot=new TreeNode(val);
        if(root==null) return;

        if(depth==2){
            TreeNode newleft=new TreeNode(val);
            TreeNode newright=new TreeNode(val);
            // if(root.left==null && root.right==null){
            //     root.left=newleft; root.right=newright;
            //     return;
            // }
            if(root.left!=null) newleft.left=root.left;
            if(root.right !=null) newright.right=root.right;
            if(root.left!=null) root.left=newleft; 
            if(root.right !=null) root.right=newright;
            if(root.right==null) root.right=newright;
            if(root.left==null) root.left=newleft;
            return;
        }
        helper(root.left,val,depth-1);
        helper(root.right,val,depth-1);

    }
}