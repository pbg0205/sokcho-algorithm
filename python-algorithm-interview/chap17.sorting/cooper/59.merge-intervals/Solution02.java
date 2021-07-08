import java.util.*;

/**
 * 실행 시간 : 9ms (21.32%)
 * 메모리 사용량 : 41.2MB (94.18%)
 *
 * < leetcode에서 제공한 solution >
 * - 정렬 후, 가장 끝 값의 비교해 최댓값으로 갱신하는 로직
 */

public class Solution02 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        LinkedList<int[]> mergedList = new LinkedList<>();

        for (int[] interval : intervals) {
            if (mergedList.isEmpty() || mergedList.getLast()[1] < interval[0]) {
                mergedList.add(interval);
                continue;
            }
            mergedList.getLast()[1] = Math.max(mergedList.getLast()[1], interval[1]);
        }

        return mergedList.stream().toArray(int[][]::new);
    }
}

