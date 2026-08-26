class Tweet implements Comparable<Tweet>{
    int time;
    int tweetId;
    Tweet(int time,int tweetId){
        this.time=time;
        this.tweetId=tweetId;
    }
    public int compareTo(Tweet t){
        return t.time-this.time;
    }
}
class User{
    int userId;
    HashSet<Integer> followers;
    List<Tweet> tweets;
    User( int userId){
        this.userId=userId;
        followers=new HashSet<>();
        followers.add(userId);   // add self to follower
        tweets=new LinkedList<>();
    }
    public void addTweet(Tweet t){
        tweets.add(0,t);
    }
    public void addFollower(int followeeId){
        followers.add(followeeId);
    }
    public void removeFollower(int followeeId){
        followers.remove(followeeId);
    }
}
class Twitter {
    HashMap<Integer,User> userMap;
    int timecount;
    public Twitter() {
        userMap=new HashMap<>();
        timecount=0;
    }
    
    public void postTweet(int userId, int tweetId) {
        timecount++;
        if(!userMap.containsKey(userId)) userMap.put(userId,new User(userId));
        User user=userMap.get(userId);
        user.addTweet(new Tweet(timecount,tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if(!userMap.containsKey(userId)) return new ArrayList<>();

        PriorityQueue<Tweet> pq=new PriorityQueue<>();
        User user=userMap.get(userId);

        for(int followerId:user.followers){
            int count=0;
            for(Tweet t:userMap.get(followerId).tweets){
                pq.offer(t);
                count++;
                if(count>10) break;
            }
        }

        List<Integer> res=new ArrayList<>();
        int index=0;
        while(!pq.isEmpty() && index<10){
            Tweet t=pq.remove();
            res.add(t.tweetId);
            index++;
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)) userMap.put(followerId,new User(followerId));
        if(!userMap.containsKey(followeeId)) userMap.put(followeeId,new User(followeeId));
        
        User user=userMap.get(followerId);
        user.addFollower(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) || !userMap.containsKey(followeeId)){
            return;
        }
        
        User user=userMap.get(followerId);
        user.removeFollower(followeeId);
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