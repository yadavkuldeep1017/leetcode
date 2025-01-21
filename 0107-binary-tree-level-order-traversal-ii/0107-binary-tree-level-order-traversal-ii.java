/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans=new ArrayList();
        if(root==null){
            return ans;
        }
        Queue<TreeNode> q=new ArrayDeque();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> list=new ArrayList();
            for(int i=0;i<size;i++){
                TreeNode peek=q.poll();
                if(peek.left!=null){
                    q.add(peek.left);
                }
                if(peek.right!=null){
                    q.add(peek.right);
                }
                list.add(peek.val);
            }
            ans.add(0,list);
        }
        return ans;
    }
}