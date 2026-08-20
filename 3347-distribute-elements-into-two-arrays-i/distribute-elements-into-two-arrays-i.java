class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> ans1=new ArrayList<>();
        List<Integer> ans2=new ArrayList<>();
        ans1.add(nums[0]);
        ans2.add(nums[1]);
        int n=nums.length;
        for(int i=2;i<n;i++){
            if(ans1.get(ans1.size()-1)>ans2.get(ans2.size()-1)){
                ans1.add(nums[i]);
            }
            else ans2.add(nums[i]);
        }
        for(int i=0;i<ans1.size();i++){
            nums[i]=ans1.get(i);
        }
        int j=0;
        for(int i=ans1.size();i<n;i++){
            nums[i]=ans2.get(j);
            j++;
        }
        return nums;
    }
}