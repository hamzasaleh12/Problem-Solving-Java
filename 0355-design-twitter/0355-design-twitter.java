class Twitter {
    class Tweet{
        int id;
        int count;
        Tweet next;
        public Tweet(int id , int count){
            this.id = id;
            this.count = count;
            this.next = null;
        }
    }

    Map<Integer , Set<Integer>> flrs;

    static int timestamp = 0;
    Map<Integer,Tweet> map;

    public Twitter() {
        flrs = new HashMap<>();
        map = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        follow(userId , userId);

        Tweet newTweet = new Tweet(tweetId , timestamp++);
        newTweet.next = map.get(userId);

        map.put(userId , newTweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();

        PriorityQueue<Tweet> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.count , a.count));
        Set<Integer> flsId =  flrs.get(userId);

        if(flsId != null){
        for(int flId : flsId){
            Tweet head = map.get(flId);
            if(head != null){
                pq.add(head);
            }
        }
        }

        int n = 0;
        while(!pq.isEmpty() && n < 10){
            Tweet head = pq.poll();
            n++;
            res.add(head.id);

            if(head.next != null){
                pq.add(head.next);
            }
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        flrs.computeIfAbsent(followerId , k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        Set<Integer> set = flrs.get(followerId);

        if(set != null){
            set.remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */