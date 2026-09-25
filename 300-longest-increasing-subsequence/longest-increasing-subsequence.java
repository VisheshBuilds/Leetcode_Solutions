class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(list.isEmpty() || list.get(list.size()-1)<nums[i]) list.add(nums[i]);
            else{
                int idx=bs(list,nums[i]);
                list.set(idx,nums[i]);
            }
        }
        return list.size();
    }
    public int bs(List<Integer> list,int num){
        int left=0,right=list.size()-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(list.get(mid)==num) return mid;
            else if(list.get(mid)>num) right=mid-1;
            else left=mid+1;
        }
        return left;
    }
}