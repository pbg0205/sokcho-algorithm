class Solution(object):
    def twoSum(self, numbers, target): # fail

        if numbers[0] == numbers[-1]:


        for pivot in range(len(numbers) - 1):
            complement = target - numbers[pivot]
            result = self.find(numbers[pivot + 1:], complement)

            if result >= 0:
                return [pivot + 1, result + (pivot + 2)]

        return []

    def find(self, numbers, complement): # fail
        left, right = 0, len(numbers) - 1

        while left <= right:
            mid = left + (right - left) // 2
            if numbers[mid] == complement:
                return mid

            if numbers[mid] < complement:
                left = mid + 1
            else:
                right = mid - 1
        return -1

    def twoSum2(self, numbers, target): # success

        for pivot in range(len(numbers) - 1):
            complement = target - numbers[pivot]
            result = bisect.bisect_left(numbers, complement, pivot + 1)

            if result < len(numbers) and numbers[result] == complement:
                return [pivot + 1, result + 1]

        return []
