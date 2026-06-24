class Solution {
    public void sortColors(int[] nums) {
        mergeSort(nums , nums.length);
    }
    private void mergeSort(int[] nums , int n){
        if(n <= 1) return;
        
        int mid = n / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[n - mid];

        for(int i = 0 ; i < n ; i++){
            if(i < mid){
                leftArr[i] = nums[i];
            } else{
                rightArr[i - mid] = nums[i];
            }
        }

        mergeSort(leftArr , leftArr.length);
        mergeSort(rightArr , rightArr.length);
        merge(leftArr , rightArr , nums);
    }
    private void merge(int[] leftArr , int[] rightArr , int[] arr){
        int l = 0 , r = 0 , i = 0;
        while(l < leftArr.length && r < rightArr.length){
            if(leftArr[l] < rightArr[r]){
                arr[i++] = leftArr[l++];
            }   else{
                arr[i++] = rightArr[r++];
            }
        }
        while(l < leftArr.length) arr[i++] = leftArr[l++];
        while(r < rightArr.length) arr[i++] = rightArr[r++];
    }
}