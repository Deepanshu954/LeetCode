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
    public ListNode sortList(ListNode head) {
        int n = 0;

        // 1. Size of Linked List
        ListNode temp = head;
        while(temp != null) {temp = temp.next; n++;}


        for(int i = 0; i < n - 1; i++) {
            temp = head;
            for(int j = 0; j < n - i - 1; j++) {
                if(temp.val > temp.next.val) {
                    int t = temp.val;
                    temp.val = temp.next.val;
                    temp.next.val = t;
                }

                temp = temp.next;
            }
        }

        return head;
    }
}