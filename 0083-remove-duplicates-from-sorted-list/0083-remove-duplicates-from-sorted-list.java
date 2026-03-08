class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;

        ListNode left = head;
        ListNode right = head.next;

        while(right != null) {

            while(right != null && left.val == right.val) {
                right = right.next;
            }

            left.next = right;
            left = right;

            if(right != null) right = right.next;
        }

        return head;
    }
}