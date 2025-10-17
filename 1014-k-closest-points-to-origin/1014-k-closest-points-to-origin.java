class Solution {
    public class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    //it is used to compare
    public class Triplet implements Comparable<Triplet>{
        int d;
        int x;
        int y;
        Triplet(int d,int x,int y){
            this.d=d;
            this.x=x;
            this.y=y;
        }
    public int compareTo(Triplet t){
        return this.d - t.d;
    }
    }
    public int[][] kClosest(int[][] points, int k) {
               //METHOD 1(SELF)
        // int[][] ans=new int[k][2];
        // HashMap<Integer,Integer> map=new HashMap<>();
        // PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        // for(int i=0;i<points.length;i++){
        //     int a=points[i][0],b=points[i][1];
        //     int val=a*a + b*b;
        //     pq.add(val);
        //     map.put(val,i);
        //     if(pq.size()>k) pq.remove();
        // }
        // int j=0;
        // while(pq.size()>0){
        //     int idx=map.get(pq.poll());
        //     ans[j][0]=points[idx][0];
        //     ans[j][1]=points[idx][1];
        //     j++;
        // }
        // return ans;


            //METHOD 2(SIR SAME AS ABOVE)
        // int[][] ans=new int[k][2];
        // HashMap<Integer,Pair> map=new HashMap<>();
        // PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        // for(int i=0;i<points.length;i++){
        //     int a=points[i][0],b=points[i][1];
        //     int val=a*a + b*b;
        //     pq.add(val);
        //     map.put(val,new Pair(a,b));
        //     if(pq.size()>k) pq.remove();
        // }
        // for(int i=0;i<k;i++){
        //     int dis=pq.remove();
        //     Pair pt=map.get(dis);
        //     ans[i][0]=pt.x;
        //     ans[i][1]=pt.y;
        // }
        // return ans;

              //METHOD 3(USING CUSTOM COMPARATOR )

        PriorityQueue<Triplet> pq=new PriorityQueue<>(Collections.reverseOrder());
        int[][] ans=new int[k][2];
        for(int i=0;i<points.length;i++){
            int a=points[i][0],b=points[i][1];
            int d=a*a +b*b;
            pq.add(new Triplet(d,a,b));
            if(pq.size()>k) pq.remove();
        }      
        for(int i=0;i<k;i++){
            Triplet t=pq.remove();
            ans[i][0]=t.x;
            ans[i][1]=t.y;
        }
        return ans;
    }
}