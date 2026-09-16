class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans=new ArrayList<>();
        int n=strs.length;

        HashMap<String,List<Integer>> map=new HashMap<>();
        
        for(int i=0;i<n;i++){
            String s=strs[i];
            char[] ch=s.toCharArray();
            Arrays.sort(ch);
            String sorted=new String(ch);

            if(!map.containsKey(sorted)){
                map.put(sorted,new ArrayList<>());
            }
            List l=map.get(sorted);
            l.add(i);
        }

        int len=map.size(),k=0;
        for(int i=0;i<len;i++) ans.add(new ArrayList<>());

        for(String s:map.keySet()){
            List<Integer> l=map.get(s);
            for(int str:l){
                ans.get(k).add(strs[str]);
            }
            k++;
        }

        return ans;
    }
}