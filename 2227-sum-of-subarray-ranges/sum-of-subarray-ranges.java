class Solution {
    public long subArrayRanges(int[] nums) {
        int n=nums.length;
        int[] nsl=new int[n];
        int[] rsl=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()] >nums[i]) st.pop();
            if(st.isEmpty()) nsl[i]=-1;
            else nsl[i]=st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()] >=nums[i]) st.pop();
            if(st.isEmpty()) rsl[i]=n;
            else rsl[i]=st.peek();
            st.push(i);
        }
        long small=0,large=0;
        for(int i=0;i<n;i++){
            long val=(i-nsl[i])*(rsl[i]-i);
            small +=(val*nums[i]);
        }
        int[] nll=new int[n];
        int[] rll=new int[n];
        st.clear();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()] < nums[i]) st.pop();
            if(st.isEmpty()) nll[i]=-1;
            else nll[i]=st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]) st.pop();
            if(st.isEmpty()) rll[i]=n;
            else rll[i]=st.peek();
            st.push(i);
        }
        for(int i=0;i<n;i++){
            long val=(i-nll[i])*(rll[i]-i);
            large +=(val*nums[i]);
        }

        return large-small;
    }
}