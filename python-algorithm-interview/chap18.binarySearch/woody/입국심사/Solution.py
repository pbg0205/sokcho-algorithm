# 이분 탐색으로 최적의 해 찾기
def solution(n, times):
    left = 0
    right = 1_000_000_000 * n
    while left <= right:
        mid = (left + right) // 2
        total = check(mid, times)

        if total >= n:
            right = mid - 1
        else:
            left = mid + 1

    return left

def check(mid, times):
    total = 0
    for time in times:
        total += mid // time
    return total