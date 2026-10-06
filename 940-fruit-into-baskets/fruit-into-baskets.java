class Solution {
    public int totalFruit(int[] fruits) {
        int n=fruits.length,ans=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        int i=0,j=0,count=0;
        while(i<n){
            int num=fruits[i];
            map.put(num,map.getOrDefault(num,0)+1);
            count++;
            while(map.size()>2){
                int val=map.get(fruits[j]);
                if(val==1) map.remove(fruits[j]);
                else map.put(fruits[j],val-1);
                count--; j++;
            }
            ans=Math.max(ans,count);
            i++;
        }
        return ans;
    }
}