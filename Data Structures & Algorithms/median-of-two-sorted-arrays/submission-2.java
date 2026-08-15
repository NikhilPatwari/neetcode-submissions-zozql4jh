class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        if ((n + m) % 2 == 0) {
            int targetLenght1 = (n + m) / 2, targetLenght2 = targetLenght1 + 1;
            Double t1 = findMedian(nums1, nums2, targetLenght1, false);
            if (t1 == null) {
                t1 = findMedian(nums2, nums1, targetLenght1, true);
            }

            Double t2 = findMedian(nums1, nums2, targetLenght2, false);
            if (t2 == null) {
                t2 = findMedian(nums2, nums1, targetLenght2, true);
            }
            return (t1 + t2) / 2;

        } else {
            int targetLength = (n + m) / 2 + 1;
            Double t = findMedian(nums1, nums2, targetLength, false);
            if (t != null) {
                return t;
            }
            return findMedian(nums2, nums1, targetLength, true);
        }
    }
    public int findNumsLessThanTarget(int[] nums, int target, boolean includeEqualValue) {
        int l = 0;
        int r = nums.length - 1;
        int res = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (includeEqualValue) {
                if (nums[m] <= target) {
                    res = m;
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                if (nums[m] < target) {
                    res = m;
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return res + 1;
    }
    public Double findMedian(
        int[] nums1, int[] nums2, int targetLength, boolean includeEqualValue) {
        int l = 0, r = nums1.length - 1, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            int posInOtherArray = findNumsLessThanTarget(nums2, nums1[m], includeEqualValue);
            if (m + 1 + posInOtherArray == targetLength) {
                return nums1[m] * 1.0;
            } else if (m+1 + posInOtherArray > targetLength) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return null;
    }
}
