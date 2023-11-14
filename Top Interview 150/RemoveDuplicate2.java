public class RemoveDuplicate2 {
    public int removeDuplicates(int[] nums) {
        int k = 0, c = 1;

        for (int i = 1; i < nums.length; i++) {
            if (c < 2 && nums[k] == nums[i]) {
                nums[++k] = nums[i];
                c++;
            } else if (nums[k] != nums[i]) {
                nums[++k] = nums[i];
                c = 1;
            }
        }

        return ++k;
    }

    public int removeDuplicatesOther(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i - 2])
                nums[i++] = n;
        return i;
    }
}
