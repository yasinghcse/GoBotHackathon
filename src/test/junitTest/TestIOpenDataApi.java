package junitTest;

import static org.junit.Assert.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Test;

import wasdev.windsor.resources.UserProfile;
import wasdev.windsor.resources.WindsorOpenDataApi;


public class TestIOpenDataApi {

	static WindsorOpenDataApi obj = new WindsorOpenDataApi();
	
	@Test
	public void testNull() {
		assertNotNull(obj);
	}
	
	@Test
	public void testGarbageCollection() {
		String arr[] =obj.getGarabageCollDetails();
		assertNotNull(arr);
	}
	
	@Test
	public void testConstructionDetails() {
		String arr[] =obj.getConstructionDetails();
		assertNotNull(arr);
	}
	
	@Test
	public void testEventDetails() {
		String arr[] =obj.getEventDetails();
		assertNotNull(arr);
	}

	@Test
	public void testAllRecommendations() {
		UserProfile user = new UserProfile("yadi");
		JSONObject arr =obj.getAllRecommendations(user);
		assertNotNull(arr);
	}
	
	@Test
	public void testAllRecommendationsTraffic() {
		UserProfile user = new UserProfile("yadi");
		user.setRecomentation1("TrafficCharacter");
		System.out.println("user1" +user.getRecomentation1());
		JSONObject arr =obj.getAllRecommendations(user);
		assertNotNull(arr.get("TrafficCharacter"));
	}
	
	@Test
	public void testAllRecommendationsTraffic2() {
		UserProfile user = new UserProfile("yadi");
		user.setRecomentation1("TrafficCharacter");
		System.out.println("user1" +user.getRecomentation1());
		JSONObject arr =obj.getAllRecommendations(user);
		assertNull(arr.get("SocialCharacter"));
	}
	
	@Test
	public void testAllRecommendationsTraffic3() {
		UserProfile user = new UserProfile("yadi");
		user.setRecomentation1("TrafficCharacter");
		System.out.println("user1" +user.getRecomentation1());
		JSONObject arr =obj.getAllRecommendations(user);
		assertNull(arr.get("forgot things"));
	}
	
	@Test
	public void testAllRecommendationsSocial1() {
		UserProfile user = new UserProfile("yadi");
		user.setRecomentation1("SocialCharacter");
		System.out.println("user1" +user.getRecomentation1());
		JSONObject arr =obj.getAllRecommendations(user);
		assertNull(arr.get("TrafficCharacter"));
	}
	
	@Test
	public void testAllRecommendationsSocial2() {
		UserProfile user = new UserProfile("yadi");
		user.setRecomentation1("SocialCharacter");
		System.out.println("user1" +user.getRecomentation1());
		JSONObject arr =obj.getAllRecommendations(user);
		assertNotNull(arr.get("SocialCharacter"));
	}
	
	@Test
	public void testAllRecommendationsSocial3() {
		UserProfile user = new UserProfile("yadi");
		user.setRecomentation1("SocialCharacter");
		System.out.println("user1" +user.getRecomentation1());
		JSONObject arr =obj.getAllRecommendations(user);
		assertNull(arr.get("forgot things"));
	}
	
	@Test
	public void testAllRecommendationsForgot1() {
		UserProfile user = new UserProfile("yadi");
		user.setRecomentation1("forgot things");
		System.out.println("user1" +user.getRecomentation1());
		JSONObject arr =obj.getAllRecommendations(user);
		assertNull(arr.get("TrafficCharacter"));
	}
	
	@Test
	public void testAllRecommendationsForgot2() {
		UserProfile user = new UserProfile("yadi");
		user.setRecomentation1("forgot things");
		System.out.println("user1" +user.getRecomentation1());
		JSONObject arr =obj.getAllRecommendations(user);
		assertNull(arr.get("SocialCharacter"));
	}
	
	@Test
	public void testAllRecommendationsForgot3() {
		UserProfile user = new UserProfile("yadi");
		user.setRecomentation1("forgot things");
		System.out.println("user1" +user.getRecomentation1());
		JSONObject arr =obj.getAllRecommendations(user);
		assertNotNull(arr.get("forgot things"));
	}
	
	@Test
	public void testAllRecommendationsfor2() {
		UserProfile user = new UserProfile("yadi");
		user.setRecomentation1("forgot things");
		user.setRecomentation2("TrafficCharacter");
		System.out.println("user1" +user.getRecomentation1());
		JSONObject arr =obj.getAllRecommendations(user);
		assertNotNull(arr.get("TrafficCharacter"));
		assertNotNull(arr.get("forgot things"));
	}
	
	@Test
	public void testAllRecommendationsFor2Negative() {
		UserProfile user = new UserProfile("yadi");
		user.setRecomentation1("forgot things");
		user.setRecomentation2("TrafficCharacter");
		System.out.println("user1" +user.getRecomentation1());
		JSONObject arr =obj.getAllRecommendations(user);
		assertNull(arr.get("SocialCharacter"));
	}
	
	@Test
	public void testAllRecommendationsfor3() {
		UserProfile user = new UserProfile("yadi");
		user.setRecomentation1("forgot things");
		user.setRecomentation2("TrafficCharacter");
		user.setRecomentation3("SocialCharacter");
		System.out.println("user1" +user.getRecomentation1());
		JSONObject arr =obj.getAllRecommendations(user);
		assertNotNull(arr.get("SocialCharacter"));
		assertNotNull(arr.get("TrafficCharacter"));
		assertNotNull(arr.get("forgot things"));
	}
	
}

