class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = (nums1 != null) ? nums1.length : 0;
        int l2 = (nums2 != null) ? nums2.length : 0;
        int totalLength = l1 + l2;

        int prev = 0;
        int curr = 0;

        int i = 0;
        int j = 0;
        for(int count = 0 ; count <= totalLength / 2 ; count++){
            prev = curr;
            if (i < l1 && j < l2) {
                if(nums1[i] <= nums2[j]){
                    curr = nums1[i++];
                } else{
                    curr = nums2[j++];
                }
            } else{
                if(i < l1){
                    curr = nums1[i++];
                } else {
                    curr = nums2[j++];
                }
            }
        }
        return (totalLength % 2 == 0) ? (prev + curr) / 2.0 : curr;
    }
}