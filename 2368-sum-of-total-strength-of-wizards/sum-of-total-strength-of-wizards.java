class Solution {
    public int totalStrength(int[] strength) {
        int n = strength.length;
        long mod = 1_000_000_007L;

        int[] nml = new int[n];
        int[] nmr = new int[n];
        Stack<Integer> st = new Stack<>();

        // Previous Less or Equal
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && strength[st.peek()] > strength[i]) {
                st.pop();
            }

            nml[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // Next Strictly Less
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && strength[st.peek()] >= strength[i]) {
                st.pop();
            }

            nmr[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        // prefix[i] = sum of strength[0...i]
        long[] prefix = new long[n];
        prefix[0] = strength[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = (prefix[i - 1] + strength[i]) % mod;
        }

        // pp[i] = prefix[0] + prefix[1] + ... + prefix[i]
        long[] pp = new long[n];
        pp[0] = prefix[0];
        for (int i = 1; i < n; i++) {
            pp[i] = (pp[i - 1] + prefix[i]) % mod;
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            int l = nml[i];
            int r = nmr[i];

            long leftCount = i - l;
            long rightCount = r - i;

            // Sum of prefix[i] to prefix[r-1]
            long rightSum = pp[r - 1];
            if (i > 0) {
                rightSum = (rightSum - pp[i - 1] + mod) % mod;
            }

            // Sum of prefix[l+1] to prefix[i-1]
            long leftSum = 0;
            if (i - 1 >= 0) {
                leftSum = pp[i - 1];
                if (l > 0) {
                    leftSum = (leftSum - pp[l-1] + mod) % mod;
                }
            }

            long total = (
                rightSum * leftCount % mod
                - leftSum * rightCount % mod
                + mod
            ) % mod;

            ans = (ans + total * strength[i]) % mod;
        }

        return (int) ans;
    }
}