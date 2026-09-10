class Solution {
    int count=0;
    public int averageOfSubtree(TreeNode root) {
        helper(root);

        return count;
    }
    public int[] helper(TreeNode root){
        if(root==null) return new int[]{0,0};

        int[] left=helper(root.left);
        int[] right=helper(root.right);
        
        int sum=left[0]+right[0]+root.val;
        int size=left[1]+right[1]+1;
        int avg=sum/size;

        if(avg==root.val) count++;

        return new int[]{sum,size};
    }
}