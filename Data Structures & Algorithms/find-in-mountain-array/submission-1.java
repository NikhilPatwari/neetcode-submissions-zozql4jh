/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int i = findInflexionIndex(mountainArr);
        int index = search(0, i, target, mountainArr);

        if (index != -1) {
            return index;
        }
        return searchReverse(i + 1, mountainArr.length() - 1, target, mountainArr);
    }
    public int search(int l, int r, int target, MountainArray mountainArr) {
        while (l <= r) {
            int m = l + (r - l) / 2;
            int val = mountainArr.get(m);
            if (val == target) {
                return m;
            } else if (val > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
    public int searchReverse(int l, int r, int target, MountainArray mountainArr) {
        while (l <= r) {
            int m = l + (r - l) / 2;
            int val = mountainArr.get(m);
            if (val == target) {
                return m;
            } else if (val > target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    public int findInflexionIndex(MountainArray mountainArr) {
        int l = 0, r = mountainArr.length() - 1, size = r, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (m - 1 >= 0 && m + 1 <= size) {
                int g = mountainArr.get(m - 1), h = mountainArr.get(m), i = mountainArr.get(m + 1);
                if (g < h && h > i) {
                    return m;
                } else if (g < h) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }else if(m-1 <0){
                l = m+1;
            }else {
                r = m-1;
            }
        }
        return -1;
    }
}