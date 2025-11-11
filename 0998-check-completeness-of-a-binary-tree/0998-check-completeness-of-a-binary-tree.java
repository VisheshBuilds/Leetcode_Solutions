class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if(root==null) return true;
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        TreeNode prev=root;

        while(q.size()>0){
            TreeNode curr=q.poll();
            if(curr!=null){
                if(prev==null) return false;
                q.add(curr.left);
                q.add(curr.right);
            }
            prev=curr;
        }
        return true;
    }
}