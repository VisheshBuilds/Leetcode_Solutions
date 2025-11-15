class Solution {
    public int numComponents(ListNode head, int[] nums) {
                //METHOD 1 (SELF)

        // int ans=0;
        // HashSet<Integer> set=new HashSet<>();
        // for(int i:nums) set.add(i);
        // ListNode temp=head;
        // while(temp!=null){
        //     while(!set.contains(temp.val)) {
        //         temp=temp.next;
        //         if(temp==null) return ans;
        //     }
        //     while(temp!=null && set.contains(temp.val)){
        //         temp=temp.next;
        //     }
        //     ans++;
        //     if(temp!=null) temp=temp.next;
        // }
        // return ans;

              //METHOD 2(CHATGPT)

        HashSet<Integer> set=new HashSet<>();
        for(int i:nums) set.add(i);
        int ans=0;
        ListNode t=head;
        while(t!=null){
            //if node is in nums AND node.next not in nums 
            if((set.contains(t.val)) && (t.next==null || !set.contains(t.next.val) )){
                ans++;
            }
            t=t.next;
        }  
        return ans;    
    }
}