class Solution {
    public boolean increasingTriplet(int[] nums) {
        int a=Integer.MAX_VALUE,b=Integer.MAX_VALUE;
        for(int num:nums){
            if(a>=num){
                a=num;
            }
            else if(b>=num){
                b=num;
            }
            else return true;
        }
        return false;
    }
}