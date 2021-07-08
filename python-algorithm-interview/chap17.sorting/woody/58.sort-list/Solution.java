/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution {

    public ListNode sortList(ListNode head) {
        return divideAndMerge(head);
    }

    public ListNode divideAndMerge(ListNode head) {
        if (head == null || head.next == null) return head;
        // 중간 지점을 찾고
        ListNode mid = getMid(head);
        // 중간지점을 기점으로 왼쪽과 오른쪽 두 개의 sub-problem으로 분할한다.
        ListNode left = divideAndMerge(head);
        ListNode right = divideAndMerge(mid);
        // divideAndMerge() 메소드를 통해서 정렬이 된 sub-problem들을 다시 합쳐준다.
        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right) {
        // dummy node for avoiding null pointer exception
        ListNode head = new ListNode();
        ListNode tail = head;
        while (left != null && right != null) {
            if (left.val < right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }

        if (left == null && right != null) {
            tail.next = right;
        }
        if (left != null && right == null) {
            tail.next = left;
        }
        return head.next;
    }


    public ListNode getMid(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // cut the connection between mid and head
        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }

    public void printAll(ListNode current) {
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
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
}