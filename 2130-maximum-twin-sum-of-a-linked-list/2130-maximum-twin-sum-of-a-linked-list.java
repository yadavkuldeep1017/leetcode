/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        List<Integer> list = new ArrayList();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        int i = 0;
        int n = list.size();
        int maxTwins = 0;
        while(i < n/2){
            maxTwins = Math.max(maxTwins, list.get(i) + 
            list.get(n - 1 - i));
            i++;
        }
        return maxTwins;
    }
}