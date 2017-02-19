package hackathon.gobot.resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterApi {
	
	public void updateTwitterStatus(String text){
		ConfigurationBuilder cf = new ConfigurationBuilder();
		cf.setDebugEnabled(true)
		.setOAuthConsumerKey("Your Key here")
		.setOAuthConsumerSecret("Your Key here")
		.setOAuthAccessToken("Your Key here")
		.setOAuthAccessTokenSecret("Your Key here");
		
		TwitterFactory tf = new TwitterFactory(cf.build());
		twitter4j.Twitter twitter = tf.getInstance();
		try{
			System.out.println("Updating Tweet");
			Status status = twitter.updateStatus(text);
			System.out.println("Twitter status Info :" + status);
		}
		catch(Exception e){
			System.out.println(e);
		}	
	}

	public static void main(String[] args) throws IOException, TwitterException {
			TwitterApi t = new TwitterApi();
			t.updateTwitterStatus("Please Ignore , This is a bot status update");
	}


}
