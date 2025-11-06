class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
       int n=hand.length;
       if(n%groupSize!=0) return false;
       TreeMap<Integer,Integer> map=new TreeMap<>();
       for(int key:hand){
            map.put(key,map.getOrDefault(key,0)+1);
       }
       while(map.size()>0){
            int first=map.firstKey();
            for(int i=0;i<groupSize;i++){
                int curr=first+i;
                if(!map.containsKey(curr)) return false;
                map.put(curr,map.get(curr)-1);
                if(map.get(curr)==0) map.remove(curr);
            }
       }
       return true;
       
    }
}