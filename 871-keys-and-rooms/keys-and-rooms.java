class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[] visit=new boolean[n];
        visit[0]=true;
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int key=q.remove();
            visit[key]=true;
            List<Integer> pass=rooms.get(key);
            int i=0;
            while(i<pass.size()){

                if(!visit[pass.get(i)]){
                    q.add(pass.get(i));
                    visit[pass.get(i)]=true;
                } 
                i++;
            }
        }
        for(int i=0;i<n;i++){
            if(!visit[i]) return false;
        }
        return true;
    }
}