class MergeTwoSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        int i = 0, j = 0;

        for (int c = 0; c < result.length; c++) {
            if (i == m) {
                for (int c1 = c; c1 < m + n; c1++) {
                    result[c1] = nums2[j];
                    j++;
                }

                break;
            } else if (j == n) {
                for (int c1 = c; c1 < m + n; c1++) {
                    result[c1] = nums1[i];
                    i++;
                }

                break;
            } else if (nums1[i] > nums2[j]) {
                result[c] = nums2[j];
                j++;
            } else {
                result[c] = nums1[i];
                i++;
            }
        }

        for (int c = 0; c < m + n; c++) {
            nums1[c] = result[c];
        }
    }
}
