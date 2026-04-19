class Solution {
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length,min=Integer.MAX_VALUE;

        for(int i=n-1;i>=0;i--){
            int x=reverse(nums[i]);
            if(map.containsKey(x)){
                min= Math.min(min,Math.abs(i-map.get(x)));
            }
            map.put(nums[i],i);
        }
        return min==Integer.MAX_VALUE? -1:min;
    }
    public int reverse(int n){
        String str=String.valueOf(n);
        String rev=new StringBuilder(str).reverse().toString();
        int num=Integer.valueOf(rev);
        return num;
    }
}