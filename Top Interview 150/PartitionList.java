import java.util.HashMap;
import java.util.Map;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        Map<Integer, ListNode> map1 = new HashMap<>();
        Map<Integer, ListNode> map2 = new HashMap<>();

        int lengthOfPart1 = 0;
        int lengthOfPart2 = 0;

        for (ListNode temp = head; temp != null; temp = temp.next) {
            if (temp.val < x) {
                map1.put(lengthOfPart1++, temp);
            } else {
                map2.put(lengthOfPart2++, temp);
            }
        }

        if (map1.get(0) == null)
            return head;
        else {
            head = map1.get(0);
            ListNode temp = head;

            for (int i = 0; i < lengthOfPart1; i++) {
                temp.next = map1.get(i);
                temp = temp.next;
            }
            for (int i = 0; i < lengthOfPart2; i++) {
                temp.next = map2.get(i);
                temp = temp.next;
            }
            temp.next = null;
        }

        return head;
    }

    public ListNode partition2(ListNode head, int x) {
        ListNode part1Head = new ListNode();
        ListNode part2Head = new ListNode();
        ListNode part1 = part1Head;
        ListNode part2 = part2Head;

        for (ListNode temp = head; temp != null; temp = temp.next) {
            if (temp.val < x) {
                part1.next = temp;
                part1 = part1.next;
            } else {
                part2.next = temp;
                part2 = part2.next;
            }
        }
        part2.next = null;

        part1.next = part2Head.next;

        return part1Head.next;
    }
}
