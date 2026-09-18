
class Solution {
    class Pair {
        TreeNode root;
        int col,level;
        Pair(TreeNode root,int level,int col){
            this.root=root;
            this.level=level;
            this.col=col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        Queue<Pair> q=new LinkedList<>();
        TreeMap<Integer,List<int[]>> map=new TreeMap<>();

        q.offer(new Pair(root,0,0));
        while(q.size()>0){
            Pair top=q.remove();
            TreeNode r=top.root;
            int col=top.col,level=top.level;
            if(!map.containsKey(col)) map.put(col,new ArrayList<>());
            map.get(col).add(new int[]{level, r.val});

            if(r.left!=null){
                q.add(new Pair(r.left,level+1,col-1));
            }
            if(r.right!=null){
                q.add(new Pair(r.right,level+1,col+1));
            }
        }

        for(int c:map.keySet()){
            List<int[]> list=map.get(c);
            list.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
            // for(int ele:map.get(c)){
            //     list.add(ele);
            // }
            List<Integer> colVals = new ArrayList<>();
            for (int[] e : list) colVals.add(e[1]);
            
            ans.add(colVals);
        }
        return ans;
    }
}