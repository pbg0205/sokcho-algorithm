

/*
    Runtime: 27 ms
    Memory Usage: 38.7 MB
 */

class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode sortedHeader = new ListNode(-5001);
        ListNode target = head;

        while (target != null) {
            head = target.next;
            target.next = null;

            insert(sortedHeader, target);
            target = head;
        }
        return sortedHeader.next;
    }

    public void insert(ListNode header, ListNode target) {

        while (header.next != null) {
            if (header.next.val > target.val) {
                ListNode tmp = header.next;
                header.next = target;
                target.next = tmp;
                break;
            }
            header = header.next;
        }

        if (header.next == null) {
            header.next = target;
        }
    }
}