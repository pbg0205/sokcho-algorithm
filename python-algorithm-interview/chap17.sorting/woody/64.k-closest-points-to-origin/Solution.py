class Solution(object):
    def kClosest(self, points, k):
        distance = []
        for point in points:
            distance.append((self.euclidean(point), point))

        return [point for dist, point in sorted(distance)[:k]]


    def euclidean(self, point):
        return sqrt(pow(point[0], 2) + pow(point[1], 2))