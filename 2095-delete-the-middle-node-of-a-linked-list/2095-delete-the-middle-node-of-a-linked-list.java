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

/*
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) return null;
        if(head.next.next == null) {
            head.next = null;
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        // 1. Find Mid
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Copy value of mid + 1 into mid
        slow.val = slow.next.val;
        slow.next = slow.next.next;

        return head;
    }
}
*/


 
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) return null;
        if(head.next.next == null) {
            head.next = null;
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next.next;

        // 1. Find Mid - 1
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}