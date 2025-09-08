class Solution {
    public int[] getNoZeroIntegers(int n) {
                //METHOD 1
        // for(int i=0;i<n;i++){
        //     int j=n-i;
        //     if (!String.valueOf(i).contains("0") && !String.valueOf(j).contains("0")){
        //         return new int[]{i, j};
        //     }
        // }
        // return new int[0];

        //METHOD 2
        int i=1,j=n-1;
        while(zero(i) || zero(j)){
            i++; j=n-i;
        }
        return new int[]{i,j};
    }
    public boolean zero(int i){
        while(i>0){
            if(i%10 == 0) return true;
            i /= 10;
        }
        return false;
    }
}