class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n=nums.length,ans=0;
        int[] prefix=new int[n];
        prefix[0]=nums[0]%k;
        for(int i=1;i<n;i++){
            prefix[i]=(prefix[i-1]+nums[i])%k;
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int m=(prefix[i]%k+k)%k;
            if(m==0) ans++;
            if(map.containsKey(m)){
                ans +=map.get(m);
            }
            map.put(m,map.getOrDefault(m,0)+1);
        }
        return ans;
    }
}