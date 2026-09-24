class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int ele:nums) set.add(ele);

        int longest=0;
        for(int ele:set){
            if(!set.contains(ele-1)){
                int curr=ele;
                int length=1;
                while(set.contains(curr+1)){
                    curr++;
                    length++;
                }
                longest=Math.max(longest,length);
            }
        }
        return longest;
    }
}