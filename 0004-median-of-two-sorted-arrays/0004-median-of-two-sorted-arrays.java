class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = (nums1 != null) ? nums1.length : 0;
        int l2 = (nums2 != null) ? nums2.length : 0;
        if(l1 + l2 == 0) return 0;
        if(l1 + l2 == 1) return (l1 == 1) ? nums1[0] : nums2[0];


        int[] nums3 = new int[l1 + l2];
        merge(nums1 , nums2 , nums3);
        
        int newLength = l1 + l2;
        if(newLength % 2 != 0){ // odd
            return nums3[newLength / 2];
        } else{ // even
            System.out.println(nums3[(newLength / 2) - 1] + " & " + nums3[(newLength / 2)]);
            return (nums3[(newLength / 2) - 1] + nums3[(newLength / 2)]) / 2.0;
        }
    }
    private void merge(int[] nums1 , int[] nums2 , int[] nums3){
        int i = 0 , j = 0 , k = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] <= nums2[j]){
                nums3[k++] = nums1[i++];
            } else{
                nums3[k++] = nums2[j++];
            }
        }
        while(i < nums1.length) nums3[k++] = nums1[i++];
        while(j < nums2.length) nums3[k++] = nums2[j++];
    }
}