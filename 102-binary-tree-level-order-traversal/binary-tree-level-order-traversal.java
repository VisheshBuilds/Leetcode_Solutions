class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;

        int n=level(root);
        Queue<TreeNode> q=new LinkedList<>();
        for(int i=0;i<n;i++) ans.add(new ArrayList<>());

        q.add(root);
        for(int i=0;i<n;i++){
            int k=q.size();
            while(k!=0){
                 TreeNode c=q.remove();
                 ans.get(i).add(c.val);
                 if(c.left!=null) q.add(c.left);
                 if(c.right!=null) q.add(c.right);
                 k--;
            }
        }
        
        return ans;
    }
    public int level(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(level(root.left),level(root.right));
    }
}