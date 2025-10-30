/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        helper(root);
        return root;
    }
    public void helper(Node root){
        if(root==null) return;
        if(root.next !=null) {
            if(root.next.val<-1000 && root.next.val>1000) root.next=null;
        }
        Node prev=root.left;
        Node nxt=root.right;
        while(prev!=null){
            prev.next=nxt;
            prev=prev.right;
            nxt=nxt.left;
        }
        helper(root.left);
        helper(root.right);
    }
}