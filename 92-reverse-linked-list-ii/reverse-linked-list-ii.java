class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || head.next==null || left==right) return head;
        ListNode a=null,b=null,c=null,d=null,temp=head;
        int pos=1;
        while(temp!=null){
            if(pos==left-1) a=temp;
            else if(pos==left) b=temp;
            else if(pos==right) c=temp;
            else if(pos==right+1) d=temp;
            pos++;
            temp=temp.next;
        }

        if(a!=null) a.next=null;
        if(c!=null) c.next=null;

        ListNode r=rev(b);
        if(a!=null) a.next=c;
        if(b!=null) b.next=d;

        if(a==null) return c;
        return head;
    }
    public ListNode rev(ListNode head){
        ListNode prev=null,curr=head,nxt=head;
        while(curr!=null){
            nxt=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nxt;
        }
        return prev;
    }
}