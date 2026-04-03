class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int n=triplets.length;
        boolean[] b=new boolean[n];
        for(int i=0;i<n;i++){
            b[i]= false;
            if(triplets[i][0]<=target[0] && triplets[i][1]<=target[1] && triplets[i][2]<=target[2]){
               b[i] = true;
            }
        }
        int[] ans={0,0,0};
        for(int i=0;i<n;i++){
            if(b[i]){
                ans[0]= Math.max(ans[0],triplets[i][0]);
                ans[1]= Math.max(ans[1],triplets[i][1]);
                ans[2]= Math.max(ans[2],triplets[i][2]);
            }
        }
        return Arrays.equals(target,ans);
    }
}