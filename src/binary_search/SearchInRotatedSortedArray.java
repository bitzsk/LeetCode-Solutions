package binary_search;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array
 * 问题：
 * 思路：
 */
public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == nums[right]) {
                // if mid equals to end, that means it's fine to remove end
                // the smallest element won't be removed
                right--;
            } else if (nums[mid] < nums[right]) {
                right = mid;
                // of course you can merge == & <
            } else {
                left = mid;
                // or start = mid + 1
            }
        }

        if (nums[left] <= nums[right]) {
            return nums[left];
        }
        return nums[right];
    }

    public int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[left] < nums[mid]) {
                // 移动右指针
                if (nums[left] <= target && nums[mid] >= target) right = mid;
                else left = mid;
            } else if (nums[mid] < nums[right]) {
                // 移动左指针
                if (nums[right] >= target && nums[mid] <= target) left = mid;
                else right = mid;
            }
        }

        // 此时left和right相邻，只要判断是nums[left]还是nums[right]等于target就可以了
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        return -1;
    }

    // https://blog.csdn.net/linhuanmars/article/details/20525681
    public int search3(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            // nums[mid]在较大的那部分
            if (nums[mid] > nums[right]) {
                // target夹在nums[left]和nums[mid]之间
                if (target >= nums[left] && target < nums[mid])
                    right = mid;
                else
                    left = mid;
            } else {    // nums[mid]在较小的那部分
                // target夹在nums[mid]和nums[right]之间
                if (target > nums[mid] && target <= nums[right])
                    left = mid;
                else
                    right = mid;
            }
        }
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();
        System.out.println(obj.search2(new int[]{4, 5, 6, 7, 0, 1, 2}, 5));
        System.out.println(obj.search2(new int[]{5, 1, 3}, 0));
        System.out.println(obj.search3(new int[]{5, 1, 3}, 5));
    }
}
// 参考：http://www.jiuzhang.com/solution/find-minimum-in-rotated-sorted-array-ii/