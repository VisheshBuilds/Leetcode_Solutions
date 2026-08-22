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
        ListNode dum=new ListNode(-1);
        ListNode temp=dum;

        for(int i=0;i<n-1;i++){
            ListNode res=merge(lists[i],lists[i+1]);
            lists[i+1]=res;
        }
        return lists[n-1];
    }
    public ListNode merge(ListNode h1,ListNode h2){
        ListNode dummy=new ListNode(-1);
        ListNode temp1=h1,temp2=h2,m=dummy;
        while(temp1!=null && temp2!=null){
            if(temp1.val <= temp2.val){
                m.next=temp1;
                temp1=temp1.next;
            }
            else{
                m.next=temp2;
                temp2=temp2.next;
            }
            m=m.next;
        }
        while(temp1!=null){
            m.next=temp1;
            m=m.next;
            temp1=temp1.next;
        }
        while(temp2!=null){
            m.next=temp2;
            m=m.next;
            temp2=temp2.next;
        }
        
        return dummy.next;
    }
}