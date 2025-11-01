class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode curr=head,prev=dummy;
        while(curr!=null){
            if(set.contains(curr.val)){
                prev.next=curr.next;
            }
            else {
                prev=curr;
            }
            curr=curr.next;
        }
        
        return dummy.next;
    }
}