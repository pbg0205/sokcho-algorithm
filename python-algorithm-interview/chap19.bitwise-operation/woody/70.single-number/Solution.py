import collections
class Solution(object): # without bitmasking
    # Runtime: 128 ms, faster than 42.24%
    # Memory Usage: 16.8 MB, less than 5.14%
    def singleNumber(self, nums):
        num_cnt = collections.Counter(nums)
        for key, value in num_cnt.items():
            if value == 1:
                return key


class Solution(object): # [fail] bitmasking approach
    def singleNumber(self, nums):
        result = 0
        for num in nums:
        result = self.masking(num, result)

        for idx, bit in enumerate(reversed(bin(result))):
            if bit == 'b': break
            if bit == '1': return idx

        return -1

    def masking(self, idx, result):
        mask = 1 << idx
        if bin(result & mask) == bin(0):
            return result + mask
        return result - mask

class Solution(object):  # [success] bitmasking approach
    def singleNumber(self, nums):
        result = 0
        for num in nums:
            result ^= num

        return result