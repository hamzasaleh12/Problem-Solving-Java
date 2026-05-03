import java.util.Random;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int target = n - k;
        int start = 0;
        int end = n - 1;
        Random rand = new Random();

        while (start <= end) {
            int pivotIndex = rand.nextInt(end - start + 1) + start;
            swap(nums, pivotIndex, end);

            int mid = partition(nums, start, end);

            if (mid == target) {
                return nums[mid];
            } else if (mid < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, end);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}