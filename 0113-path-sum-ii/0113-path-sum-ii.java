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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return new ArrayList();
        }
        List<List<Integer>> ans = new ArrayList();
        if(root.val == targetSum && root.left == null && root.right == null){
            List<Integer> list = new ArrayList();
            list.add(root.val);
            ans.add(list);
            return ans;
        }
        List<List<Integer>> left = pathSum(root.left, targetSum - root.val);
        List<List<Integer>> right = pathSum(root.right, targetSum - root.val);
        for(int i = 0; i < left.size(); i++){
            List<Integer> list = new ArrayList();
            list.add(root.val);
            list.addAll(left.get(i));
            ans.add(list);
        }
        for(int i = 0; i < right.size(); i++){
            List<Integer> list = new ArrayList();
            list.add(root.val);
            list.addAll(right.get(i));
            ans.add(list);
        }
        return ans;
    }
}