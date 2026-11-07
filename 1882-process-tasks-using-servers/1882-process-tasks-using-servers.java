import java.util.*;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;
        int[] ans = new int[m];

        // 1. هيب السيرفرات المتاحة (freeServers): الأولوية للـ weight ثم الـ index
        PriorityQueue<int[]> freeServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        // 2. هيب السيرفرات المشغولة (busyServers): الأولوية لأقرب وقت يفضى فيه (availableTime)
        PriorityQueue<long[]> busyServers = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        // إدخال كل السيرفرات في البداية كـ free
        for (int i = 0; i < n; i++) {
            freeServers.offer(new int[]{servers[i], i});
        }

        long time = 0;

        for (int i = 0; i < m; i++) {
            // الوقت دايماً يتقدم على الأقل لثانية وصول التاسك الحالي
            time = Math.max(time, i);

            // لو مفيش أي سيرفر متاح، بنقفز بالزمن فوراً لأول سيرفر هيخلص (Fast-forward)
            if (freeServers.isEmpty()) {
                time = busyServers.peek()[0];
            }

            // تحرير أي سيرفر انتهى من شغله حتى اللحظة time
            while (!busyServers.isEmpty() && busyServers.peek()[0] <= time) {
                long[] curr = busyServers.poll();
                int serverIdx = (int) curr[1];
                freeServers.offer(new int[]{servers[serverIdx], serverIdx});
            }

            // إسناد التاسك للسيرفر الأنسب
            int[] chosenServer = freeServers.poll();
            int serverIdx = chosenServer[1];
            ans[i] = serverIdx;

            // إدخال السيرفر في قائمة المشغولين مع وقت انتهائه
            busyServers.offer(new long[]{time + tasks[i], serverIdx});
        }

        return ans;
    }
}