class Twitter {
    Map<Integer, Set<Integer>> userIdFollowerMap;
    Map<Integer, Integer> tweetUserIdMap;
    List<Integer> tweets;

    public Twitter() {
        userIdFollowerMap = new HashMap<>();
        tweetUserIdMap = new HashMap<>();
        tweets = new LinkedList<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweets.add(tweetId);
        tweetUserIdMap.put(tweetId, userId);
    }

    public List<Integer> getNewsFeed(int userId) {
        int count = 0;
        List<Integer> newsFeed = new ArrayList<>();
        Set<Integer> follows = userIdFollowerMap.get(userId);
        if (follows == null || follows.isEmpty()) {
            follows = new HashSet<>();
        }
        follows.add(userId);
        for (int i = tweets.size() - 1; i >= 0; i--) {
            int tweetId = tweets.get(i);
            int user = tweetUserIdMap.get(tweetId);
            if (follows.contains(user)) {
                newsFeed.add(tweetId);
                count++;
                if (count == 10) {
                    break;
                }
            }
        }
        return newsFeed;
    }

    public void follow(int followerId, int followeeId) {
        if(userIdFollowerMap.get(followerId) == null){
            userIdFollowerMap.put(followerId, new HashSet<>());
        }
        userIdFollowerMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (userIdFollowerMap.containsKey(followerId)) {
            userIdFollowerMap.get(followerId).remove(followeeId);
        }
    }
}
