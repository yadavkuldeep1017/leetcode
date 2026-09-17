class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while (true) {
            // Find the k-th node of the current group
            ListNode kthNode = getKthNode(groupPrev, k);

            // Fewer than k nodes remain: do not reverse them
            if (kthNode == null) {
                break;
            }

            ListNode groupNext = kthNode.next;

            // Reverse nodes from groupPrev.next up to kthNode
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

            while (curr != groupNext) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Connect the reversed group to the previous part
            ListNode oldGroupStart = groupPrev.next;
            groupPrev.next = kthNode;
            groupPrev = oldGroupStart;
        }

        return dummy.next;
    }

    private ListNode getKthNode(ListNode start, int k) {
        while (start != null && k > 0) {
            start = start.next;
            k--;
        }
        return start;
    }
}