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
        // List<Integer> ans=new ArrayList<>();
        // inorder(root,ans);
        // boolean valid=true;
        // for(int i=1;i<ans.size();i++){
        //   if(ans.get(i-1)>= ans.get(i)) valid=false;
        // }
        // return valid;

                    //METHOD 2(SIR)
        // flag=true;
        // max(root);
        // min(root);
        // return flag;  

                   //METHOD 3(MORRIS TRAVERSAL)
        TreeNode prev=null;           
        TreeNode curr=new TreeNode();
        curr=root;
        while(curr!=null){
            if(curr.left!=null){
                TreeNode pred=curr.left;
                while(pred.right!=null && pred.right!=curr){
                    pred=pred.right;
                }
                if(pred.right==null){  //link
                    pred.right=curr;
                    curr=curr.left;
                }
                else{       //unlink
                    // ans.add(curr.val);
                    if(prev!=null && prev.val>=curr.val) return false;
                    prev=curr;
                    curr=curr.right;
                    pred.right=null;
                }
            }
            else {
                // ans.add(curr.val);  //visit
                if(prev!=null && prev.val>=curr.val) return false;
                prev=curr;
                curr=curr.right;
            }
        } 

        return true;            
    }
    public void inorder(TreeNode root,List<Integer> arr){
        if(root==null) return ;
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
    }
}