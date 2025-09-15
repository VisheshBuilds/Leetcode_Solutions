
class Solution {
    public TreeNode balanceBST(TreeNode root) {
       // Method 1 (create a array then make balanced bst)
        List<Integer> arr=new ArrayList<>();
        inorder(root,arr);
        return helper(arr,0,arr.size()-1);

       //Mehtod 2 (Do not create a new tree)

    }
    public void inorder(TreeNode root,List<Integer> arr){
        if(root==null) return;
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
    }
    public TreeNode helper(List<Integer> nums,int i,int j){
        if(i>j) return null;
        int mid=(j+i)/2;
        TreeNode root=new TreeNode(nums.get(mid)); 
        root.left=helper(nums,i,mid-1);
        root.right=helper(nums,mid+1,j);
        return root;
    }
}