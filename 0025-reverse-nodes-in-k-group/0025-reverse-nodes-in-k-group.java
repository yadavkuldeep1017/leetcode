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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1){
            return head;
        }
        int length = 0;
        ListNode trav = head;
        while(trav != null){
            trav = trav.next;
            length++;
        }
        int totalRev = length / k;
        ListNode currNode = head;
        ListNode startNode = null;
        while(totalRev > 0){
            ListNode nextNode = currNode.next;
            ListNode prevNode = currNode;
            for(int i = 0; i < k - 1; i++){
                prevNode.next = nextNode.next;
                nextNode.next = currNode;
                currNode = nextNode;
                nextNode = prevNode.next;
                if(startNode != null){
                    startNode.next = currNode;
                }
            }
            if(startNode == null){
                head = currNode;
            }
            startNode = prevNode;
            currNode = nextNode;
            totalRev--;
        }
        return head;
    }
}