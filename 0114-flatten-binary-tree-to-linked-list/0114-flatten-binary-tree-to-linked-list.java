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
        TreeNode curr=root;
        while(curr!=null){
            if(curr.left!=null){
                TreeNode pred=curr.left;
                while(pred.right!=null){
                    pred=pred.right;
                }
                if(pred.right==null){
                    pred.right=curr.right;
                    TreeNode n=curr.left;
                    curr.right=curr.left;
                    curr.left=null;
                    curr=n;
                }
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
}