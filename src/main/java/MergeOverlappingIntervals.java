import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * https://leetcode.com/problems/merge-intervals/
 */
public class MergeOverlappingIntervals {
    public static void main(String args[]) {
        MergeOverlappingIntervals moa = new MergeOverlappingIntervals();
        int[][] intervals = {
                {15, 18},
                {2, 6},
                {1, 3},
                {8, 10}
        };

        intervals = moa.merge(intervals);
        for(int i = 0; i < intervals.length; i++) {
            for(int j = 0; j < intervals[i].length; j++) {
                System.out.print(intervals[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        if(intervals.length <= 1)
            return intervals;

        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);

        int currentIndex = 1;
        while(currentIndex < intervals.length) {
            boolean intervalsOverlapping = areIntervalsOverlapping(stack.peek() , intervals[currentIndex]);
            if(intervalsOverlapping) {
                int[] stackPoppedElement = stack.pop();
                int[] newInterval = {stackPoppedElement[0], Math.max(stackPoppedElement[1], intervals[currentIndex][1])};
                stack.push(newInterval);
            } else {
                stack.push(intervals[currentIndex]);
            }

            currentIndex++;
        }


        int[][] result = new int[stack.size()][];
        int index = 0;
        while(!stack.empty()) {
            result[index++] = stack.pop();
        }

        return result;
    }

    public boolean areIntervalsOverlapping(int[] a, int[] b) {
        return a[1] >= b[0] ? true : false;
    }
}
