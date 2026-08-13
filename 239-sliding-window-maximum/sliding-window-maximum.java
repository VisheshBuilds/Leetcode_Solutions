class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
             //METHOD 1
        // int n=nums.length,i=0,j=0;
        // int[] ans=new int[n-k+1];
        // PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        // while(j<n){
        //     pq.add(nums[j]);
        //     if(pq.size()==k){
        //         ans[i]=pq.peek();
        //         pq.remove(nums[i]);
        //         i++;
        //     }
        //     j++;
        // }
        // return ans;

             //METHOD 2 (DEQUE OPTIMISED)
        int n=nums.length,i=0,j=0;
        int[] ans=new int[n-k+1];
        Deque<Integer> dq=new ArrayDeque<>();
        while(i<n){
              //remove  out of window ele
              while(!dq.isEmpty() && dq.peekFirst()<i-k+1){
                dq.removeFirst();
              }

              //remove smaller ele
              while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                dq.removeLast();
              }

              dq.addLast(i);
              if(i >= k-1){
                ans[j]=nums[dq.peekFirst()];
                j++;
              }
              i++;
        }     
        return ans;
    }
}