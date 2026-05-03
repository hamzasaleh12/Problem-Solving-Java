class Solution {
    public void sortColors(int[] nums) {
        quickSort(nums);
    }
    private void quickSort(int[] nums){
        recQuickSort(nums , 0 , nums.length - 1);
    }
    private void recQuickSort(int[] nums , int low , int high){
        if(low >= high) return;

        int mid = partition(nums , low , high);
        recQuickSort(nums , low , mid - 1);
        recQuickSort(nums , mid + 1 , high);
    }
    private int partition(int[] nums , int start , int high){
        int i = start - 1;
        int pivot = nums[high];
        for(int j = start ; j < high ; j++){
            if(nums[j] < pivot){
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        i++;
        int temp = nums[i];
        nums[i] = nums[high];
        nums[high] = temp;

        return i;
    }
}