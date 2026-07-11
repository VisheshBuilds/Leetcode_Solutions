class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        HashMap<Character,String> map=new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        helper(0,digits,"",ans,map);
        return ans;
    }
    public void helper(int s,String digits,String temp,List<String> ans,HashMap<Character,String> map){
        if(digits.length()==s){
            ans.add(temp);
            return;
        }

        for(int i=0;i<map.get(digits.charAt(s)).length();i++){
            char ch=map.get(digits.charAt(s)).charAt(i);
            helper(s+1,digits,temp+ch,ans,map);
        }

    }
}