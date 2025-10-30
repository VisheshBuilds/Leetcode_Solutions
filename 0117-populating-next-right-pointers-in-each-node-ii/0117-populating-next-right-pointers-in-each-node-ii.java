class Solution {
    public Node connect(Node root) {
        helper(root);
        return root;
    }
    public void helper(Node root){
        if(root==null) return;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            Node prev=null;
            int size=q.size();
            for(int i=0;i<size;i++){
                Node curr=q.poll();
                if(prev!=null) prev.next=curr;
                prev=curr;
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            prev.next=null;
        }
        return;
    }
}