import java.util.*;

/**
 * Description: leetcode
 * Created by : Tianqi Cui
 * Create Date: 2021/3/3 19:50
 */
import java.util.*;

/**
 * Description: leetcode
 * Created by : Tianqi Cui
 * Create Date: 2021/3/3 19:50
 */
public   class Twitter {
    private static int timestamp = 0;

    private Map<Integer,User> userMap = new HashMap<>();
    /** Initialize your data structure here. */
    public Twitter() {

    }

    class Tweet{
        int tweetId;
        int time;
        Tweet next;

        // 需要传入推文内容（id）和发文时间
        public Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
            this.next = null;
        }
    }

    class User{
        int id;
        Set<Integer> followed;
        Tweet head;

        public User(int id){
            this.id = id;
            this.followed = new HashSet<>();
            this.head = null;
            follow(id);
        }

        public void follow(int id){
            followed.add(id);
        }

        public void unfollow(int id){
            if(id!=this.id){
                followed.remove(id);
            }
        }

        public void post(int tweetId){
            Tweet tweet =  new Tweet(tweetId,timestamp);
            timestamp++;
            tweet.next = head;
            head = tweet;
        }
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId)){
            User user = new User(userId);
            userMap.put(userId,user);
        }
        User u = userMap.get(userId);
        u.post(tweetId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if(!userMap.containsKey(userId)){
            return res;
        }

        User user =  userMap.get(userId);
        PriorityQueue<Tweet> queue = new PriorityQueue<>((a,b)->b.time-a.time);
        Set<Integer> followd =   user.followed;
        for(Integer uid :followd){
            User u = userMap.get(uid);
            Tweet tw =  u.head;
            if(tw == null) continue;
            queue.add(tw);
        }

        while(!queue.isEmpty()){
            if(res.size() == 10)  break;
            Tweet tw = queue.poll();
            res.add(tw.tweetId);
            Tweet next =  tw.next;
            if(next!=null){
                queue.add(next);
            }
        }

        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)){
            User u = new User(followerId);
            userMap.put(followerId,u);
        }


        if(!userMap.containsKey(followeeId)){
            User u = new User(followeeId);
            userMap.put(followeeId,u);
        }

        userMap.get(followerId).follow(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)){
            User u = new User(followerId);
            userMap.put(followerId,u);
        }
        userMap.get(followerId).unfollow(followeeId);
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

