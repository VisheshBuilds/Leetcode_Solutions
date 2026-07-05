class Solution {
    public boolean canBeValid(String s, String locked) {
        int n=s.length();
        if(n % 2 == 1) return false;
        Stack<Integer> free=new Stack<>();
        Stack<Integer> open=new Stack<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(locked.charAt(i)=='0') free.push(i);
            else if(ch=='(') open.push(i);
            else{
                if(!open.isEmpty()){
                    open.pop();
                }
                else if(!free.isEmpty()){
                    free.pop();
                }
                else return false;
            }
        }
        while(!free.isEmpty() && !open.isEmpty()){
            if(open.peek()<free.peek()){
            free.pop();
            open.pop();
            }
            else return false;
        }
        return open.isEmpty();
    }
}