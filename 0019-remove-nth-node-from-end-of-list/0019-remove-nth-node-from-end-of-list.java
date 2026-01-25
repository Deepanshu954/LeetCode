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
 
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode curr = head;

        // 1. find size
        while (curr != null) {
            size++;
            curr = curr.next;
        }

        int pos = size - n; // number of steps from head

        // 2. delete head
        if (pos == 0) {
            return head.next;
        }

        // 3. move to (pos - 1)th node
        curr = head;
        for (int i = 0; i < pos - 1; i++) {
            curr = curr.next;
        }

        // 4. delete
        curr.next = curr.next.next;

        return head;
    }
}