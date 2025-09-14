class Solution {
       public boolean k=true,p=true;
    public long max(TreeNode root){
        if(root==null) return Long.MIN_VALUE;
        k=isvalid(root);
        long a=root.val,b=max(root.left),c=max(root.right);
        return Math.max(a,Math.max(b,c));
    }
    public long min(TreeNode root){
        if(root==null) return Long.MAX_VALUE;
        p=isvalid(root);
        long a=root.val,b=min(root.left),c=min(root.right);
        return Math.min(a,Math.min(b,c));
    }
    public boolean isValidBST(TreeNode root) {
                    //METHOD 1 (BRUTE FORCE SELF)
        // List<Integer> ans=new ArrayList<>();
        // inorder(root,ans);
        // boolean valid=true;
        // for(int i=1;i<ans.size();i++){
        //   if(ans.get(i-1)>= ans.get(i)) valid=false;
        // }
        // return valid;

                    //METHOD 2(SIR)
        if(root==null) return true;
        if(root.val >= min(root.right)) return false;
        if(root.val <=max(root.left)) return false;
        if(k==false || p==false) return false;
        return  isValidBST(root.left)&& isValidBST(root.right);     

    }

    public boolean isvalid(TreeNode root){
        if(root==null) return true;
        if(root.left!=null && root.val <= root.left.val){
           return false;
        }
        if(root.right!=null && root.val >= root.right.val){
           return false;
        }
        return true;
        // return isvalid(root.left) && isvalid(root.right);
    }

    public void inorder(TreeNode root,List<Integer> arr){
        if(root==null) return ;
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
        return;
    }
}