class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length,max=0;
        int[] left=new int[n];
        int[] right=new int[n];
        Stack<Integer> st=new Stack<>();
        

        for(int i=0;i<n;i++){
            if(st.isEmpty()) {
                left[i]=-1;
                st.push(i);
            }
            else{
                while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                     st.pop();
                }
                if(st.isEmpty()) {
                    left[i]=-1;
                    st.push(i);
                }
                else {
                    left[i]=st.peek();
                    st.push(i);
                }
            }
        }
        while(!st.isEmpty()) st.pop();
        for(int i=n-1;i>=0;i--){
            if(st.isEmpty()){
                right[i]=n;
                st.push(i);
            }
            else{
                while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    right[i]=n;
                    st.push(i);
                }
                else {
                    right[i]=st.peek();
                    st.push(i);
                }
            }
        }
        for(int i=0;i<n;i++){
            int val=right[i]-left[i]-1;
            max=Math.max(max,val*heights[i]);
        }
        return max;
    }
}