class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        if(targetSum==root.val &&(root.left==null && root.right==null)) return true;
        // if(targetSum<root.val) return false;

        return hasPathSum(root.left,targetSum-root.val)||hasPathSum(root.right,targetSum-root.val);
    }
}