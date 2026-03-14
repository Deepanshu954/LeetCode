class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = l1;
        ListNode prev = null;
        int carry = 0;

        while(l1 != null || l2 != null){

            if(l1 == null){
                prev.next = l2;
                l1 = l2;
                l2 = null;
            }

            int sum = l1.val + carry + (l2 != null ? l2.val : 0);

            l1.val = sum % 10;
            carry = sum / 10;

            prev = l1;
            l1 = l1.next;

            if(l2 != null) l2 = l2.next;
        }

        if(carry > 0) prev.next = new ListNode(carry);

        return head;
    }
}