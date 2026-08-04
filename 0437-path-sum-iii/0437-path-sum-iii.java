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
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> map = new HashMap<>();
        // Initial prefix sum = 0
        map.put(0L, 1);
        return dfs(root, 0L, targetSum, map);
    }
    private int dfs(TreeNode root, long currSum, int targetSum,
        HashMap<Long, Integer> map) {
        if (root == null) {
            return 0;
        }

        currSum += root.val;

        // Count paths ending at current node
        int count = map.getOrDefault(currSum - targetSum, 0);

        // Store current prefix sum
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        // Explore left and right subtrees
        count += dfs(root.left, currSum, targetSum, map);
        count += dfs(root.right, currSum, targetSum, map);

        // Backtrack
        map.put(currSum, map.get(currSum) - 1);
        return count;
    }
}