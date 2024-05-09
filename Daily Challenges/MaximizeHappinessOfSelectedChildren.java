import java.util.Arrays;

public class MaximizeHappinessOfSelectedChildren {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);

        long maxHappiness = 0;
        int maxIndex = happiness.length - 1;
        for (int i = 0; i < k; i++) {
            maxHappiness += (happiness[maxIndex] - i) > -1 ? happiness[maxIndex] - i : 0;
            maxIndex--;
        }

        return maxHappiness;
    }
}
