class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);
        int n=arr.length;
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n-2;i++){
            //remove duplicate
            if(i!=0 && arr[i]==arr[i-1]) continue;
            int s=i+1,e=n-1;
            while(s<e){
                int sum=arr[i]+arr[s]+arr[e];
                if(sum<0) s++;
                else if( sum >0) e--;
                else {
                    ans.add(Arrays.asList(arr[i],arr[s],arr[e]));
                    s++; e--;
                    //remove duplicate
                    while(s<e && arr[s]==arr[s-1]) s++;
                    while(s<e && arr[e]==arr[e+1]) e--;
                }
            }
        }
        return ans;
    }
}