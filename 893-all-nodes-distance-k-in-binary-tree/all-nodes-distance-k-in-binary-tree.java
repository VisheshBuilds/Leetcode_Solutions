class Solution {
    HashMap<TreeNode,TreeNode> parent=new HashMap<>();
    public void inorder(TreeNode root){
        if(root==null) return ;

        if(root.left!=null){
            parent.put(root.left,root);
        }
        inorder(root.left);
        if(root.right!=null){
            parent.put(root.right,root);
        }
        inorder(root.right);
    }
    public void helper(TreeNode target, int k,List<Integer> ans){
        Queue<TreeNode> q=new LinkedList<>();
        Set<TreeNode> visit=new HashSet<>();
        q.add(target);
        visit.add(target);

        while(q.size()>0){
            int n=q.size();
            if(k==0) break;
            
            while(n>0){
                TreeNode top=q.remove();
                
                if(top.left!=null && !visit.contains(top.left)){
                    visit.add(top.left);
                    q.add(top.left);
                }
                if(top.right!=null && !visit.contains(top.right)){
                    visit.add(top.right);
                    q.add(top.right);
                }
                if(parent.get(top)!=null && !visit.contains(parent.get(top))){
                    visit.add(parent.get(top));
                    q.add(parent.get(top));
                }
                n--;
            }
            k--;
        }

        while(q.size()>0){
            TreeNode top=q.remove();
            ans.add(top.val);
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans=new ArrayList<>();
        inorder(root);
        helper(target,k,ans);
        return ans;
    }
}