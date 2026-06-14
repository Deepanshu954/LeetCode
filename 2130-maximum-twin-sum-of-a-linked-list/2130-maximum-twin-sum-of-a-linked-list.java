class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode curr = slow;
        ListNode prev = null;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }



        ListNode left = head;
        ListNode mid = prev;

        int res = 0;

        while(mid != null) {
            res = Math.max(res, left.val + mid.val);
            left = left.next;
            mid = mid.next;
        }

        return res;
    }
}