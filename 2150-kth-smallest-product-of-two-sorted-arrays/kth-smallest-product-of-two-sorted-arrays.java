class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long l = -10000000000L;
        long r = 10000000000L;
        while(l<r){
            long mid = l + (r-l)/2;
            if(helper(nums1,nums2,mid)<k){
                l=mid+1;
            }
            else {
                r=mid;
            }
        }
        return l;
    }
    public long helper(int[] nums1,int[] nums2,long tar){
        long count=0;
        for(int num1:nums1){
            int l=0,r=nums2.length;

            while(l<r){
                int mid=l + (r-l)/2;
                long product=(long)num1*nums2[mid];
                if(product<=tar){
                    if(num1>0) l=mid+1;
                    else r=mid;
                }
                else{
                    if(num1>0) r=mid;
                    else l=mid+1;
                }
            }
            count +=(num1>0)? l:nums2.length-l;
        }
        return count;
    }
}