
class Solution {
    public int n;
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        n=level(root);
        for(int i=0;i<n;i++){
            List<Integer> arr=new ArrayList<>();
           nthlevel(root,0,i,arr);
           ans.add(arr);
        }
        return ans;
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