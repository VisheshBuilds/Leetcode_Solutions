class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        int n=asteroids.length;
        for(int i=0;i<n;i++){
            if(asteroids[i]<0){
                while(!st.isEmpty() && st.peek()>0){
                    if(Math.abs(asteroids[i]) > st.peek() ){
                        st.pop();
                    }
                    else break;
                }
                if(st.isEmpty()) st.push(asteroids[i]);
                else if(st.peek()<0) st.push(asteroids[i]);
                else if(st.peek()==Math.abs(asteroids[i])) st.pop();
            }
            else {
                st.push(asteroids[i]);
            }
        }
        int[] ans=new int[st.size()];
        int j=st.size()-1;
        while(!st.isEmpty()){
             ans[j]=st.pop();
             j--;
        }
        return ans;
    }
}