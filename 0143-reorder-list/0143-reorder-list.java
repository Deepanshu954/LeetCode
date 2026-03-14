class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. reverse second half
        ListNode curr = slow.next;
        slow.next = null;
        ListNode prev = null;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // 3. merge two lists
        ListNode left = head;
        ListNode right = prev;

        while(right != null){
            ListNode temp1 = left.next;
            ListNode temp2 = right.next;

            left.next = right;
            right.next = temp1;

            left = temp1;
            right = temp2;
        }
    }
}