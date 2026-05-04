import java.util.Random;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        shuffle(nums);
        
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int pivotIndex = partition(nums, start, end);
            if (pivotIndex < target) start = pivotIndex + 1;
            else if (pivotIndex > target) end = pivotIndex - 1;
            else break;
        }
        return nums[target];
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left + 1;
        int j = right;
        
        while (i <= j) {
            while (i <= j && nums[i] < pivot) i++;
            while (i <= j && nums[j] > pivot) j--;
            if (i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        swap(nums, left, j);
        return j;
    }

    private void shuffle(int[] nums) {
        Random rand = new Random();
        for (int i = 0; i < nums.length; i++) {
            int r = rand.nextInt(nums.length);
            swap(nums, i, r);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}