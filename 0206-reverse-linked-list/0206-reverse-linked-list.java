class Solution {
    public ListNode reverseList(ListNode head) {

        // base case
        if (head == null || head.next == null)
            return head;

        // reverse rest
        ListNode newHead = reverseList(head.next);

        // fix current node
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}