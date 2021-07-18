class Solution(object):

    # set 기능 활용
    def intersection(self, nums1, nums2):
        set1 = set(nums1)
        set2 = set(nums2)
        return set1.intersection(set2)

    # 투 포인터
    def intersection2(self, num1, num2):
        result = set()
        nums1.sort()
        nums2.sort()
        i = j = 0

        while i < len(nums1) and j < len(nums2):
            if nums1[i] > nums2[j]:
                j += 1

            elif nums1[i] < nums2[j]:
                i += 1
            else:
                result.add(nums1[i])
                i += 1
                j += 1

        return result