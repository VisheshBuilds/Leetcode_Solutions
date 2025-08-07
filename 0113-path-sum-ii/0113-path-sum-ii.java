
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> arr=new ArrayList<>();
        hasPathSum(root,targetSum,ans,arr);
        return ans;
    }
    public void hasPathSum(TreeNode root, int targetSum,List<List<Integer>> ans,List<Integer> arr) {
        if(root==null) return ;
        arr.add(root.val);
        if(targetSum==root.val &&(root.left==null && root.right==null)) {
            ans.add(new ArrayList<>(arr));
        }

        hasPathSum(root.left,targetSum-root.val,ans,arr);
        hasPathSum(root.right,targetSum-root.val,ans,arr);
        arr.remove(arr.size()-1);
    }
}