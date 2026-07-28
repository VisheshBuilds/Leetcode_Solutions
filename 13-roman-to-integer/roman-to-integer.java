class Solution {
    public int romanToInt(String s) {
        int ans=0,n=s.length();
        int prev=0;
        HashMap<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        for(int i=0;i<n;i++){
           char ch=s.charAt(i);
           int val=map.get(ch);
           if(prev==0 || val <= prev) ans +=val;
           
           else {
               ans = ans +val -2*prev;
           }
           prev=val;
        }
        return ans;
    }
} 