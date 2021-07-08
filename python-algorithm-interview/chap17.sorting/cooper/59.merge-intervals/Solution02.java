import java.util.*;

/**
 * 실행 시간 : 9ms (21.32%)
 * 메모리 사용량 : 41.2MB (94.18%)
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

