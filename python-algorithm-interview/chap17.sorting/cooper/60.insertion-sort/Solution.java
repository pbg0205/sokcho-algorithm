/**
 * - 실행 시간 : 27ms(68.03%)
 * - 메모리 사용량 : 41.7MB(7.39%)
 *
 * < leetcode에서 제공한 solution >
 * - dummy node를 사용해서 정렬된 list를 만드는 로직
 * - dummy node list를 탐색하면서 정렬해야하는 요소를 삽입하는 로직
 */

public class Solution {
    public ListNode insertionSortList(ListNode head) {

        /**
         * 1. dummyNode를 이용해 삽입할 위치를 방법
         *  - dummy : 현재 지점을 나타내주는 노드
         *  - curr : 정렬이 완료된 노드
         */
        ListNode dummy = new ListNode();
        ListNode curr = head;

        while (head != null) {
            ListNode prev = dummy;

            /**
             * 2. current node에 추가할 위치를 찾는다.
             */
            while (curr.next != null && curr.next.val < head.val) {
                curr = curr.next;
            }

            /**
             * 3. 새로운 리스트에 current node를 삽입한다.
             */
            ListNode next = curr.next;

            curr.next = prev.next;
            prev.next = curr;

            /**
             * 4. 다음 순회로 이동한다.
             */
            curr = next;
        }

        return curr.next;
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

