class Solution {
    public void flatten(TreeNode root) {
                //METHOD 1(BASIC)
        // List<TreeNode> list=new ArrayList<>();
        // preorder(root,list);
        // for(int i=1;i<list.size();i++){
        //     list.get(i-1).right=list.get(i);
        //     list.get(i-1).left=null;
        // }

                //METHOD 2(MORRIS)
        // TreeNode curr=root;
        // while(curr!=null){
        //     if(curr.left!=null){
        //         TreeNode pred=curr.left;
        //         while(pred.right!=null){
        //             pred=pred.right;
        //         }
        //         if(pred.right==null){
        //             pred.right=curr.right;
        //             TreeNode n=curr.left;
        //             curr.right=curr.left;
        //             curr.left=null;
        //             curr=n;
        //         }
        //     }
        //     else {
        //          curr=curr.right;
        //     }
        // }  

              //METHOD 3(RECURSIVE)
        //  helper(root);

            //METHOD 4(MORRIS TRAVRSAL SIR METHOD)
        TreeNode curr=root;
        while(curr!=null){
            if(curr.left!=null){
                TreeNode r=curr.right;
                curr.right=curr.left;
                TreeNode pred=curr.left;
                while(pred.right!=null) pred=pred.right;
                pred.right=r;
                curr.left=null;
                curr=curr.right;
            }
            else {
                curr=curr.right;
            }
        }  

    }
    public void preorder(TreeNode root,List<TreeNode> list){
        if(root==null) return;
        list.add(root);
        preorder(root.left,list);
        preorder(root.right,list);
        return;
    }
    public void helper(TreeNode root){
        if(root==null) return ;
        if(root.left==null && root.right==null) return;
        TreeNode lst=root.left;
        TreeNode rst=root.right;
        helper(root.left); helper(root.right);
        root.left=null;
        root.right=lst;
        TreeNode temp=root;
        while(temp.right!=null){
            temp=temp.right;
        }
        temp.right=rst;
    }
}