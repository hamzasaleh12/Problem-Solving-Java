class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums);
        return nums;
    }
    private void mergeSort(int[] arr) {
        if(arr.length == 1) return;

        int mid = arr.length / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[arr.length - mid];

        for(int i = 0 ; i < arr.length ; i++){
            if(i < mid){
                leftArr[i] = arr[i];
            } else{
                rightArr[i - mid] = arr[i];
            }
        }

        mergeSort(leftArr);
        mergeSort(rightArr);
        merge(arr , leftArr , rightArr);
    }
    private void merge(int[] arr , int[] leftArr , int[] rightArr){
        int l = 0 , r = 0 , i = 0;
        while(l < leftArr.length && r < rightArr.length){
            if(leftArr[l] < rightArr[r]){
                arr[i] = leftArr[l];
                i++;
                l++;
            } else{
                arr[i] = rightArr[r];
                i++;
                r++;
            }
        }
        while(l < leftArr.length) arr[i++] = leftArr[l++];
        while(r < rightArr.length) arr[i++] = rightArr[r++];
    }
}