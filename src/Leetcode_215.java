public class Leetcode_215 {
    /*
    215. Kth Largest Element in an Array  Medium

    Find the kth largest element in an unsorted array.
    Note that it is the kth largest element in the
    sorted order, not the kth distinct element.

     */
    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static int findMid(int[] nums, int left, int right, int mid) {
        if (nums[left] > nums[mid]) {
            swap(nums, left, mid);
        }
        if (nums[mid] > nums[right]) {
            swap(nums, mid, right);
        }
        if (nums[left] > nums[mid]) {
            swap(nums, left, mid);
        }
        return nums[mid];
    }
    private static int position(int[] nums, int left, int right) {
        int i = left;
        for (int j = left; j < right; j++) {
            if (nums[j] < nums[right]) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, right);
        return i;
    }
    public static int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        int mid = 0;
        k = right - k + 1;
        while(true) {
            mid = (left + right) / 2;
            int midValue = findMid(nums, left, right, mid);
            swap(nums, mid, right);
            int p = position(nums, left, right);
            if (k == p) {
                return nums[k];
            }
            if (k > p) {
                left = p + 1;
            }
            else {
                right = p - 1;
            }
        }


    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(nums, 4));
    }

}
