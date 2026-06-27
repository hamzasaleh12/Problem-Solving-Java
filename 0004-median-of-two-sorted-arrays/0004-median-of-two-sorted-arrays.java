class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return findMedianSortedArrays(nums2 , nums1);

        int length1 = nums1.length;
        int length2 = nums2.length;
        int total = length1 + length2;
        int half = total / 2;

        int low = 0 , high = length1 - 1;
        while(true){
            int mid = Math.floorDiv(low + high, 2);
            int secHalf = half - mid - 2;

            int l1 = (mid >= 0) ? nums1[mid] : Integer.MIN_VALUE;
            int r1 = (mid + 1 < length1) ? nums1[mid + 1] : Integer.MAX_VALUE; 
            int l2 = (secHalf >= 0) ? nums2[secHalf] : Integer.MIN_VALUE;
            int r2 = (secHalf + 1 < length2) ? nums2[secHalf + 1] : Integer.MAX_VALUE; 

            if(r2 >= l1 && r1 >= l2){
                if((total & 1) == 1){
                    return Math.min(r1 , r2);
                }
                return (Math.min(r1 , r2) + Math.max(l1 , l2)) / 2.0;
            } else if(l1 > r2){
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }
    }
}