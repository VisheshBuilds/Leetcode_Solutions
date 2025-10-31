// class Solution {
//     public class triplet implements Comparable<triplet>{
//         int a;
//         int b;
//         int sum;
//         triplet(int a,int b,int sum){
//             this.a=a;
//             this.b=b;
//             this.sum=sum;
//         }
//         public int compareTo(triplet t){
//             return this.sum-t.sum;
//         }
//     } 
//     public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
       //Self
//         PriorityQueue<triplet> pq=new PriorityQueue<triplet>(Collections.reverseOrder());
//         for(int i=0;i<nums1.length;i++){
//             for(int j=0;j<nums2.length;j++){
//                 int sum=nums1[i] + nums2[j];
//                 pq.add(new triplet(nums1[i],nums2[j],sum));
//                 if(pq.size()>k) pq.remove();
//             }
//         }
//         List<List<Integer>> ans=new ArrayList<>();
//         while(pq.size()>0){
//             triplet t=pq.poll();
//             List<Integer> l=new ArrayList<>();
//             l.add(t.a);
//             l.add(t.b);
//             ans.add(l);
//         }
//         return ans;
//     }
// }
import java.util.*;
//chatgpt
class Solution {
    public class triplet implements Comparable<triplet> {
        int a;
        int b;
        int sum;
        int j; // pointer to index in nums2 for that pair

        triplet(int a, int b, int sum, int j) {
            this.a = a;
            this.b = b;
            this.sum = sum;
            this.j = j;
        }

        public int compareTo(triplet t) {
            return this.sum - t.sum;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return ans;

        PriorityQueue<triplet> pq = new PriorityQueue<>();

        // Instead of adding all pairs, we only add the first pair from each nums1[i]
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            pq.add(new triplet(nums1[i], nums2[0], nums1[i] + nums2[0], 0));
        }

        while (k-- > 0 && !pq.isEmpty()) {
            triplet t = pq.poll();
            ans.add(Arrays.asList(t.a, t.b));

            // If possible, push the next pair (same a, next b)
            if (t.j + 1 < nums2.length) {
                pq.add(new triplet(t.a, nums2[t.j + 1], t.a + nums2[t.j + 1], t.j + 1));
            }
        }

        return ans;
    }
}
