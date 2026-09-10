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
    int ans = 0;
    public int[] average(TreeNode root){
        if(root.left == null && root.right == null){
            ans++;
            return new int[] { 1, root.val};
        }
        int sum = root.val;
        int count = 1;
        int[] left = new int[]{-1, 0};
        int[] right = new int[]{-1, 0};
        if(root.left != null){
            left = average(root.left);
        }
        if(root.right != null){
            right = average(root.right);
        }
        if(left[0] != -1 && right[0] != -1){
            sum += left[1] + right[1];
            count += left[0] + right[0];
        }
        else if(left[0] == -1){
            sum += right[1];
            count += right[0];
        } 
        else{
            sum += left[1];
            count += left[0];
        }
        if(sum / count == root.val){
            ans++;
        }
        return new int[]{count, sum};
    }
    public int averageOfSubtree(TreeNode root) {
        average(root);
        return ans;

    }
}