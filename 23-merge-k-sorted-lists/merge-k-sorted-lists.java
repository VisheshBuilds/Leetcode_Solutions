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
    public ListNode mergeKLists(ListNode[] lists) {
        int n=lists.length;
        if(n==0) return null;
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b) -> a.val-b.val);

        for(int i=0;i<n;i++){
            if(lists[i]!=null) pq.add(lists[i]);
        }

        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;

        while(!pq.isEmpty()){
            ListNode curr=pq.remove();

            temp.next=curr;
            temp=temp.next;

            if(curr.next!=null){
                pq.add(curr.next);
            }
        }
        return dummy.next;
    }
}