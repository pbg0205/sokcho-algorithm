class Solution(object):

    def search(self, nums, target):
        start = self.pivot(nums)

        if len(nums) == 1:
            return 0 if nums[0] == target else -1

        left, right = 0, len(nums) - 1

        while (left <= right):
            mid = (left + right) // 2

            mid_idx = self.actualIdx(mid, nums, start)

            if nums[mid_idx] == target:
                return mid_idx

            if nums[mid_idx] <= target:
                left = mid + 1

            else:
                right = mid - 1

        return -1

    def actualIdx(self, target, nums, start):
        return (target + start) % len(nums)

    def pivot(self, nums):
        left, right = 0, len(nums) - 1
        if right == 0: return 0

        while (left < right):
            mid = (left + right) // 2

            if nums[mid] > nums[right]:
                left = mid + 1
            else:
                right = mid

        return left