class Solution {
    public int minCost(String colors, int[] neededTime) {
        int ans=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int i=0,j=1,n=neededTime.length;
        while(j<n){
              while(j<n && colors.charAt(i)==colors.charAt(j)){
                if(j==i+1) pq.add(neededTime[i]);
                pq.add(neededTime[j]);
                j++;
              }
              int k=j-i-1;
              while(k != 0){
                  ans +=pq.poll();
                  k--;
              }
              pq.poll();
              i=j;
              j++;
        }
        return ans;
    }
}