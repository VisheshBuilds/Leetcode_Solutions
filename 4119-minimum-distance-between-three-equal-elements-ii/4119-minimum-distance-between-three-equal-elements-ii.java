class Solution {
    public int minimumDistance(int[] nums) {
        int n=nums.length;
        Map<Integer,ArrayList<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
        int min=Integer.MAX_VALUE;
        for(int key:map.keySet()){
            if(map.get(key).size() <3) continue;
            ArrayList<Integer> arr=map.get(key);
            for(int i=0;i<arr.size()-2;i++){
                int x=arr.get(i);
                int y=arr.get(i+1);
                int z=arr.get(i+2);
                min=Math.min(min, 2*(Math.max(x, Math.max(y, z)) - Math.min(x, Math.min(y, z))));
            }
        }
        return (min==Integer.MAX_VALUE) ? -1 : min;
    }
}