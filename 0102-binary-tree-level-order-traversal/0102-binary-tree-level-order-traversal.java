
class Solution {
    public int n;

    public class Pair{
        TreeNode node;
        int level;
        Pair(TreeNode node,int level){
            this.node=node;
            this.level=level;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
                //METHOD 1(RECURSION)

        // List<List<Integer>> ans=new ArrayList<>();
        // n=level(root);
        // for(int i=0;i<n;i++){
        //     List<Integer> arr=new ArrayList<>();
        //    nthlevel(root,0,i,arr);
        //    ans.add(arr);
        // }
        // return ans;


              //METHOD 2(QUEUE)
        
        List<List<Integer>> ans=new ArrayList<>();
        n=level(root);
        for(int i=0;i<n;i++){
            List<Integer> arr=new ArrayList<>();
            ans.add(arr);
        }
        levelorderq(root,ans);
        return ans;
    }


    private  void levelorderq(TreeNode root,List<List<Integer>> ans){
        Queue<Pair> q2=new LinkedList<>();
        if(root!=null) q2.add(new Pair(root,0));
        while(q2.size()>0){
            Pair front=q2.remove();
            TreeNode temp=front.node;
            int lvl=front.level;

            ans.get(lvl).add(temp.val);

            if(temp.left!=null) q2.add(new Pair(temp.left,lvl+1));
            if(temp.right!=null) q2.add(new Pair(temp.right,lvl+1));
        }
    }


    public void nthlevel(TreeNode root,int level,int req,List<Integer> arr){
       if(root==null) return;
       if(level>req) return;
       if(level==req) arr.add(root.val);
       nthlevel(root.left,level+1,req,arr);
       nthlevel(root.right,level+1,req,arr);
    }
    public int level(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(level(root.left),level(root.right));
    }
}