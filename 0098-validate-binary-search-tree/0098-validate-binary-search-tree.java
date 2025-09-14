class Solution {
    public boolean flag;
    public long max(TreeNode root){
        if(root==null) return Long.MIN_VALUE;
        long a=root.val;
        long leftmax=max(root.left),rightmax=max(root.right);
        if(leftmax>=root.val ) flag=false;
        return Math.max(a,Math.max(leftmax,rightmax));
    }
    public long min(TreeNode root){
        if(root==null) return Long.MAX_VALUE;
        long a=root.val;
        long leftmin=min(root.left),rightmin=min(root.right);
        if( rightmin<=root.val) flag=false;
        return Math.min(a,Math.min(leftmin,rightmin));
    }
    public boolean isValidBST(TreeNode root) {
                    //METHOD 1 (BRUTE FORCE SELF)
        List<Integer> ans=new ArrayList<>();
        inorder(root,ans);
        boolean valid=true;
        for(int i=1;i<ans.size();i++){
          if(ans.get(i-1)>= ans.get(i)) valid=false;
        }
        return valid;

                    //METHOD 2(SIR)
        // flag=true;
        // max(root);
        // min(root);
        // return flag;    
    }
    public void inorder(TreeNode root,List<Integer> arr){
        if(root==null) return ;
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
    }
}