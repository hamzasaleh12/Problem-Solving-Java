class Solution {
    public int findDuplicate(int[] nums) {
        // 1. Base case: if it is null or less than 2 elements that means no dublicates.
        if(nums == null || nums.length <= 1) return 0;
        // 2. Begin on the first value.
        int slow = nums[0];
        int fast = nums[0];

        // 3. Treat the array as a linked list: I move slow one step and fast two steps until they meet each other in point on the circle 
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        // 4. Reset slow on the beginning becuse [ L = n.C - d ] -> l = length of line , c = length of circle , d = part of C
        slow = nums[0];

        // 5. Move them with the same speed to meet each other at the intersection point.
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        // 6. Return that point (slow or fast).
        return slow;
    }
}