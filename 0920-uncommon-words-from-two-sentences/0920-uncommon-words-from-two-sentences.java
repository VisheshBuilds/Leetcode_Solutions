class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] words1 = s1.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for(String word: words1){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        String[] words2 = s2.split(" ");
        for(String word: words2){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        ArrayList<String> ans=new ArrayList<>();
        for(String key: map.keySet()){
            if(map.get(key)==1){
                ans.add(key);
            }
        }
        return ans.toArray(new String[0]);

    }
}