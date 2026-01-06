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
    public int maxLevelSum(TreeNode root) {
        int level = 1;
        int maxSum = root.val;
        Queue<TreeNode> q = new ArrayDeque();
        q.add(root);
        int currLevel = 1;
        while(!q.isEmpty()){
            int size = q.size();
            int sum = 0;
            for(int i = 0; i < size; i++){
                TreeNode tree = q.poll();
                sum += tree.val;
                if(tree.left != null){
                    q.add(tree.left);
                }
                if(tree.right != null){
                    q.add(tree.right);
                }
            }
            if(sum > maxSum){
                maxSum = sum;
                level = currLevel;
            }
            currLevel++;
        }
        return level;
    }
}