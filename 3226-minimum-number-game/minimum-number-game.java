class Solution {
    public int[] numberGame(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n];
        Arrays.sort(nums);

        int k=0;
        for(int i=0;i<n;i +=2){
            int a=nums[k],b=nums[k+1];
            k +=2;
            arr[i]=b;
            arr[i+1]=a;
        }
        return arr;
    }
}