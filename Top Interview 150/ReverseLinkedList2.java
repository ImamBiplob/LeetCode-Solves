import java.util.HashMap;
import java.util.Map;

public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right)
            return head;

        Map<Integer, ListNode> map = new HashMap<>();

        if (left == 1) {
            ListNode temp = head;
            for (int i = left; i <= right; i++) {
                if (i == right) {
                    head = temp;
                } else {
                    map.put(i, temp);
                }

                temp = temp.next;
            }

            ListNode reverseAfter = temp;
            temp = head;
            for (int i = right - 1; i >= left; i--) {
                temp.next = map.get(i);
                temp = temp.next;

                if (i == left) {
                    temp.next = reverseAfter;
                }
            }

            return head;
        }

        ListNode reverseBefore = head;
        for (int i = 1; i < left - 1; i++) {
            reverseBefore = reverseBefore.next;
        }

        ListNode temp = reverseBefore;
        for (int i = left; i <= right; i++) {
            temp = temp.next;
            map.put(i, temp);
        }

        ListNode reverseAfter = temp.next;
        temp = reverseBefore;
        for (int i = right; i >= left; i--) {
            temp.next = map.get(i);
            temp = temp.next;

            if (i == left) {
                temp.next = reverseAfter;
            }
        }

        return head;
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
