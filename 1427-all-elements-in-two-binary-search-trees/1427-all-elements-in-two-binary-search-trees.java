class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans1=new ArrayList<>();
        List<Integer> ans2=new ArrayList<>();
        helper(root1,ans1);
        helper(root2,ans2);
        return merge(ans1,ans2);
    }
    public void helper(TreeNode root,List<Integer> ans){
        if(root==null) return;
        helper(root.left,ans);
        ans.add(root.val);
        helper(root.right,ans);
    }
    public List<Integer> merge(List<Integer> l1,List<Integer> l2){
        int i=0,j=0;
        List<Integer> ans=new ArrayList<>();
        while(i < l1.size() && j < l2.size()){
            if(l1.get(i) >=l2.get(j)) {
                ans.add(l2.get(j)); 
                j++;
                }
            else {
                ans.add(l1.get(i)); 
                i++;}

        }
        while(i < l1.size()) {
            ans.add(l1.get(i));
            i++;
        }
        while(j < l2.size()) {
            ans.add(l2.get(j));
            j++;
        }

        return ans;
    }
}