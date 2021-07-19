class Solution(object):
    # 예외 케이스 발생
    # [[4,5,10,15,19,20,20],[4,9,12,15,22,23,26],[7,11,12,20,25,27,27],[10,14,17,23,27,30,32],[11,18,19,24,28,34,39]]
    # 25
    def searchMatrix(self, matrix, target): # fail
        row, col = self.diagonal(matrix, target)

        if matrix[row][col] == target: return True
        print(row, col)

        for i in range(row + 1):
            for j in range(col, len(matrix[0])):
                if matrix[i][j] == target: return True

        for j in range(col + 1):
            for i in range(row, len(matrix)):
                if matrix[i][j] == target: return True

        return False



    def diagonal(self, matrix, target): # fail
        m, n = len(matrix) - 1, len(matrix[0]) - 1 # 세로, 가로
        minimum, maximum = min(m, n), max(m, n)

        for i in range(minimum):
            if matrix[i][i] >= target:
                return (i, i)

        for i in range(minimum + 1, maximum):
            if m > n:
                if matrix[i][minimum] >= target:
                    return (i, minimum)
            else:
                if matrix[minimum][i] >= target:
                    return (minimum, i)

        return (m, n)

    def searchMatrix(self, matrix, target): # 답지 참고 - 행렬의 오른쪽 위에서 출발
        r, c = 0, len(matrix[0]) - 1

        while r < len(matrix) and 0 <= c:
            if matrix[r][c] == target: return True
            elif matrix[r][c] > target:
                c -= 1
            else:
                r += 1

        return False
