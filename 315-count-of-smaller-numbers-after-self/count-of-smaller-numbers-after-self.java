class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        int n=nums.length;
        List<Integer> list=new ArrayList<>();

        for(int i=n-1;i>=0;i--){
            if(list.isEmpty() || list.get(list.size()-1)<nums[i]){
                int size=list.size();
                ans.add(size);
                list.add(nums[i]);
            }
            else {
                int idx=bs(list,nums[i]);
                ans.add(idx);
                list.add(idx,nums[i]);
            }
        }

        Collections.reverse(ans);
        return ans;
    }
    public int bs(List<Integer> list,int num){
        int s=0,e=list.size()-1,may=-1;
        while(s<=e){
            int mid=e-(e-s)/2;
            if(list.get(mid)==num){
                may=mid;
                e=mid-1;
            }
            else if(list.get(mid)>num) e=mid-1;
            else s=mid+1;
        }
        if(may!=-1) return may;
        return s;
    }
}