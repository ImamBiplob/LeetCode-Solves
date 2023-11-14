import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        nums = Arrays.stream(nums).sorted().toArray();
        int c = 1, majorityElement = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                c++;
                if (c > nums.length / 2) {
                    majorityElement = nums[i];
                    break;
                }
            } else {
                c = 1;
            }
        }

        return majorityElement;
    }

    public int majorityElement2(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        nums = Arrays.stream(nums).sorted().toArray();
        return nums[nums.length / 2];
    }

    public int majorityElement3(int[] nums) {
        int majorityElement = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > nums.length / 2) {
                majorityElement = nums[i];
                break;
            }
        }

        return majorityElement;
    }
}
