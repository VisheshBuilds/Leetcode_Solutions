class Solution {
    class Pair {
        TreeNode root;
        int idx;
        Pair(TreeNode root,int idx){
            this.root=root;
            this.idx=idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Deque<Pair> pq=new ArrayDeque<>();
        pq.add(new Pair(root,0));
        int ans=0;
        while(pq.size()>0){
            int n=pq.size();
            int L=pq.getFirst().idx,R=pq.getLast().idx;
            ans=Math.max(ans,R-L+1);
            while(n>0){
                Pair p=pq.removeFirst();
                int level=p.idx;
                TreeNode r=p.root;
                if(r.left!=null){
                    pq.addLast(new Pair(r.left,2*level+1));
                }
                if(r.right!=null){
                    pq.addLast(new Pair(r.right,2*level+2));
                }
                n--;
            }
        }
        return ans;
    }
}