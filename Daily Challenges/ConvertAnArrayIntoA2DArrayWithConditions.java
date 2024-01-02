import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class ConvertAnArrayIntoA2DArrayWithConditions {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();

        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            numsMap.put(nums[i], numsMap.getOrDefault(nums[i], 0) + 1);

        while (!numsMap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            List<Integer> toBeRemoved = new ArrayList<>();

            for (int num : numsMap.keySet()) {
                temp.add(num);
                numsMap.put(num, numsMap.get(num) - 1);

                if (numsMap.get(num) == 0)
                    toBeRemoved.add(num);
            }

            for (int num : toBeRemoved) {
                numsMap.remove(num);
            }

            resultList.add(temp);
        }

        return resultList;
    }

    public List<List<Integer>> findMatrix2(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        int count = 0;

        while (count < nums.length) {
            List<Integer> tempList = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                if (!tempList.contains(nums[i]) && nums[i] != -1) {
                    tempList.add(nums[i]);
                    nums[i] = -1;
                    count++;
                }
            }

            resultList.add(tempList);
        }

        return resultList;
    }

    public List<List<Integer>> findMatrix3(int[] nums) {
        int n = nums.length, noOfRows = 0;
        int freq[] = new int[n + 1];

        for (int x : nums)
            freq[x]++;
        for (int x : freq)
            noOfRows = Math.max(noOfRows, x);

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < noOfRows; i++)
            ans.add(new ArrayList<>());

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < freq[i]; j++) {
                ans.get(j).add(i);
            }
        }

        return ans;
    }

    public List<List<Integer>> findMatrixBestSolution(int[] nums) {
        int freq[] = new int[nums.length + 1];

        ArrayList<List<Integer>> ans = new ArrayList<>();
        for (int c : nums) {
            if (freq[c] == ans.size()) {
                ans.add(new ArrayList<>());
            }

            ans.get(freq[c]).add(c);
            freq[c]++;
        }

        return ans;
    }
}
