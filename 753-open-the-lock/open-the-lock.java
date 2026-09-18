class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> set=new HashSet<>(Arrays.asList(deadends));
        if(set.contains("0000")) return -1;

        Set<String> visited=new HashSet<>();
        Queue<Pair<String,Integer>> q=new LinkedList<>();
        q.add(new Pair("0000",0));
        visited.add("0000");

        while(q.size()>0){
            Pair<String,Integer> top=q.remove();
            String s=top.getKey();
            int move=top.getValue();
            if(s.equals(target)) return move;
            
            for(int i=0;i<4;i++){
                for(int delta:new int[]{-1,1}){
                    int newdigit=(s.charAt(i)-'0'+delta+10)%10;
                    String newstr=s.substring(0,i)+newdigit+s.substring(i+1);
                    if(!visited.contains(newstr)&& !set.contains(newstr)){
                        visited.add(newstr);
                        q.add(new Pair(newstr,move+1));
                    }
                }
            }
        }
        return -1;
    }
}