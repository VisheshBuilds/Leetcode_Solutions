class Solution {
    public int reverse(int x) {
           int num = Math.abs(x);
    
       int rev =0;
        int real =x;
       int sign = (x >0) ? 1 : -1;

       if(x<0){
        x = x * -1;
       }
       
        while(x>0){
          int digit=  x % 10 ;

          if(rev>(Integer.MAX_VALUE - digit) / 10){
            return 0;
          }
          rev = rev *10 + digit;
          x /= 10;
        }
        rev = rev * sign;
        return rev;
    }
}