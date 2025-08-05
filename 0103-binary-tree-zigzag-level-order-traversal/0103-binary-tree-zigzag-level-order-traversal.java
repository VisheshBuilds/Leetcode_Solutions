class Solution {
    public class Pair{
        TreeNode node;
        int level;
        Pair(TreeNode node,int level){
            this.node=node;
            this.level=level;
        }
    }
    public int level(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(level(root.left),level(root.right));
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            //METHOD 1: level order using q
        // int n=level(root);
        // List<List<Integer>> ans=new ArrayList<>();
        // for(int i=0;i<n;i++){
        //     List<Integer> arr=new ArrayList<>();
        //     ans.add(arr);
        // }    
        // levelorder(root,ans);
        // for(int i=1;i<n;i=i+2){
        //     Collections.reverse(ans.get(i));
        // }

        // return ans;

             //METHOD 2: recursion(nth level)
        int n=level(root);     
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> arr=new ArrayList<>();
            nthlevel(root,0,i,arr);
            if(i%2==0) ans.add(arr);
            else {
                Collections.reverse(arr);
                ans.add(arr);
            }
        }
        return ans;

    }
    public void levelorder(TreeNode root,List<List<Integer>> ans){
        Queue<Pair> q=new LinkedList<>();
        if(root!=null) q.add(new Pair(root,0));
        while(q.size()>0){
        Pair front=q.remove();
        TreeNode temp=front.node;
        int lvl=front.level;
        ans.get(lvl).add(temp.val);

        if(temp.left!=null) q.add(new Pair(temp.left,lvl+1));
        if(temp.right!=null) q.add(new Pair(temp.right,lvl+1));
        }
    }
    public void nthlevel(TreeNode root,int level,int req,List<Integer> arr){
        if(root==null) return;
        if(level>req) return;
        if(level==req) arr.add(root.val);
        nthlevel(root.left,level+1,req,arr);
        nthlevel(root.right,level+1,req,arr);
    }
}