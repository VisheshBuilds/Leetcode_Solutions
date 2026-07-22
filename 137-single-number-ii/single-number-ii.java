class Solution {
    public int singleNumber(int[] nums) {
        int ans=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int key: map.keySet()){
            int val=map.get(key);
            if(val==1){
                ans=key;
                break;
            }
        }
        return ans;
    }
}