class Solution {
    public String addBinary(String a, String b) {
             //METHOD 1

        // int a1=a.charAt(0)-'0',a2=b.charAt(0)-'0';
        // for(int i=1;i<a.length();i++){
        //     a1=a1*2+(a.charAt(i)-'0');
        // }
        // for(int i=1;i<b.length();i++){
        //     a2=a2*2+(b.charAt(i)-'0');
        // }
        // int ans=a1+a2;
        // if(ans==0) return "0";
        // StringBuilder sb=new StringBuilder();
        // while(ans!=0){
        //     sb.append(ans%2);
        //     ans /=2;
        // }
        // return sb.reverse().toString();

            
            //METHOD 2

        StringBuilder ans=new StringBuilder();
        int i=a.length()-1,j=b.length()-1;
        int carry=0;
        while(i>=0 || j>=0 || carry!=0){
            int sum=0;
            if(i>=0) sum +=a.charAt(i)-'0';
            if(j>=0) sum +=b.charAt(j)-'0';
            if(carry!=0) sum +=carry;

            if(sum==0) ans.append('0');
            else if(sum==1){
                ans.append('1');
                carry=0;
            }
            else if(sum==2){
                ans.append('0');
                carry=1;
            }
            else {
                ans.append('1');
                carry=1;
            }
            i--;j--;
        }

        return ans.reverse().toString();



        
    }
}