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
    List<Integer> answer;
    public void equalDistance(TreeNode tree,int k){
        if(tree==null){
            return;
        }
        if(k==0){
            answer.add(tree.val);
            return;
        }
        equalDistance(tree.left,k-1);
        equalDistance(tree.right,k-1);
    }
    public int distance(TreeNode tree,TreeNode target,int k){
        if(tree==null){
            return -1;
        }
        // System.out.println(tree.val+" v ");
        if(k==0){
            answer.add(tree.val);
            return -1;
        }
        if(tree==target){
            equalDistance(tree.left,k-1);
            equalDistance(tree.right,k-1);
            return k-1;
        }
        int left=distance(tree.left,target,k);
        // System.out.println(left);
        if(left>-1){
            if(left==0){
                answer.add(tree.val);
                return -1;
            }
            equalDistance(tree.right,left-1);
            return left-1;
        }
        int right=distance(tree.right,target,k);
                // System.out.println(right);
        if(right>-1){
            if(right==0){
                answer.add(tree.val);
                return -1;
            }
            equalDistance(tree.left,right-1);
            return right-1;
        }
        return -1;
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        answer=new ArrayList();
        if(root==null){
            return answer;
        }
        if(k==0){
            answer.add(target.val);
            return answer;
        }
        distance(root,target,k);
        return answer;
    }
}