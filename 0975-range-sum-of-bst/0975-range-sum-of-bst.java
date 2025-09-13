class Solution {
    public int sum=0;
    public int rangeSumBST(TreeNode root, int low, int high) {
                //METHOD 1(BASIC)
        // if(root==null) return 0;
        // int sum=rangeSumBST(root.left,low,high)+rangeSumBST(root.right,low,high); 
        // if(root.val <=high && root.val >=low) sum=sum+root.val;
        // return sum;

                //METHOD 2(USING PROP OF BST)
        // int sum=0;
        if(root==null) return 0;
        if(root.val < low) return rangeSumBST(root.right,low,high);
        else if(root.val > high) return rangeSumBST(root.left,low,high);
    
        return root.val +rangeSumBST(root.left,low,high) + rangeSumBST(root.right,low,high);
    }
}