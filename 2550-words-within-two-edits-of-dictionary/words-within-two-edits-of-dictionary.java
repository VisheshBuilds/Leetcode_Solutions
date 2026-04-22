class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> list=new ArrayList<>();
        
        for(int i=0;i<queries.length;i++){
            for(int p=0;p<dictionary.length;p++){
                 int diff=0;
                for(int j=0;j<dictionary[0].length();j++){
                   if(queries[i].charAt(j)!=dictionary[p].charAt(j)){
                    diff++;
                }
                if(diff>2) break;
            }
                if(diff<=2) {
                list.add(queries[i]);
                break;
                }
            } 
        }
        return list;
    }
}