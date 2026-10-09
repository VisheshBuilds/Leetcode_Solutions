class Solution {
    public int minInsertions(String s) {
        int n=s.length(),count=0,open=0;
        
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='(') open++;
            else{
                
                if(i+1<n && s.charAt(i+1)==')') i++;
                else count++;

                if(open>0) open--;
                else count++;
            }
        }
        return count + open*2;
    }
}