class Solution {
    public boolean isNStraightHand(int[] hand, int g) {
        int n=hand.length;
        if(n % g !=0) return false;
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int i=0;i<n;i++) map.put(hand[i],map.getOrDefault(hand[i],0)+1);
        
        while(n>0){
            int first=map.firstKey();
            for(int k=0;k<g;k++){
                int key=first+k;
                if(!map.containsKey(key)) return false;
                
                int val=map.get(key);
                val--;
                n--;
                if(val==0) map.remove(key);
                else map.put(key,val);
            }
        }
        return true;
    }
}