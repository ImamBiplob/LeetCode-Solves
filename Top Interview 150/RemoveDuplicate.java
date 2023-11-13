import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicate {
    public int removeDuplicates(int[] nums) {
        int c = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[c] != nums[i]) {
                nums[++c] = nums[i];
            }
        }

        return ++c;
    }

    public int removeDuplicatesIfNotSorted(int[] nums) {
        List<Integer> traversed = new ArrayList<>();
        int c = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!traversed.contains(nums[i])) {
                traversed.add(nums[i]);
                nums[c++] = nums[i];
            }
        }

        return c;
    }
}
