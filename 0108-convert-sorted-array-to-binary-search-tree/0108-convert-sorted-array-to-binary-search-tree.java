class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);  
    }
    public TreeNode helper(int[] nums,int i,int j){
        if(i>j) return null;
        int mid=(j+i)/2;
        TreeNode root=new TreeNode(nums[mid]); 
        root.left=helper(nums,i,mid-1);
        root.right=helper(nums,mid+1,j);
        return root;
    }
}