class Solution {
    public long bowlSubarrays(int[] nums) {
        long count=0;
        int n=nums.length;
        int[] left=new int[n];
        int[] right=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<nums[i]) st.pop();
            if(st.isEmpty()) right[i]=-1;
            else right[i]=st.peek();
            st.push(nums[i]);
        }
        while(!st.isEmpty()) st.pop();

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && st.peek()<nums[i]) st.pop();
            if(st.isEmpty()) left[i]=-1;
            else left[i]=st.peek();
            st.push(nums[i]);
        }

        for(int i=0;i<n;i++){
            if(Math.min(left[i],right[i])> nums[i]) count++;
        }
        return count;
    }
}