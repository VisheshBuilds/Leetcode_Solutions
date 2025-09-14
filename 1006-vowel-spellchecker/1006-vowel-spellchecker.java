class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactset=new HashSet<>();
        Map<String,String> lowermp=new HashMap<>();
        Map<String,String> vowelmp=new HashMap<>();

        for(String word:wordlist){
            exactset.add(word);
            String lower=word.toLowerCase();
            if(!lowermp.containsKey(lower)){
                lowermp.put(lower,word);
            } 
            String vowel=replacevowel(word);
            if(!vowelmp.containsKey(vowel)){
                vowelmp.put(vowel,word);
            }
        }

        String[] ans=new String[queries.length];
        for(int i=0;i<ans.length;i++){ 
            String query = queries[i];
            if(exactset.contains(query)){
                ans[i]=query;
            }
            else if(lowermp.containsKey(query.toLowerCase())){
                ans[i]=lowermp.get(query.toLowerCase());
            }
            else if(vowelmp.containsKey(replacevowel(query))){
                ans[i]=vowelmp.get(replacevowel(query));
            }
            else ans[i]="";
        }
        return ans;
    }

public String replacevowel(String word) {
    return word.toLowerCase().replaceAll("[aeiou]", "*");
}
}