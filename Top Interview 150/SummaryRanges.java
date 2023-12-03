import java.util.List;
import java.util.ArrayList;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> resultList = new ArrayList<>();
        if (nums.length == 0)
            return resultList;

        if (nums.length == 1)
            resultList.add("" + nums[0]);

        int start = 0;
        int end = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                end = i;
                if (i == nums.length - 1)
                    resultList.add(nums[start] + "->" + nums[end]);

            } else {
                if (start != end)
                    resultList.add(nums[start] + "->" + nums[end]);
                else
                    resultList.add("" + nums[start]);
                start = i;
                end = i;
                if (i == nums.length - 1)
                    resultList.add("" + nums[start]);
            }
        }

        return resultList;
    }

    public List<String> summaryRanges2(int[] nums) {
        List<String> resultList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];

            while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1])
                i++;

            if (start != nums[i]) {
                resultList.add(start + "->" + nums[i]);
            } else {
                resultList.add("" + start);
            }
        }

        return resultList;
    }
}
