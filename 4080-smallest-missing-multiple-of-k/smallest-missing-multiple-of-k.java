class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set=new HashSet<>();
        int n=nums.length,s=k;
        for(int i=0;i<n;i++) set.add(nums[i]);

        while(true){
            if(!set.contains(k)) return k;
            else k +=s;
            if(k> n*s) break;
        }
        return k;
    }
}