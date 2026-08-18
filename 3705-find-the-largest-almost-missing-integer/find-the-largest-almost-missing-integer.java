class Solution {
    public int largestInteger(int[] nums, int k) {
        int n=nums.length,max=-1,max2=-1;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            max2=Math.max(max2,nums[i]);
        }

        for(int key:map.keySet()){
            int freq=map.get(key);
            if(max<key && freq==1) max=key;
        }
        
        if(k==n) return max2;
        if(k==1) return max;
        if(map.get(nums[0])==1 && map.get(nums[n-1])==1){
            return Math.max(nums[0],nums[n-1]);
        }
        else if(map.get(nums[0])==1) return nums[0];
        else if(map.get(nums[n-1])==1) return nums[n-1];
        
        return -1;

    }
}