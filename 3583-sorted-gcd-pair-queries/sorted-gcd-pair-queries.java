class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int n=nums.length,m=queries.length,max=0;
        for(int i=0;i<n;i++) max=Math.max(max,nums[i]);

        int[] freq=new int[max+1];
        for(int i=0;i<n;i++){
            int num=nums[i];
            for(int j=1;j*j<=num;j++){
                if(num%j==0){
                    freq[j]++;
                    if(num/j !=j) freq[num/j]++;
                }
            }
        }

        long[] countPairGcd=new long[max+1];
        for(int i=max;i>0;i--){
            int count=freq[i];
            countPairGcd[i]=(long)count*(count-1)/2;
            for(int g=2*i;g<=max;g+=i){
                countPairGcd[i] -=countPairGcd[g];
            }
        }

        long[] prefixgcd=new long[max+1];
        for(int i=1;i<=max;i++){
            prefixgcd[i] = prefixgcd[i-1]+countPairGcd[i];
        }

        int[] result=new int[m];
        for(int i=0;i<m;i++){
            long idx=queries[i];
            int temp=1,l=1,r=max;
            while(l<=r){
                int midgcd=l +(r-l)/2;
                if(prefixgcd[midgcd]> idx){
                    temp=midgcd;
                    r =midgcd-1;
                }else {
                    l=midgcd+1;
                }
            }
            result[i]=temp;
        }
        return result;
    }
}