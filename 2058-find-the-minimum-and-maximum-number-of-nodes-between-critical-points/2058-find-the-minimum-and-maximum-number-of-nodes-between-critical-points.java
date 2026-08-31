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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return new int[]{-1, -1};
        }
        ListNode prevN = head;
        ListNode currN = head.next;
        ListNode nextN = head.next.next;
        int startPoint = -1;
        int latestPoint = -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int index = 1;
        while(nextN != null){
            if((currN.val > prevN.val && currN.val > nextN.val) || (currN.val < prevN.val && currN.val < nextN.val)){
                if(startPoint == -1){
                    startPoint = index;
                    latestPoint = index;
                }
                else{
                    min = Math.min(min , index - latestPoint);
                    max = index - startPoint;
                    latestPoint = index;
                }
            }
            prevN = currN;
            currN = nextN;
            nextN = nextN.next;
            index++;
        }
        if(min == Integer.MAX_VALUE){
            return new int[]{-1, -1};
        }
        return new int[]{min, max};
    }
}