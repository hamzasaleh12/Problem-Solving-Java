class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2 == null || nums2.length == 0) return;

        int i = m - 1 , j = n - 1 , k = nums1.length - 1;
        // [1,2,-1,3,5,6] , [2,5,6]
        while(j >= 0 && i >= 0){
            if(nums1[i] >= nums2[j]){
                nums1[k--] = nums1[i--];
                nums1[i + 1] = -1;
            } else{
                nums1[k--] = nums2[j--];
            }
        }
        
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}