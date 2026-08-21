class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq=new PriorityQueue<>((a,b) -> {
            if(a.length() != b.length()) return a.length()-b.length();
            return a.compareTo(b);
        });
        
        int n=nums.length;
        for(int i=0;i<n;i++){
            pq.add(nums[i]);
            if(pq.size()>k){
                pq.remove();
            }
        }
        return pq.peek();
    }
}