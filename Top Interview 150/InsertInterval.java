import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> resultList = new ArrayList<>();
        int i = 0;

        while (i < intervals.length && intervals[i][1] < newInterval[0])
            resultList.add(intervals[i++]);

        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        resultList.add(newInterval);

        while (i < intervals.length)
            resultList.add(intervals[i++]);

        return resultList.toArray(new int[0][]);
    }
}
