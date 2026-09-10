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
    public Integer[] average(TreeNode root){
        if(root.left == null && root.right == null){
            return new Integer[] { 1, root.val, 1};
        }
        int sum = root.val;
        int count = 1;
        int ans = 0;
        Integer[] left = null;
        Integer[] right = null;
        if(root.left != null){
            left = average(root.left);
        }
        if(root.right != null){
            right = average(root.right);
        }
        if(left != null && right != null){
            count += left[0] + right[0];
            sum += left[1] + right[1];
            ans += left[2] + right[2];
        }
        else if(left == null){
            count += right[0];
            sum += right[1];
            ans += right[2];

        } 
        else{
            count += left[0];
            sum += left[1];
            ans += left[2];
        }
        if(sum / count == root.val){
            ans++;
        }
        return new Integer[]{count, sum, ans};
    }
    public int averageOfSubtree(TreeNode root) {
        Integer[] ans = average(root);
        return ans[2];
    }
}