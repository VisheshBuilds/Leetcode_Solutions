class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] f=new int[10];
        for(int i:digits) f[i]++;

        List<Integer> list=new ArrayList<>();
        for(int i=1;i<10;i++){
            for(int j=0;j<10;j++){
                for(int k=0;k<10;k+=2){
                    f[i]--; f[j]--; f[k]--;
                    if(f[i]>=0 && f[j]>=0 && f[k]>=0){
                        int val=i*100 + j*10 + k;
                        list.add(val);
                    }
                    f[i]++; f[j]++; f[k]++;
                }
            }
        }
        int n=list.size();
        int[] ans=new int[n];
        for(int i=0;i<n;i++) ans[i]=list.get(i);

        return ans;
    }
}