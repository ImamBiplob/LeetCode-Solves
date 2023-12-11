public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode resultList = new ListNode();
        ListNode currentNode = resultList;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                currentNode.next = list1;
                list1 = list1.next;
            } else {
                currentNode.next = list2;
                list2 = list2.next;
            }
            currentNode = currentNode.next;
        }

        currentNode.next = list1 == null ? list2 : list1;

        return resultList.next;
    }

    public ListNode mergeTwoListsUsingRecursion(ListNode list1, ListNode list2) {

        if (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }

        if (list1 == null)
            return list2;

        return list1;
    }
}
