public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultList = new ListNode();
        int carry = l1.val + l2.val > 9 ? 1 : 0;
        resultList.val = carry == 1 ? (l1.val + l2.val) % 10 : l1.val + l2.val;
        ListNode tail = resultList;
        l1 = l1.next;
        l2 = l2.next;

        while (l1 != null || l2 != null) {
            tail.next = new ListNode();
            tail = tail.next;
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sum = l1Val + l2Val + carry;

            if (sum > 9) {
                carry = 1;
                sum = sum % 10;
            } else {
                carry = 0;
            }

            tail.val = sum;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        if (carry == 1) {
            tail.next = new ListNode();
            tail.next.val = 1;
        }

        return resultList;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
