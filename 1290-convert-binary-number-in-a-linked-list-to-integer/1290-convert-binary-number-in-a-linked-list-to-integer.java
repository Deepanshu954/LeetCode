class Solution {
    public int getDecimalValue(ListNode head) {
        ListNode curr = head;

        int res = 0;

        while(curr != null) {
            res = res * 2 + curr.val;
            curr = curr.next;
        }

        return res;
    }
}