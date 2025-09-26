class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
             //METHOD 1(RECURSIVE)
        // List<Integer> ans=new ArrayList<>();
        // inorder(root,ans);
        // return ans;

              //METHOD 2(USING STACK)
        // List<Integer> ans=new ArrayList<>();
        // Stack<TreeNode> st=new Stack<>();
        // TreeNode temp=root;
        // while(true){
        //     if(temp!=null){
        //         st.push(temp);
        //         temp=temp.left;
        //     }
        //     else{
        //         if(st.isEmpty()) break;
        //         TreeNode top=st.pop();
        //         ans.add(top.val);
        //         temp=top.right;
        //     }
        // }
        // return ans;

             //METHOD 3(MORRIS TRAVERSAL)
        List<Integer> ans=new ArrayList<>();     
        TreeNode curr=new TreeNode();
        curr=root;
        while(curr!=null){
            if(curr.left!=null){
                TreeNode pred=curr.left;
                while(pred.right!=null && pred.right!=curr){
                    pred=pred.right;
                }
                if(pred.right==null){  //link
                    pred.right=curr;
                    curr=curr.left;
                }
                else{       //unlink
                    ans.add(curr.val);
                    curr=curr.right;
                    pred.right=null;
                }
            }
            else {
                ans.add(curr.val);
                curr=curr.right;
            }
        }
        return ans;


    }
    private static void inorder(TreeNode root,List<Integer> ans){
        if(root==null) return;  //base case
        inorder(root.left,ans);
        ans.add(root.val);
        inorder(root.right,ans);
    }
}