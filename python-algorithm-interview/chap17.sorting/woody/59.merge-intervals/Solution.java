import java.util.*;

class Solution {

    public int[][] merge(int[][] intervals) {
        List<int[]> answer = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(list -> list[0]));
        int front = getFront(0, intervals);
        int rear = getRear(0, intervals);

        for(int i = 1; i < intervals.length; i++) {
            int newFront = getFront(i, intervals);
            int newRear = getRear(i, intervals);

            // not overlapping
            if(rear < newFront) {
                answer.add(new int[]{front, rear});
                front = newFront;
                rear = newRear;
            }
            // overlapping
            else {
                rear = Math.max(rear, newRear);
            }

        }

        if(answer.size() == 0 || answer.get(answer.size() - 1)[1] != rear) {
            answer.add(new int[]{front, rear});
        }

        int[][] arrAnswer = new int[answer.size()][2];

        return answer.toArray(arrAnswer);
    }

    public int getFront(int idx, int[][] intervals) {
        return intervals[idx][0];
    }

    public int getRear(int idx, int[][] intervals) {
        return intervals[idx][1];
    }
}