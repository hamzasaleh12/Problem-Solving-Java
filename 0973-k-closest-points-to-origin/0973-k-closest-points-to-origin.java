class Solution {
    class Data{
        int x;
        int y;
        int dis;
        public Data(int x ,int y , int dis){
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Data> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.dis , a.dis));

        for(int i = 0 ; i < points.length ; i++){
            int x = points[i][0] , y = points[i][1] , dis = x * x + y * y;
            
            pq.add(new Data(x , y , dis));
            if(pq.size() > k){
                pq.poll();
            }
        }

        int[][] res = new int[k][2];
        for(int i = 0 ; i < k ; i++){
            Data curr = pq.poll();
            res[i][0] = curr.x;
            res[i][1] = curr.y;
        }

        return res;
    }
}