class Twitter {

    HashMap<Integer, User> userByUserId;
    HashMap<Integer, Set<Integer>> followeeIdsByUserId;
    int timestamp = 0;

    class Tweet {
        int id;
        int timestamp;
        Tweet next;

        public Tweet(int id, int timestamp) {
            this.id = id;
            this.timestamp = timestamp;
            this.next = null;
        }
    }

    class User {
        int id;
        // trick -> user needs to setup the headTweet to indicate latest tweet for this user
        Tweet headTweet;

        public User(int id, Tweet tweet) {
            this.id = id;
            this.headTweet = tweet;
        }

        public void addTweet(Tweet tweet) {
            Tweet prevHead = this.headTweet;
            tweet.next = prevHead;
            this.headTweet = tweet;
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {
        userByUserId = new HashMap();
        followeeIdsByUserId = new HashMap();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId, this.timestamp++);
        User user = null;
        if (userByUserId.get(userId) == null) {
            user = new User(userId, tweet);
            // self subscribed
            follow(userId, userId);
        } else {
            user = userByUserId.get(userId);
            user.addTweet(tweet);
        }
        userByUserId.put(userId, user);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.timestamp - a.timestamp);

        for (int followeeId : followeeIdsByUserId.getOrDefault(userId, new HashSet<Integer>())) {
            User followee = userByUserId.get(followeeId);
            if (followee != null) pq.offer(followee.headTweet);
        }

         // trick -> it seems there is k-way merges to implement this to improve speed here to achieve nlog(n)
        //          https://leetcode.com/problems/design-twitter/discuss/82825/Java-OO-Design-with-most-efficient-function-getNewsFeed
        //          it requires self-follows
        //          user1 -> tweet1 -> tweet2 -> tweet3
        //          user2 -> tweet4 -> tweet5 -> tweet6
        //          user3 -> tweet7 -> tweet8 -> tweet9
        //          if pick up 4, will use k-way merges to pick up the best one achiving by nlog(n)
        List<Integer> list = new ArrayList();
        int n = 0;
        while (n < 10 && !pq.isEmpty()) {
            Tweet tweet = pq.poll();
            list.add(tweet.id);
            if (tweet.next != null) pq.add(tweet.next);
            n++;
        }
        return list;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        Set<Integer> set = followeeIdsByUserId.getOrDefault(followerId, new HashSet());
        set.add(followeeId);
        followeeIdsByUserId.put(followerId, set);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        // trick -> cannot unfollow user itself
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
