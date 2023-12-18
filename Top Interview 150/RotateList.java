public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null)
            return head;

        ListNode temp = head;
        int length = 1;

        while (temp.next != null) {
            length++;
            temp = temp.next;
        }

        k = k % length;
        if (k == 0)
            return head;
        temp.next = head;

        for (int i = 0; i < length - k; i++) {
            temp = temp.next;
        }

        head = temp.next;
        temp.next = null;

        return head;
    }
}
