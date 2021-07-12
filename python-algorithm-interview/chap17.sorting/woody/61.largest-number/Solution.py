def newCmp(x, y):
        return cmp(y+x, x+y)

class Solution(object):
        def largestNumber(self, nums):

                str_nums = map(str, nums)

                answer = int(''.join(sorted(str_nums, cmp=newCmp)))

        return str(answer)