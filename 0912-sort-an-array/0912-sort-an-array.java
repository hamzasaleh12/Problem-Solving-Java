class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums , new int[nums.length] , 0 , nums.length - 1);
        return nums;
    }
    private void mergeSort(int[] nums , int[] helper , int l , int h){
        if(l >= h) return;
        int m = (l + h) >>> 1;

        mergeSort(nums , helper , l , m);
        mergeSort(nums , helper , m + 1 , h);
        merge(nums , helper , l , m , h);
    }
    private void merge(int[] nums , int[] helper , int low , int mid , int high){
        for(int i = low ; i <= high ; i++){
            helper[i] = nums[i];
        }

        int l = low;
        int r = mid + 1;
        int i = low;

        while(l <= mid && r <= high){
            if(helper[l] <= helper[r]){
                nums[i++] = helper[l++];
            } else{
                nums[i++] = helper[r++];
            }
        }

        while(l <= mid) nums[i++] = helper[l++];
    }   
}