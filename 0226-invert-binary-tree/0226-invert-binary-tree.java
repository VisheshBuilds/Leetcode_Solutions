/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        return invert(root);
    }
    public TreeNode invert(TreeNode root){
        if(root == null) return null;
        TreeNode temp1=root.left,temp2=root.right;
        root.left=temp2; root.right=temp1;
        invert(root.left);
        invert(root.right);
        return root;
    }
}