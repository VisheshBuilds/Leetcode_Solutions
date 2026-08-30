class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()) return "";
        HashMap<Character,Integer> map=new HashMap<>();
        int len=Integer.MAX_VALUE,l=0,r=0,i=0,j=0,n=s.length();

        while(i<t.length()){
            char ch=t.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
            i++;
        }
        i=0;
        int count=map.size();
        while(j<n){
            char ch=s.charAt(j);
            if(map.containsKey(ch) && map.get(ch)>0){
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0) count--;
            }
            else{
                map.put(ch,map.getOrDefault(ch,0)-1);
            }
            while(count==0){
                if(len > (j-i+1)){
                    len=j-i+1;
                    l=i;
                    r=j;
                }
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
                if(map.get(s.charAt(i)) > 0) count++;
                i++;
            }
            j++;
        }
        
        return len==Integer.MAX_VALUE ? "":s.substring(l,r+1);
    }
}