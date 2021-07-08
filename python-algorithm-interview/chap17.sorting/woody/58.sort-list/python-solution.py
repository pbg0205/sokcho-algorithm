# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution(object):
    def sortList(self, head):
        return self.mergeSort(head)


    def mergeSort(self, head):
        if head is None or head.next is None:
            return head

        mid = self.getMid(head)
        left = self.mergeSort(head)
        right = self.mergeSort(mid)

        return self.merge(left, right)

    def merge(self, left, right):
        head = ListNode()
        tail = head

        while left != None and right != None:
            if left.val < right.val:
                tail.next = left
                left = left.next

            else:
                tail.next = right
                right = right.next

            tail = tail.next

        tail.next = left if left != None else right

        return head.next


    def getMid(self, head):
        if head == None or head.next == None:
            return head

        slow = head
        fast = head

        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next

        mid = slow.next
        slow.next = None

        return mid