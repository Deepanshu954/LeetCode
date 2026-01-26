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
        int size = 0;

        // check size;
        ListNode curr = head;
        while(curr != null) {
            curr = curr.next;
            size++;
        }

        k = k % size;
        if(k == 0) return head;
        int pos = size - k - 1;

        curr = head;
        for(int i = 0; i < pos; i++) curr = curr.next;

        ListNode ans = curr.next;
        curr.next = null;

        curr = ans;
        while(curr.next != null) curr = curr.next;

        curr.next = head;
        return ans;
    }
}