class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        //METHOD 1(BRUTE FORCE)
        // int n=nums.length,k=0,m=queries.length;
        // int totalPairs = (int)((long)n * (n - 1) / 2);
        // int[] gcdPairs=new int[totalPairs];
        // int[] ans=new int[m];
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         gcdPairs[k]=gcd(nums[i],nums[j]);
        //         k++;
        //     }
        // }
        // Arrays.sort(gcdPairs);
        // for(int i=0;i<m;i++){
        //     ans[i]=gcdPairs[(int)queries[i]];
        // }
        // return ans;


            //METHOD 2 
        int max=0,n=nums.length;
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

        long[] pairswithGcd=new long[max+1];
        for(int g=max;g>=1;g--){
            int count=freq[g];
            pairswithGcd[g]=(long)count*(count-1)/2;
            for(int mult=2*g;mult<=max;mult+=g){
                pairswithGcd[g] -=pairswithGcd[mult];
            }
        }

        long[] prefixcount=new long[max+1];
        for(int g=1;g<=max;g++){
            prefixcount[g] = prefixcount[g-1]+pairswithGcd[g];
        }

        int[] result=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            long idx=queries[i];
            int l=1,r=max,temp=1;
            while(l<=r){
                int mid_gcd=l + (r-l)/2;
                if(prefixcount[mid_gcd]>idx){
                    temp=mid_gcd;
                    r=mid_gcd-1;
                }else {
                    l=mid_gcd+1;
                }
            }
            result[i]=temp;
        }
         
         return result;
    }
    // public int gcd(int a,int b){
    //     if(b==0) return a;
    //     return gcd(b,a%b);
    // }
}