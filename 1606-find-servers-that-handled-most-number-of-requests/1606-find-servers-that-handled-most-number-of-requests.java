class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
   // عداد الطلبات لكل سيرفر
        int[] count = new int[k];
        
        // PriorityQueue لتتبع السيرفرات المشغولة: [free_time, server_id]
        // مرتبة تصاعدياً حسب وقت الفراغ (earliest release time)
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        // TreeSet لتخزين السيرفرات المتاحة والبحث السريع باستخدام ceiling في O(log k)
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            available.add(i);
        }
        
        int maxRequests = 0;
        
        for (int i = 0; i < arrival.length; i++) {
            int time = arrival[i];
            int duration = load[i];
            
            // 1. تحرير السيرفرات التي انتهت من عملها قبل أو عند وقت وصول الـ request الحالي
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                available.add(busy.poll()[1]);
            }
            
            // إذا كانت كل السيرفرات مشغولة، يتم تجاهل الـ request (drop)
            if (available.isEmpty()) {
                continue;
            }
            
            // 2. البحث عن أول سيرفر متاح يبدأ من (i % k)
            int target = i % k;
            Integer server = available.ceiling(target);
            
            // في حالة الـ wrap-around: لو لم نجد سيرفر رقمه >= target، نأخذ أصغر سيرفر متاح (من البداية)
            if (server == null) {
                server = available.first();
            }
            
            // 3. حجز السيرفر وتحديث حالته
            available.remove(server);
            busy.offer(new int[]{time + duration, server});
            count[server]++;
            maxRequests = Math.max(maxRequests, count[server]);
        }
        
        // جمع السيرفرات الأكثر انشغالاً (busiest servers)
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (count[i] == maxRequests) {
                result.add(i);
            }
        }
        
        return result;
    }
}