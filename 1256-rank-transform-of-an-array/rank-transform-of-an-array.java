class Solution {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int rank=1,n=arr.length;
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=arr[i];
        }
        Arrays.sort(nums);
        for(int i:nums){
           if(!map.containsKey(i)){
            map.put(i,rank++);
           }
        }
        for(int i=0;i<n;i++){
            arr[i]=map.get(arr[i]);
        }
        return arr;

    }
}