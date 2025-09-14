class Solution {
    public int count=0;
    public int kthSmallest(TreeNode root, int k) {
             //METHOD 1(SELF)
        // List<Integer> arr=new ArrayList<>();
        // inorder(root,arr);
        // return arr.get(k-1);

             //METHOD 2(SELF)
        return traverse(root,k);
    }
    public int traverse(TreeNode root,int k){
        if(root==null) return -1;
        
        int left=traverse(root.left,k);
        if(left!=-1) return left;
        count++;
        if(count==k) return root.val;
         return traverse(root.right,k);
    }
    public void inorder(TreeNode root,List<Integer> arr){
        if(root==null) return ;
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
        return;
    }
}