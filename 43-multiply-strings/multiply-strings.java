import java.math.BigInteger;
class Solution {
    public String multiply(String num1, String num2) {
                 //METHOD 1 (SELF)
        // int n1=Integer.valueOf(num1);
        // int n2=Integer.valueOf(num2);
        // int ans= n1*n2;
        // return Integer.toString(ans);

                    //METHOD 2 (CHATGPT)
        BigInteger n1=new BigInteger(num1);
        BigInteger n2=new BigInteger(num2);
        BigInteger ans= n1.multiply(n2);
        return ans.toString();

 //METHOD 3 (OPTIMISE AND A/C TO QUESTION WITHOUT INBUILD FUNCTION)
        
        


    }
}