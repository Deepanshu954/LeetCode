class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode ans = res;

        int carry = 0;

        while(l1 != null || l2 != null) {
            int a = 0;
            int b = 0;

            if(l1 != null){
                a = l1.val;
                l1 = l1.next;
            }

            if(l2 != null){
                b = l2.val;
                l2 = l2.next;
            }

            int sum = a + b + carry;

            ListNode newNode = new ListNode();
            newNode.val = sum % 10;

            res.next = newNode;
            res = res.next;

            carry = sum / 10;
        }

        if(carry > 0){
            res.next = new ListNode(carry);
        }

        return ans.next;
    }
}