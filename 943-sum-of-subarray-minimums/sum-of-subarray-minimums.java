class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length,mod=1000000007;
        int[] nsl=new int[n];
        int[] rsl=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                    st.pop();
                }
            if(st.isEmpty()) nsl[i]=-1; 
            else nsl[i]=st.peek();

            st.push(i);
        }

        st.clear();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                    st.pop();
                }
            if(st.isEmpty()) rsl[i]=n; 
            else rsl[i]=st.peek();

            st.push(i);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            long a=(i-nsl[i]);
            long b=(rsl[i]-i);
            long len=(a*b)%mod;
            ans = (int)((ans + len*arr[i])%mod);
            
        }
        return ans;
    }
}