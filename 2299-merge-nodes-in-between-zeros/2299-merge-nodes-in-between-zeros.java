class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode new_head=new ListNode(-1);
        ListNode t=new_head,curr=head;

        while(curr!=null){
            int sum=0;
            if(curr.next==null) break;
            while(curr.next.val!=0){
                curr=curr.next;
                sum+=curr.val;
            }
            ListNode x=new ListNode(sum);
            t.next=x;
            t=t.next;
            curr=curr.next;
        }
        return new_head.next;
    }
}