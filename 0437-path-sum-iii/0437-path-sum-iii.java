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
    public int countPath(TreeNode root, long targetSum){
        if(root == null){
            return 0;
        }
        int ans = 0;
        if(root.val == targetSum){
            ans++; 
        }
        ans += countPath(root.left, targetSum - root.val);
        ans += countPath(root.right, targetSum - root.val);
        return ans;
    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        int ans = countPath(root, targetSum);
        ans += pathSum(root.left, targetSum);
        ans += pathSum(root.right, targetSum);
        return ans;
    }
}