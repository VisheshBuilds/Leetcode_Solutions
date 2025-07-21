class Solution {
    public String makeFancyString(String s) {
        int n=s.length();
        if(n==1 || n==2) return s;
        StringBuilder sb=new StringBuilder();
        char a1=s.charAt(0),a2=s.charAt(1);
        for(int i=2;i<n;i++){
            char ch=s.charAt(i);
            if(a1==a2 && a2==ch) continue;
            else{
                sb.append(a1);
            }
            a1=a2;
            a2=ch;
        }
        sb.append(a1);
        sb.append(a2);

        return sb.toString();
    }
}