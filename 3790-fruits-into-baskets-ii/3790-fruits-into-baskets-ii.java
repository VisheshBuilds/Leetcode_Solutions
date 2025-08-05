class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int packed=0,n=baskets.length;
        boolean[] used=new boolean[n];

        for(int i=0;i<n;i++){
            int fruit=fruits[i];
            for(int j=0;j<n;j++){
                if(!used[j] && baskets[j]>=fruit){
                    packed++;
                    used[j]=true;
                    break;
                }
            }
        }
        
        return n-packed;
    }
}