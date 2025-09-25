class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(root.val ==key){
           //Case 1: 0 Child
           if(root.left==null && root.right==null) return null;
           //Case 2: 1 Child
           else if(root.left==null || root.right==null){
            if(root.left==null) return root.right;
            else return root.left;
           }
           //Case 3:2 Child
           else {
                TreeNode pred=inorderPred(root);
                TreeNode parentPred=parent(root,pred);
                if(parentPred==root){
                    pred.right=parentPred.right;
                    return pred;
                }
                parentPred.right=pred.left;
                pred.left=root.left; pred.right=root.right;
                return pred;
           }
        }
        else if(root.val > key){
            root.left=deleteNode(root.left,key);
        }
        else {
            root.right=deleteNode(root.right,key);
        }
        return root;
    }
    public TreeNode inorderPred(TreeNode root){
        TreeNode temp=root.left;
        while(temp.right!=null) temp=temp.right;
        return temp;
    }
    public TreeNode parent(TreeNode root,TreeNode pred){
        if(root.right==pred || root.left==pred) return root;
        TreeNode temp=root.left;
        while(temp.right!=pred) temp=temp.right;
        return temp;
    }
}