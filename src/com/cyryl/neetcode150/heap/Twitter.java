package com.cyryl.neetcode150.heap;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/design-twitter/
 */

public class Twitter {

    private final Map<Integer, List<Tweet>> userTweets;
    private final Map<Integer, PriorityQueue<Tweet>> userFeed;
    private final Map<Integer, Set<Integer>> userFollowers;

    private static long time;

    public Twitter() {
        time = 1;
        userFeed = new HashMap<>();
        userFollowers = new HashMap<>();
        userTweets = new HashMap<>();
    }

    private Tweet createNewTweet(int tweetId, int creator) {
        Tweet tweet = new Tweet(time, tweetId, creator);
        time++;
        return tweet;
    }

    private void notifyFollowers(int userId, Tweet tweet) {
        Set<Integer> followers = userFollowers.getOrDefault(userId, new HashSet<>());
        followers.forEach(follower -> userFeed.get(follower).offer(tweet));
    }

    public void postTweet(int userId, int tweetId) {
        setUpIfNewUser(userId);
        Tweet newTweet = createNewTweet(tweetId, userId);
        userTweets.get(userId).add(newTweet);
        notifyFollowers(userId, newTweet);
    }

    public void setUpIfNewUser(int userId) {
        userFollowers.putIfAbsent(userId, new HashSet<>());
        userFollowers.get(userId).add(userId);

        userFeed.putIfAbsent(userId, new PriorityQueue<>());

        userTweets.putIfAbsent(userId, new ArrayList<>());
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> feed = userFeed.getOrDefault(userId, new PriorityQueue<>());
        return feed.stream().sorted().limit(10).map(tweet -> tweet.tweetId).collect(Collectors.toList());
    }

    public void follow(int followerId, int followeeId) {
        setUpIfNewUser(followeeId);
        setUpIfNewUser(followerId);
        if(userFollowers.get(followeeId).contains(followerId)){
            return;
        }
        userFollowers.get(followeeId).add(followerId);
        List<Tweet> followeeTweets = userTweets.get(followeeId);
        userFeed.get(followerId).addAll(followeeTweets);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followeeId == followerId) {
            return;
        }
        setUpIfNewUser(followeeId);
        setUpIfNewUser(followerId);

        userFollowers.get(followeeId).remove(followerId);
        PriorityQueue<Tweet> refreshedFeed = userFeed.get(followerId)
                .stream()
                .filter(tweet -> tweet.creatorId != followeeId)
                .collect(Collectors.toCollection(PriorityQueue::new));
        userFeed.put(followerId, refreshedFeed);
    }

    private class Tweet implements Comparable<Tweet> {
        long time;
        int tweetId;
        int creatorId;

        public Tweet(long time, int tweetId, int creatorId) {
            this.time = time;
            this.tweetId = tweetId;
            this.creatorId = creatorId;
        }

        @Override
        public int compareTo(Tweet other) {
            return Long.compare(other.time, this.time); // reversed order
        }
    }
}
