class Solution {
    public int sortByDigit(int n1,int n2){
        int sum1=sum(n1);
        int sum2=sum(n2);

        if(sum1 !=sum2) return Integer.compare(sum1,sum2);
        return Integer.compare(n1,n2);
    }
    public int minSwaps(int[] nums) {
        int n=nums.length;
        Integer[] sortedArray=new Integer[n];
        for(int i=0;i<n;i++) sortedArray[i]=nums[i];

        Arrays.sort(sortedArray, this::sortByDigit);

        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],i);
        }

        int count=0;
        for(int i=0;i<n;i++){
            int expected=sortedArray[i],curr=nums[i];
            
            if(expected==curr) continue;
            int idx=map.get(expected);
            nums[i]=expected;
            nums[idx]=curr;

            map.put(nums[i],i);
            map.put(nums[idx],idx);
            count++;
        }
        
        return count;
    }
    public int sum(int n){
        int s=0;
        while(n > 0){
            int rem=n%10;
            s +=rem;
            n/=10;
        }
        return s;
    }
}