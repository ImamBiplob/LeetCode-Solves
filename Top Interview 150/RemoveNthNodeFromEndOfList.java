public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length += 1;
            temp = temp.next;
        }

        if (length == 1)
            return temp;

        int removePos = length - n + 1;

        if (removePos == 1)
            return head.next;

        temp = head;
        for (int i = 0; i < removePos; i++) {
            if (i + 1 == removePos) {
                temp.next = temp.next.next;
                break;
            }

            if (i != 0)
                temp = temp.next;
        }

        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode fast = head, slow = head;

        for (int i = 0; i < n; i++)
            fast = fast.next;

        if (fast == null)
            return head.next;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return head;
    }
}
