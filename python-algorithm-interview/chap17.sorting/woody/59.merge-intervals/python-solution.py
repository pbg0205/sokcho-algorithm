

class Solution(object):
    """
        :type intervals: List[List[int]]
        :rtype: List[List[int]]
        """

    def merge(self, intervals):
        answer = []
        intervals.sort()
        front, rear = intervals[0]

        for nextFront, nextRear in intervals[1:]:
            # not overlapping
            if rear < nextFront:
                answer.append([front, rear])
                front, rear = nextFront, nextRear
            else:
                rear = max(rear, nextRear)

        if answer == [] or intervals[-1][1] != answer[-1][1]:
            answer.append([front, rear])

        return answer


