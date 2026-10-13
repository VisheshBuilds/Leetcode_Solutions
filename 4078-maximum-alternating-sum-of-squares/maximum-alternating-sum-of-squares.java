class Solution {
    public long maxAlternatingSum(int[] nums) {
             //METHOD 1
        // long ans=0;
        // int n=nums.length;
        // if(n==1) return nums[0]*nums[0];
        
        // PriorityQueue<Integer> pq1=new PriorityQueue<>(Collections.reverseOrder());
        // PriorityQueue<Integer> pq2=new PriorityQueue<>();

        // for(int i=0;i<n;i++){
        //     int val=Math.abs(nums[i]);
        //     pq1.add(val);
        //     pq2.add(val);
        // }
        
        // boolean max=true;
        // while(pq1.size()>0 ){
        //     if(max){
        //     int val=pq1.remove();
        //     pq2.remove(val);
        //     ans +=(val*val);
        //     }
        //     else{
        //         int val2=pq2.remove();
        //         pq1.remove(val2);
        //         ans -=(val2*val2);
        //     }
        //     max =!max;
        // }
        // return ans;


              //METHOD 2

        int n=nums.length;
        long ans=0;
        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=Math.abs(nums[i]);
        }   
        Arrays.sort(arr);

        for(int i=0;i<n;i++){
            long val=arr[i];
            if(i<(n)/2){
                ans -=(val*val);
            }
            else ans +=(val*val);
        }
        return ans;   
    }
}