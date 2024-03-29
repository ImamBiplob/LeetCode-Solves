import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int left = 0;
        int right = list.size() - 1;
        while (left < right && list.get(left) == list.get(right)) {
            left++;
            right--;
        }

        return left >= right;
    }

    // 2nd Solution

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public boolean isPalindrome2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rev = reverse(slow.next);
        while (rev != null) {
            if (head.val != rev.val) {
                return false;
            }
            head = head.next;
            rev = rev.next;
        }

        return true;
    }

    // 3rd Solution

    private static final int[] array = new int[100_000];

    public boolean isPalindrome3(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        final int[] arr = array;

        int i = 0;
        while (head != null) {
            arr[i++] = head.val;
            head = head.next;
        }

        int range = i / 2;
        for (int j = 0; j < range; j++) {
            if (arr[j] != arr[--i]) {
                return false;
            }
        }

        return true;
    }
}
