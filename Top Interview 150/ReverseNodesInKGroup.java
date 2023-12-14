import java.util.HashMap;
import java.util.Map;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1)
            return head;

        Map<Integer, ListNode> map = new HashMap<>();
        ListNode beforeReverseHead = null;
        ListNode afterReverseTail = null;
        ListNode temp = head;
        int counter = 1;
        int listIndex = 1;

        while (temp != null) {
            if (counter == 1) {
                beforeReverseHead = temp;
            }

            if (counter == k) {
                beforeReverseHead.next = temp.next;
                if (listIndex / k == 1)
                    head = temp;
                else
                    afterReverseTail.next = temp;
                for (int i = k - 1; i >= 1; i--) {
                    temp.next = map.get(i);
                    if (i == 1) {
                        afterReverseTail = temp.next;
                        break;
                    }

                    temp = temp.next;
                }

                temp = beforeReverseHead.next;
                counter = 1;
                listIndex++;
                continue;
            }

            map.put(counter, temp);
            temp = temp.next;
            counter++;
            listIndex++;
        }

        return head;
    }

    public ListNode reverseKGroupIterative(ListNode head, int k) {
        if (head == null || k == 1)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy, nex = dummy, pre = dummy;
        int count = 0;

        while (cur.next != null) {
            cur = cur.next;
            count++;
        }

        while (count >= k) {
            cur = pre.next;
            nex = cur.next;
            for (int i = 1; i < k; i++) {
                cur.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = cur.next;
            }
            pre = cur;
            count -= k;
        }

        return dummy.next;
    }

    public ListNode reverseKGroupRecursive(ListNode head, int k) {
        ListNode node = head;
        int count = 0;
        while (count < k) {
            if (node == null)
                return head;
            node = node.next;
            count++;
        }

        ListNode pre = reverseKGroup(node, k);
        while (count > 0) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
            count = count - 1;
        }

        return pre;
    }
}
