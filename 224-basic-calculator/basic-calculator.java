class Solution {
    public int calculate(String s) {
        Stack<Integer> st=new Stack<>();
        int res=0,num=0,sign=1;
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                num=num*10 + (ch-'0');
            }
            else if(ch=='+'){
                res +=num*sign;
                num=0;
                sign=1;
            }
            else if(ch=='-'){
                res +=num*sign;
                num=0;
                sign=-1;
            }
            else if(ch=='('){
                st.push(res);
                st.push(sign);
                res=0;sign=1;
                num=0;
            }
            else if(ch==')'){
                res+=(num*sign);
                num=0;

                res =res*st.pop();
                res =res+st.pop();
                sign=1;
            }
            else continue;
        }
        res +=num*sign;
        return res;
    }
}