class Solution {

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        // Paths starting exactly at root
        int pathsStartingHere = countPaths(root, targetSum);

        // Paths starting somewhere in the left or right subtree
        int pathsInLeftSubtree = pathSum(root.left, targetSum);
        int pathsInRightSubtree = pathSum(root.right, targetSum);

        return pathsStartingHere
                + pathsInLeftSubtree
                + pathsInRightSubtree;
    }

    private int countPaths(TreeNode node, long remainingSum) {
        if (node == null) {
            return 0;
        }

        int count = 0;

        if (node.val == remainingSum) {
            count++;
        }

        // Once the path starts, it can only continue downward.
        count += countPaths(node.left, remainingSum - node.val);
        count += countPaths(node.right, remainingSum - node.val);

        return count;
    }
}