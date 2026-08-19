class Solution {
    public int maxNumberOfFamilies(int n, int[][] reserve) {
        HashMap<Integer,Set<Integer>> seat=new HashMap<>();
        
        for(int i=0;i<reserve.length;i++){
            int row=reserve[i][0],col=reserve[i][1];
            seat.putIfAbsent(row,new HashSet<>());
            seat.get(row).add(col);
        }
        int ans=(n-seat.size())*2;

        for(Map.Entry<Integer,Set<Integer>> entry : seat.entrySet()){
            int row=entry.getKey();
            Set<Integer> res=entry.getValue();

            boolean left=!res.contains(2) && !res.contains(3) && !res.contains(4) && !res.contains(5);
            boolean mid=!res.contains(4) && !res.contains(5) && !res.contains(6) && !res.contains(7);
            boolean right=!res.contains(6) && !res.contains(7) && !res.contains(8) && !res.contains(9);

            if(left && right) ans +=2;
            else if(left || right || mid) ans +=1;

        }
        
        return ans;
    }
}