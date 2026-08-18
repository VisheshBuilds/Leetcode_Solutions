class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n=nums.length,ans=0;
        List<Integer> idx=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(nums[i]%2!=0) idx.add(i);
        }
        
        if(idx.size()<k) return 0;
        int i=0,j=k-1;
        while(j< idx.size()){
            int a=idx.get(i),b=idx.get(j);
            if(i==0) a= a-(-1);
            else a=a-idx.get(i-1);
            if(j== idx.size()-1) b=n-b;
            else b=idx.get(j+1)-b;

            ans +=(a*b);

            i++; j++;
        }
        return ans;
    }
}