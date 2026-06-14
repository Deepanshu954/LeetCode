class Solution {
    public int pairSum(ListNode head) {
        // find mid of ll

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse right half of ll
        ListNode curr = slow;
        ListNode prev = null;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // add left and right part one by one choose max
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