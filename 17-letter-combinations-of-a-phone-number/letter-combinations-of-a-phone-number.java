class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        HashMap<Character,String> map=new HashMap<>();
        for(int i=2;i<10;i++){
            if(i==2) map.put('2',"abc");
            if(i==3) map.put('3',"def");
            if(i==4) map.put('4',"ghi");
            if(i==5) map.put('5',"jkl");
            if(i==6) map.put('6',"mno");
            if(i==7) map.put('7',"pqrs");
            if(i==8) map.put('8',"tuv");
            if(i==9) map.put('9',"wxyz");
        }
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