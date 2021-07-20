class Solution(object):
    def hammingDistance(self, x, y):
        return bin(x ^ y).count("1")

class Solution(object): # 찾아본 또 다른 풀이
    def hammingDistance(self, x, y):
        x = x ^ y
        y = 0
        while x:
            y += 1
            x = x & (x - 1) # remove the last bit
        return y