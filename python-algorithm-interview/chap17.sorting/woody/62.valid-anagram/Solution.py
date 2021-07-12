from collections import Counter

class Solution(object):
    def isAnagram(self, s, t):
        s_cnt = Counter(s)
        t_cnt = Counter(t)

        return t_cnt == s_cnt