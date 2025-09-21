class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return helper(head,1,len(head));
    }
    public TreeNode helper(ListNode head,int i,int j){
        if( i>j) return null;
        int mid=(j+i)/2;
        TreeNode root=new TreeNode(search(head,mid));
        root.left =helper(head,i,mid-1);
        root.right =helper(head,mid+1,j);
        return root;
    }
    public int len(ListNode head){
        if(head==null) return 0;
        // ListNode temp=new ListNode(head);
        int size=0;

        while(head!=null){
            size++;
            head=head.next;
        }
        return size;
    }
    public int search(ListNode head,int i){
        int t=1;
        while(head!=null){
            if(i==t) return head.val;
            t++;
            head=head.next;
        }
        return 0;
    }
}