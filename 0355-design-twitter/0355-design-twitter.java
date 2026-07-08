class Twitter {
    // userId -> [tweets]
    // userId -> [fols]
    Map<Integer,List<int[]>> tweets; // id -> [ [id,time] , [...] , ...]
    Map<Integer,Set<Integer>> fols; // id -> [ [] , [] ]
    private int timestamp = 0;

    public Twitter() {
        tweets = new HashMap<>();
        fols = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        follow(userId , userId); // follow himself
        tweets.computeIfAbsent(userId , k -> new ArrayList<>()).add(new int[]{tweetId , timestamp++});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if(fols.get(userId) == null) return new ArrayList<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[1] , a[1]));
        Set<Integer> followers = fols.get(userId);

        for(int f : followers){ // keys
            if(tweets.get(f) == null) continue;

            List<int[]> tweetsForFriend = tweets.get(f);

            int count = 0;
            for(int i = tweetsForFriend.size() - 1 ; i >= 0 && count++ < 10 ; i--){
                pq.add(tweetsForFriend.get(i));
            }
        }

        int count = 0;
        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty() && count++ < 10){
            int[] tweetAndtime = pq.poll();
            res.add(tweetAndtime[0]);
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        fols.computeIfAbsent(followerId , k -> new HashSet<>()).add(followeeId); // o(1)
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(fols.get(followerId) == null) return;
        fols.get(followerId).remove(followeeId); // o(1)
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