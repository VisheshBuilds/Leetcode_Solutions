/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return head;
        int len=0;
        ListNode temp=head,last=head;
        while(temp!=null){
            len++;
            if(temp.next==null) last=temp;
            temp=temp.next;
        }
        k=k%len;
        if(k==0 ) return head;
        int x=len-k;
        temp=head;
        ListNode prev=head,newhead=head;
        while(x>1){
            prev=prev.next;
            x--;
        }
        newhead=prev.next;
        prev.next=null;
        last.next=temp;
        return newhead;

    }
}