class Solution(object):
    def getSum(self, a, b):
        mask = 0xffffffff
        while b:
            sum = (a ^ b) & mask
            carry = ((a & b) << 1) & mask
        a = sum
        b = carry

        if (a >> 31) & 1: # if negative
            return ~(a ^ mask) # complement
        return a

    def getSum2(self, a, b): # fail
        result = ''
        carry = 0
        while(a > 0 or b > 0):

            s, carry = self.fullAdder(self.lastBit(a), self.lastBit(b), carry)

            result = str(s) + result

            a = a >> 1
            b = b >> 1

        if carry > 0:
            result = '1' + result

        return int(result, 2)
    """
    :type a: int
    :type b: int
    :rtype: int
    """

    def fullAdder(self, a, b, carry_in):
        s1, c1 = self.halfAdder(a, b)
        s2, c2 = self.halfAdder(s1, carry_in)
        return s2, c1 | c2


    def halfAdder(self, a, b):
        # rest, carry
        return a ^ b, a & b

    def lastBit(self, num):
        return int(bin(num & 1), 2) # 혹은 eval(bin(num & 1))
