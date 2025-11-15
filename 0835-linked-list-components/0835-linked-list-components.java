
class Solution {
    public int numComponents(ListNode head, int[] nums) {
        int ans=0;
        HashSet<Integer> set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        ListNode temp=head;
        while(temp!=null){
            while(!set.contains(temp.val)) {
                temp=temp.next;
                if(temp==null) return ans;
            }
            while(temp!=null && set.contains(temp.val)){
                temp=temp.next;
            }
            ans++;
            if(temp!=null) temp=temp.next;
        }
        return ans;
    }
}