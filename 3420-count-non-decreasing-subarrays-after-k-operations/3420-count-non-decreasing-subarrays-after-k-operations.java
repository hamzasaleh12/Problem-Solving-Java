import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        long ops = 0;
        int r = n - 1;

        // Each entry stores: {maxValueInSegment, countOfElementsInSegment}
        Deque<int[]> deque = new ArrayDeque<>();

        for (int l = n - 1; l >= 0; l--) {
            int count = 1;
            // Merge all segments to the right whose prefix max is <= nums[l]
            while (!deque.isEmpty() && deque.peekFirst()[0] <= nums[l]) {
                int[] front = deque.pollFirst();
                ops += (long) (nums[l] - front[0]) * front[1];
                count += front[1];
            }
            deque.offerFirst(new int[]{nums[l], count});

            // Shrink window from the right if required operations exceed k
            while (ops > k) {
                int[] back = deque.peekLast();
                ops -= (long) (back[0] - nums[r]);
                back[1]--;
                if (back[1] == 0) {
                    deque.pollLast();
                }
                r--;
            }

            // All subarrays starting at l and ending in [l..r] are valid
            ans += (r - l + 1);
        }

        return ans;
    }
}