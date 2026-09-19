class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n=nums.length;
        int[] prefix=new int[n];
        prefix[0]=nums[0]%k;
        for(int i=1;i<n;i++){
            prefix[i]=(prefix[i-1]+nums[i])%k;
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int m=prefix[i]%k;
            if(m==0 && i>=1) return true;
            if(!map.containsKey(m)){
                map.put(m,i);
            }
            else{
                if(i-map.get(m) >=2) return true;
            }
        }
        return false;
    }
}