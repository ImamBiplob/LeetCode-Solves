public class RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = head;
        ListNode temp = head.next;

        if (prev.val == temp.val) {
            while (temp.next != null) {
                if (temp.val != prev.val && temp.val != temp.next.val) {
                    head = temp;
                    break;
                }

                temp = temp.next;
                prev = prev.next;
            }

            if (temp.val != prev.val && temp.next == null)
                return temp;
            if (temp.next == null)
                return null;
        }

        ListNode prevValidNode = head;
        prev = head;
        temp = head.next;

        while (temp != null && temp.next != null) {
            if (temp.val != prev.val && temp.val != temp.next.val) {
                prevValidNode.next = temp;
                prevValidNode = temp;
            }

            temp = temp.next;
            prev = prev.next;
        }

        if (temp.val != prev.val) {
            prevValidNode.next = temp;
            prevValidNode = temp;
        }
        prevValidNode.next = null;

        return head;
    }
}
