import java.util.*;

class Solution {
    record Interval(int l, int r, int w, int idx) {}
    record Result(long sum, List<Integer> idxs) {}

    private Result[][] memo;
    private int[] nextIdxValid; 

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        memo = new Result[n][5];
        
        Interval[] arr = new Interval[n];
        for (int i = 0; i < n; i++) {
            List<Integer> interval = intervals.get(i);
            arr[i] = new Interval(interval.get(0), interval.get(1), interval.get(2), i);
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a.l(), b.l()));

        nextIdxValid = new int[n];
        for (int i = 0; i < n; i++) {
            nextIdxValid[i] = getnextValid(arr[i].r(), arr);
        }
        
        Result res = dp(0, 4, arr); // Fix: pass arr to dp
        
        int[] ans = new int[res.idxs().size()];
        for(int i = 0; i < ans.length; i++) ans[i] = res.idxs().get(i);
        return ans;
    }

    private Result dp(int idx, int count, Interval[] arr) {
        if (idx == arr.length || count == 0) return new Result(0, new ArrayList<>());

        if (memo[idx][count] != null) return memo[idx][count];

        Result skip = dp(idx + 1, count, arr);

        Result takenext = dp(nextIdxValid[idx], count - 1, arr);

        List<Integer> newList = new ArrayList<>(takenext.idxs());
        newList.add(arr[idx].idx());
        Collections.sort(newList); 
        
        Result take = new Result(arr[idx].w() + takenext.sum(), newList);

        Result best = isBetter(take, skip) ? take : skip;
        return memo[idx][count] = best; 
    }

    
    private int getnextValid(int targetEnd, Interval[] arr) {
        int left = 0, right = arr.length - 1, ans = arr.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid].l() > targetEnd) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private boolean isBetter(Result r1, Result r2) {
        if (r1.sum() != r2.sum()) return r1.sum() > r2.sum();
        
        int minLen = Math.min(r1.idxs().size(), r2.idxs().size());
        for (int i = 0; i < minLen; i++) {
            if (!r1.idxs().get(i).equals(r2.idxs().get(i))) {
                return r1.idxs().get(i) < r2.idxs().get(i);
            }
        }
        return r1.idxs().size() < r2.idxs().size();
    }
}