
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode firsthalf=head,slow=head,fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode secondhalf=slow.next;
        slow.next=null;
        firsthalf=sortList(firsthalf);
        secondhalf=sortList(secondhalf);

        ListNode ans=merge(firsthalf,secondhalf);
        return ans;
        
    }
    public ListNode merge(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy,a=l1,b=l2;

        while(a!=null && b!=null){
            if(a.val<=b.val){
                temp.next=a;
                a=a.next;
            }
            else {
                temp.next=b;
                b=b.next;
            }
            temp=temp.next;
        }

        if(a!=null) temp.next=a;
        if(b!=null) temp.next=b;
        
        return dummy.next;
    }
}