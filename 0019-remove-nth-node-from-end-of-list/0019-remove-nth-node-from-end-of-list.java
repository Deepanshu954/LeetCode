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
        ListNode curr = head;
        int size = 0;

        while(curr.next != null) {
            curr = curr.next;
            size++;
        }

        if(n == 0) {
            curr.next = null;
            return head;
        }

        size++;

        int pos = size - n;

        if(pos == 0) {
            return head.next;
        }
        if(pos == 1 && size == 2) {
            head.next = null;
            return head;
        }

        curr = head;
        size = 0;

        while(curr != null && size < pos -1) {
            curr = curr.next;
            size++;
        }

        curr.next = curr.next.next;
        return head;
        
    }
}