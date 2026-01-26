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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;

        // 1. Check Size
        int size = 0;
        ListNode curr = head;
        while(curr != null) {
            curr = curr.next;
            size++;
        }

        // 2. Value Of K
        k = k % size;
        if(k == 0) return head;

        // 3. Loop till pos
        int pos = size - k - 1;
        curr = head;
        for(int i = 0; i < pos; i++) curr = curr.next;

        // 4. Rotate
        ListNode ans = curr.next;
        curr.next = null;

        curr = ans;
        while(curr.next != null) curr = curr.next;

        curr.next = head;
        return ans;
    }
}