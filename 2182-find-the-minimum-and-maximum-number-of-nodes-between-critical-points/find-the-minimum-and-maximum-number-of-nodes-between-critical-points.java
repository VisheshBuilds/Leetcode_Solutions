class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int len=0,min=Integer.MAX_VALUE,max=-1;
        int lastcric=-1,firstcric=-1,lastval=-1;
        ListNode temp=head;
        while(head!=null){
            len++;
            if(lastval !=-1 && head.next !=null){
                if((lastval> head.val && head.next.val > head.val) || (lastval< head.val && head.next.val < head.val)){
                    if(lastcric!=-1)  min=Math.min(min,len-lastcric);
                    if(firstcric !=-1) max=Math.max(max,len-firstcric);
                    if(firstcric==-1) firstcric=len;
                    lastcric=len;
                }
            }
            lastval=head.val;
            head=head.next;
        }
        
        if(firstcric ==-1 || firstcric==lastcric) return new int[]{-1,-1};
        return new int[]{min,max};
    }
}