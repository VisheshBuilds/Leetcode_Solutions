class Solution {
    public int minOperations(int[] nums, int x) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int n=nums.length,sum=0;
        for(int i=0;i<n;i++) {
            sum +=nums[i];
            map.put(sum,i);
        }

        int restsum=sum-x;
        if(restsum==0) return n;
        if(restsum<0) return -1;
        sum=0;
        int mini=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            sum +=nums[i];
            if(map.containsKey(sum-restsum)){
                mini=Math.max(mini,i-map.get(sum-restsum));
            }
        }
        return (mini==Integer.MIN_VALUE )? -1:n-mini;
    }
}