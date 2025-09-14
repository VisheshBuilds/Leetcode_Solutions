class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
       TreeNode temp=new TreeNode(val);
        if(root==null) return temp;
        helper(root,val);
        return root;
    }
    public void helper(TreeNode root, int val){
       TreeNode temp=new TreeNode(val);

        if(root.val > val && root.left ==null) {
            root.left=temp;
            return;
        }
        if(root.val < val && root.right ==null) {
            root.right=temp;
            return ;
        }
        if(root.val < val)  helper(root.right,val);
        if(root.val > val)  helper(root.left,val); 
        return;
    } 
}