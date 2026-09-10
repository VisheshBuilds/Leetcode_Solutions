class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        
        return helper(root,limit,0);
    }
    public TreeNode helper(TreeNode root, int limit,int sum){
        if(root==null) return null;

        sum +=root.val;

        if(root.left==null & root.right==null){
            if(sum<limit) return null;
            return root;
        }

        root.left=helper(root.left,limit,sum);
        root.right=helper(root.right,limit,sum);
        
        if(root.left==null & root.right==null){
            return null;
        }
        
        return root;
    }
}