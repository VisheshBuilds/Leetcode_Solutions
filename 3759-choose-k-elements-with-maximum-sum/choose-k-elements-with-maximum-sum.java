class Solution {
    class Pairs implements Comparable<Pairs> {
        int num1;
        int num2;
        int i;
        Pairs(int num1,int num2,int i){
            this.num1=num1;
            this.num2=num2;
            this.i=i;
        }
        public int compareTo(Pairs p){
            if(this.num1==p.num1) return this.i-p.i;
            return this.num1-p.num1;
        }
    }
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int n=nums1.length;
        long[] ans=new long[n];
        PriorityQueue<Pairs> pq=new PriorityQueue<>();

        for(int i=0;i<n;i++) pq.add(new Pairs(nums1[i],nums2[i],i));

        PriorityQueue<Integer> topk=new PriorityQueue<>();
        int i=0;
        long sum=0;
        while(!pq.isEmpty()){
            Pairs top=pq.remove();
            int num1=top.num1;
            int num2=top.num2;
            int idx=top.i;
            List<Integer> temp=new ArrayList<>();
            while(!pq.isEmpty() && num1==pq.peek().num1){
                Pairs tmp=pq.remove();
                temp.add(tmp.num2);
                ans[tmp.i]=sum;
            }
            
            ans[idx]=sum;

            if(temp.size()>0){
                for(int num:temp){
                    sum +=num;
                    topk.add(num);
                    if(topk.size()>k){
                         int low=topk.remove();
                         sum-=low;
                    }
                }
            }
            topk.add(num2);
            sum+=num2;
            if(topk.size()>k){
                int low=topk.remove();
                sum -=low;
            }
        }
        return ans;
    }
}