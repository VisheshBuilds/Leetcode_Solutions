class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length,count=0;
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int ele:nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }

        for(int key:map.keySet()){
            int val=map.get(key);
            if(val==1) return -1;
            if(val%3 ==0) count+= val/3;
            else count +=val/3 + 1;
        }
        return count;
    }
}