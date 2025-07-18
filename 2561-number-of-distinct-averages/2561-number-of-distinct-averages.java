class Solution {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int m=n/2;
        HashSet<Double> set=new HashSet<>();
        for(int i=0;i<m;i++){
            double v1=(double)nums[i];
            double v2=(double)nums[n-1-i];
            double f=(v1+v2)/2;
            set.add(f);
        }
        return set.size();
    }
}