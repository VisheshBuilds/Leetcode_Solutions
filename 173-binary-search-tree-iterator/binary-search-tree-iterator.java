class BSTIterator {
    List<Integer> list;
    int pos;
    public BSTIterator(TreeNode root) {
        list=new ArrayList<>();
        inorder(root);
        pos=0;
    }
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    
    public int next() {
        pos++;
        return list.get(pos-1);
    }
    
    public boolean hasNext() {
        if(pos>=list.size()) return false;
        return true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */