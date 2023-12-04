import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> resultList = new ArrayList<>();
        Arrays.sort(intervals, (arr1, arr2) -> arr1[0] - arr2[0]);

        for (int i = 0; i < intervals.length; i++) {
            int valAtIndex0 = intervals[i][0];
            int valAtIndex1 = intervals[i][1];
            while (i + 1 < intervals.length && intervals[i + 1][0] <= valAtIndex1) {
                valAtIndex1 = Math.max(intervals[i + 1][1], valAtIndex1);
                i++;
            }
            resultList.add(new int[] { valAtIndex0, valAtIndex1 });
        }

        return resultList.toArray(new int[0][]);
    }
}
