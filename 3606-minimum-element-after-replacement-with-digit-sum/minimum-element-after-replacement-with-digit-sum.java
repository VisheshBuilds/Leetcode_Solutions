class Solution {
    public int minElement(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
           int x=nums[i],s=0;
           while(x>0){
               s +=x%10;
               x=x/10;
           }
           nums[i]=s;
           min=Math.min(min,s);
        }
        return min;
    }
}