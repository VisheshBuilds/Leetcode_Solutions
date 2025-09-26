class Solution {
    public void flatten(TreeNode root) {
        //METHOD 1(BASIC)
        List<TreeNode> list=new ArrayList<>();
         preorder(root,list);
         for(int i=1;i<list.size();i++){
            list.get(i-1).right=list.get(i);
            list.get(i-1).left=null;
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