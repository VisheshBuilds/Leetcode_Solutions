class Solution {
    public boolean isValidBST(TreeNode root) {
    //    if(root==null) return true;
    //    boolean ans=isvalid(root); 
    //    return ans;
        List<Integer> ans=new ArrayList<>();
        inorder(root,ans);
        boolean valid=true;
        for(int i=1;i<ans.size();i++){
          if(ans.get(i-1)>= ans.get(i)) valid=false;
        }
        return valid;
    }
    public boolean isvalid(TreeNode root){
        if(root==null) return true;
        if(root.left!=null && root.val <= root.left.val){
           return false;
        }
        if(root.right!=null && root.val >= root.right.val){
           return false;
        }
        return isvalid(root.left) && isvalid(root.right);
    }
    public void inorder(TreeNode root,List<Integer> arr){
        if(root==null) return ;
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
        return;
    }
}