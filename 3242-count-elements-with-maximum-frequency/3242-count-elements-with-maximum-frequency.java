class Solution {
    public int maxFrequencyElements(int[] nums) {
        int ans=0,maxf=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
            maxf=Math.max(maxf,map.getOrDefault(i,0));
        }
        for(int key:map.keySet()){
            int val=map.get(key);
            if(maxf == val){
                ans +=val;
            }
        }
        return ans;
    }
}