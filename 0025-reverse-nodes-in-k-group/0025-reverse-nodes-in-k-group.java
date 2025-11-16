class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;

        // check length
        for (int i = 0; i < k; i++) {
            if (curr == null) return head;
            curr = curr.next;
        }

        // reverse first k
        ListNode prev = null, next = null;
        curr = head;

        for (int i = 0; i < k; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // recurse on remainder
        head.next = reverseKGroup(curr, k);

        return prev;
    }
}