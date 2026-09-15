
class Solution {
    int ans=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        helper(root);
        return ans;
    }
    public int helper(TreeNode root){
        if(root==null) return 0;

        int left=helper(root.left);
        int right=helper(root.right);

        ans=Math.max(ans,left+right+root.val);
        ans=Math.max(ans,root.val);
        ans=Math.max(ans,root.val+left);
        ans=Math.max(ans,root.val+right);

        return Math.max(root.val,root.val+Math.max(left,right));
    }
}