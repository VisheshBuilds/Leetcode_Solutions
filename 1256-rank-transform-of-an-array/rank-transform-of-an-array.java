class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] s=arr.clone();
        Arrays.sort(s);
        int rank=1;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:s){
           if(!map.containsKey(i)){
            map.put(i,rank++);
           }
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=map.get(arr[i]);
        }
        return arr;

    }
}