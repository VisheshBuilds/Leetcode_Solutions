class Solution {
    // public int sum=0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null) return 0;
        int sum=rangeSumBST(root.left,low,high)+rangeSumBST(root.right,low,high); 
        if(root.val <=high && root.val >=low) sum=sum+root.val;
        return sum;

    }
}