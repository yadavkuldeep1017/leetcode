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
    private int max = Integer.MIN_VALUE ;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return max ;
    }

    private int maxSum(TreeNode node){
        if(node==null){
            return -1001;
        }
        int currentMax=node.val;
        int left = maxSum(node.left);
        int right = maxSum(node.right);
        currentMax=Math.max(currentMax,left+node.val);
        currentMax=Math.max(currentMax,right+node.val);
        max=Math.max(max,left);
        max=Math.max(max,right);
        max=Math.max(max,currentMax);
        max=Math.max(max,left+right+node.val);
        // System.out.println(node.val+" "+left+" "+right+" "+max+" "+currentMax);
        return currentMax;
    }
}