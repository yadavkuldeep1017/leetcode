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

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList();
        }
        List<List<Integer>> answer=new ArrayList();
        List<Integer> list=new ArrayList();
        list.add(root.val);
        answer.add(list);
        List<List<Integer>> leftList=levelOrder(root.left);
        List<List<Integer>> rightList=levelOrder(root.right);
        int leftListLength=leftList.size();
        int rightListLength=rightList.size();
        int i=0;
        for(;i<Math.min(leftListLength,rightListLength);i++){
            List<Integer> origList=new ArrayList();
            origList.addAll(leftList.get(i));
            origList.addAll(rightList.get(i));
            answer.add(origList);
        }
        while(i<leftListLength){
            answer.add(leftList.get(i++));
        }
        while(i<rightListLength){
            answer.add(rightList.get(i++));
        }
        return answer;
    }
}