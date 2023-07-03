public class Tweet {
    // instance attributes
    int tweet_id;
    int like_count;
    String text;
    String username;
    boolean is_active = true;

    // class constructor
    public Tweet(){

    }

    // second constructor
    public Tweet(int id, String text, String username, int like_count){
        tweet_id = id;
        this.text = text;
        this.username = username;
        this.like_count = like_count;
    }

    /*
    * @return void;
     */
    public void print_data(){
        System.out.println("tweet id: " + tweet_id);
        System.out.println("by: " + username);
        System.out.println("tweet: " + text);
        System.out.println(like_count + " likes\n");
    }



}
