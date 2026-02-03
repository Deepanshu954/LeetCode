class Solution {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // 1. split list
        ListNode mid = getMid(head);
        ListNode right = mid.next;
        mid.next = null;

        // 2. sort halves
        ListNode leftSorted = sortList(head);
        ListNode rightSorted = sortList(right);

        // 3. merge
        return merge(leftSorted, rightSorted);
    }

    private ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // mid-left
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}