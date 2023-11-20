public class TrappingRainWater {
    public int trap(int[] height) {
        int totalTrap = 0;
        int maxHeightIndex = 0;
        int minHeightIndex = 0;
        int trap = 0;

        for (int i = 1; i < height.length; i++) {
            if (height[i] >= height[maxHeightIndex]) {
                totalTrap += trap;
                trap = 0;
                maxHeightIndex = i;
                minHeightIndex = i;
            } else if (height[i] < height[maxHeightIndex] && height[i] > height[minHeightIndex]) {
                int area = height[i] * (i - maxHeightIndex);
                int barCount = 0;

                for (int j = maxHeightIndex + 1; j <= i; j++) {
                    if (height[j] >= height[i]) {
                        barCount += height[i];
                    } else {
                        barCount += height[j];
                        height[j] = height[i];
                    }
                }

                totalTrap += area - barCount;
                trap -= area - barCount;
                trap += height[maxHeightIndex] - height[i];
                minHeightIndex = i;
            } else {
                trap += height[maxHeightIndex] - height[i];
                minHeightIndex = i;
            }
        }

        return totalTrap;
    }

    public int trap2(int[] height) {
        int l = 0, r = height.length - 1, leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE, ans = 0;

        while (l < r) {
            leftMax = Math.max(leftMax, height[l]);
            rightMax = Math.max(rightMax, height[r]);
            ans += (leftMax < rightMax) ? leftMax - height[l++] : rightMax - height[r--];
        }

        return ans;
    }

    public int trap3(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = height[0], rightMax = height[height.length - 1];
        int water = 0;

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                if (leftMax < height[left]) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
            } else {
                right--;
                if (rightMax < height[right]) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
            }
        }

        return water;
    }
}
