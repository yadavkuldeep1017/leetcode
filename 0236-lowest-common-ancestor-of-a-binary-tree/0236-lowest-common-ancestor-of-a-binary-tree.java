/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean searchNode(TreeNode tree,TreeNode key){
        if(tree==null){
            return false;
        }
        if(tree==key){
            return true;
        }
        return searchNode(tree.left,key) || searchNode(tree.right,key);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==p || root==q){
            return root;
        }
        if(searchNode(root.left,p)){
            if(searchNode(root.left,q)){
                return lowestCommonAncestor(root.left,p,q);
            }
            return root;
        }
        if(searchNode(root.right,q)){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }
}