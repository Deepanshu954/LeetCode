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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 1.Check for base Case
        if(head == null || head.next == null) return head;

        // 2. Initilie dummy node
        // Conncect dummy to head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 3. Find left 
        ListNode prev = dummy;
        for(int i = 0; i < left-1; i++) {
            prev = prev.next;
        }

        // 4. Reverse the portion
        ListNode curr = prev.next;
        for(int i = 0; i < right - left; i++) {
            ListNode temp = curr.next;
            curr.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }

        return dummy.next;
    }
}