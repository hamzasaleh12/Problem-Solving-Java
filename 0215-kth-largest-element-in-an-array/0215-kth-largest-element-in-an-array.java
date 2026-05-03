class Solution {
    public int findKthLargest(int[] nums, int k) {
        return recQuickSelect(nums , 0 , nums.length - 1 , k);
    }
    private int recQuickSelect(int[] nums , int start , int end ,int k){
        int mid =  partition(nums , start , end);
        int tar = nums.length - k;

        if(mid == tar) return nums[mid];
        else if(mid < tar) return recQuickSelect(nums , mid + 1 , end , k);
        else return recQuickSelect(nums , start , mid - 1 , k);
    }
    private int partition(int[] nums , int start , int end){
        int i = start - 1;
        int pivot = nums[end];

        for(int j = start ; j < end ; j++){
            if(nums[j] < pivot){
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        i++;
        int temp = nums[i];
        nums[i] = nums[end];
        nums[end] = temp;
        return i;
    }
}