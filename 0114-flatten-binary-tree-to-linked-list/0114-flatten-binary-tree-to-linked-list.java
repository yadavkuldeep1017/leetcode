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
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        if(root.left!=null){
            flatten(root.left);
        }
        if(root.right!=null){
            flatten(root.right);
        }
        TreeNode leftTree=root.left;
        TreeNode rightTree=root.right;
        root.left=null;
        root.right=leftTree;
        while(root.right!=null){
            root=root.right;
        }
        root.right=rightTree;
    }
}