class Twitter {

    HashMap<Integer, Set<Tweet>> tweetsByUserId;
    HashMap<Integer, Set<Integer>> followeeIdsByUserId;
    int timestamp = 0;

    class Tweet {
        int id;
        int timestamp;

        public Tweet(int id, int timestamp) {
            this.id = id;
            this.timestamp = timestamp;
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {
        tweetsByUserId = new HashMap();
        followeeIdsByUserId = new HashMap();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Set<Tweet> set = tweetsByUserId.getOrDefault(userId, new HashSet<Tweet>());
        set.add(new Tweet(tweetId, this.timestamp++));
        tweetsByUserId.put(userId, set);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        // trick -> min heap is needed
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> a.timestamp - b.timestamp);

        for (Tweet tweet : tweetsByUserId.getOrDefault(userId, new HashSet<Tweet>())) {
            pq.add(tweet);
            if (pq.size() > 10) pq.poll();
        }

        // trick -> it seems there is k-way merges to implement this to improve speed here to achieve nlog(n)
        //          https://leetcode.com/problems/design-twitter/discuss/82825/Java-OO-Design-with-most-efficient-function-getNewsFeed
        //          it requires self-follows
        //          user1 -> tweet1 -> tweet2 -> tweet3
        //          user2 -> tweet4 -> tweet5 -> tweet6
        //          user3 -> tweet7 -> tweet8 -> tweet9
        //          if pick up 4, will use k-way merges to pick up the best one achiving by nlog(n)
        for (int followeeId : followeeIdsByUserId.getOrDefault(userId, new HashSet<Integer>())) {
            Set<Tweet> set = tweetsByUserId.get(followeeId);
            for (Tweet tweet : tweetsByUserId.getOrDefault(followeeId, new HashSet<Tweet>())) {
                pq.add(tweet);
                if (pq.size() > 10) pq.poll();
            }
        }

        List<Integer> list = new ArrayList();
        while (!pq.isEmpty()) {
            Tweet tweet = pq.poll();
            list.add(tweet.id);
        }
        Collections.reverse(list);
        return list;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;

        Set<Integer> set = followeeIdsByUserId.getOrDefault(followerId, new HashSet());
        set.add(followeeId);
        followeeIdsByUserId.put(followerId, set);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;

        Set<Integer> set = followeeIdsByUserId.getOrDefault(followerId, new HashSet());
        set.remove(followeeId);
        followeeIdsByUserId.put(followerId, set);
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
