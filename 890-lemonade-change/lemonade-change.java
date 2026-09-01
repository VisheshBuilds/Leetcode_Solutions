class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] val=new int[3];
        int n=bills.length;
        for(int i=0;i<n;i++){
            if(bills[i]==5) val[0]++;
            else if(bills[i]==10){
                if(val[0]==0) return false;
                else {
                    val[0]--;
                    val[1]++;
                }
            }
            else{
                if(val[1]>0 && val[0]>0){
                    val[0]--;  val[1]--;  val[2]++;
                }
                else if(val[1]==0 && val[0]>2){
                    val[0] -=3;
                    val[2]++;
                }
                else return false;
            }
        }
        return true;
    }
}