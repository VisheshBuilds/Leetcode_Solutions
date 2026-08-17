class Solution {
    public long minimalKSum(int[] nums, int k) {
        long ans=0,sum=0;
        Arrays.sort(nums);
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            if(!set.contains(num) && num <=k){
                k++;
                sum +=num;
            }
            set.add(num);
        }
        ans = (long)k*(k+1)/2 - sum;


        return ans;
    }
}