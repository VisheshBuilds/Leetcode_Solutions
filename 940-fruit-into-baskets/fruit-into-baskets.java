class Solution {
    public int totalFruit(int[] fruits) {
        int n=fruits.length,i=0,j=0,ans=0;
        if(n<3) return n;
        HashMap<Integer,Integer> map=new HashMap<>();
        int last=-1,first=-1;
        while(i<n){
            int f=fruits[i];
            map.put(f,map.getOrDefault(f,0)+1);
            while(map.size()>2){
                map.put(fruits[j],map.get(fruits[j])-1);
                if(map.get(fruits[j])==0) map.remove(fruits[j]);
                j++;
            }
            ans=Math.max(ans,i-j+1);
            i++;
        }
        return ans;
    }
}