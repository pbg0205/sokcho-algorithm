import java.util.*;

public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> mergedList = new ArrayList<>();

        mergedList.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int nowIdx = mergedList.size() - 1;
            int[] mergedItem = mergedList.get(nowIdx);

            if (intervals[i][0] <= mergedItem[1]) {
                if(intervals[i][1] > mergedItem[1]){
                    mergedList.get(nowIdx)[1] = intervals[i][1];
                }
                continue;
            }
            mergedList.add(intervals[i]);
        }

        return mergedList.stream().toArray(int[][]::new);
    }
}

