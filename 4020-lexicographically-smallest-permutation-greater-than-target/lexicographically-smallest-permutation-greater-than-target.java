class Solution {
    String result="";
    public boolean solve(StringBuilder curr,String target,int i,int[] count,boolean greater){
        if(i==target.length()){
            if(greater){
                result=curr.toString();
                return true;
            }
            return false;
        }

        for(char ch='a';ch<='z';ch++){
            if(count[ch-'a']==0) continue;
            if(greater==false && ch < target.charAt(i)) continue;

            curr.append(ch);
            count[ch-'a']--;

            boolean isGreater=greater || ch>target.charAt(i);
            if(solve(curr,target,i+1,count,isGreater)) return true;

            curr.deleteCharAt(curr.length()-1);
            count[ch-'a']++;
        }
        return false;
    }
    public String lexGreaterPermutation(String s, String target) {
        int[] count=new int[26];
        for(char ch:s.toCharArray()) count[ch-'a']++;
          
        StringBuilder sb=new StringBuilder();  
        solve(sb,target,0,count,false);
        
        return result;
    }
}