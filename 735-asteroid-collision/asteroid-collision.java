class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        int n=asteroids.length;
        for(int i=0;i<n;i++){
            int num=asteroids[i];
            if(st.isEmpty()) st.push(num);
            else{
                if(st.peek()>0 && num>0){
                    st.push(num);
                    continue;
                } 
                while(!st.isEmpty() && st.peek()>0 && num<0){
                    int top=st.pop();
                    if(Math.abs(top)==Math.abs(num)){
                       num=0;
                       break;
                    } 
                    if(Math.abs(top)>Math.abs(num)) num=top;
                }
                if(num!=0) st.push(num);
            }
        }
        int[] ans=new int[st.size()];
        int i=st.size()-1;
        while(!st.isEmpty()){
            ans[i]=st.pop();
            i--;
        }
        return ans;
    }
}