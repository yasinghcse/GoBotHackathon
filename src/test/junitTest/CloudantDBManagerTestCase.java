package junitTest;

import junit.framework.TestCase;
import newwindsorite.db.UserProfileAlreadyExistentException;
import newwindsorite.db.UserProfileNotFoundException;
import wasdev.windsor.db.CloudantDBManager;
import wasdev.windsor.resources.UserProfile;

public class CloudantDBManagerTestCase  extends TestCase {

	/**
	 *  Test the Singleton Pattern GetInstance
	 */
	public void testGetInstance() {
		CloudantDBManager cloudantManager = CloudantDBManager.getInstance();
		assertNotNull(cloudantManager);
		assertEquals(cloudantManager, CloudantDBManager.getInstance());
	}
	
	/**
	 *  Tests the Insertion Method
	 */
	public void testInsertSearchUserProfile() {
		CloudantDBManager cloudantManager = null;
		try {
			cloudantManager = CloudantDBManager.getInstance();
			
			UserProfile userProfile = new UserProfile("UserNameTest");
			userProfile.setName("Test Name");
			userProfile.setEmail("Testemail@gmail.com");
			userProfile.setAddress("NewFakeAddress");
			userProfile.setZipCOde("FakeZipCode");
			userProfile.setPasswordHash("FakeHashPassword");
			cloudantManager.insertUserProfile(userProfile);
			
			UserProfile searchedUserProfile = cloudantManager.searchUserProfileByUserName(userProfile.getUserName());
			assertEquals(userProfile.getName(), searchedUserProfile.getName());
			assertEquals(userProfile.getUserName(), searchedUserProfile.getUserName());
			assertEquals(userProfile.getEmail(), searchedUserProfile.getEmail());
			assertEquals(userProfile.getAddress(), searchedUserProfile.getAddress());
			assertEquals(userProfile.getZipCOde(), searchedUserProfile.getZipCOde());
			
			cloudantManager.insertUserProfile(userProfile);
			fail("Fails because it should no accept to insert another user with already existent user name.");
		} catch (UserProfileAlreadyExistentException e) {
			
		} catch (UserProfileNotFoundException ex) {
			fail("Fails because it should exist!");
		}
		
		try {
			UserProfile searchedUserProfile2 = cloudantManager.searchUserProfileByUserName("NeverRegistered");
			fail("Fails because it should no accept to insert another user with already existent user name.");
		} catch (UserProfileNotFoundException ex) {
			
		}
	}	
	
	
	/**
	 *  Tests the Insertion Method
	 */
	public void testRemoveUserProfile() {
		CloudantDBManager cloudantManager = CloudantDBManager.getInstance();
		try {
			UserProfile userProfile = new UserProfile("UserNameTest");
			userProfile.setName("Test Name");
			userProfile.setEmail("Testemail@gmail.com");
			userProfile.setAddress("NewFakeAddress");
			userProfile.setZipCOde("FakeZipCode");
			userProfile.setPasswordHash("FakeHashPassword");
			cloudantManager.insertUserProfile(userProfile);
			cloudantManager.removeUserProfileByUserName(userProfile.getUserName());
			cloudantManager.removeUserProfileByUserName(userProfile.getUserName());
			fail("Fails because it should throw an exception that is not not exist once it was removed.");
		} catch (UserProfileAlreadyExistentException e) {
			fail("Fails because it should let the UserProfile to be inserted.");
		} catch (UserProfileNotFoundException ex) {
		}
	}		
	
	/**
	 *  Tests the Insertion Method
	 */
	public void testUpdateUserProfile() {
		CloudantDBManager cloudantManager = CloudantDBManager.getInstance();
		try {
			UserProfile userProfile = new UserProfile("UserNameTest2");
			userProfile.setName("Test Name");
			userProfile.setEmail("Testemail@gmail.com");
			userProfile.setAddress("NewFakeAddress");
			userProfile.setZipCOde("FakeZipCode");
			userProfile.setPasswordHash("FakeHashPassword");
			cloudantManager.insertUserProfile(userProfile);
			
			userProfile.setEmail("NewEmailAfterChange");
			cloudantManager.updateUserProfileByUserName(userProfile);
			
			UserProfile newUser = cloudantManager.searchUserProfileByUserName(userProfile.getUserName());
			assertEquals(userProfile.getEmail(), newUser.getEmail());
			assertEquals(userProfile.getUserName(), newUser.getUserName());
			assertEquals(userProfile.getAddress(), newUser.getAddress());
			assertEquals(userProfile.getZipCOde(), newUser.getZipCOde());
			
		} catch (UserProfileAlreadyExistentException e) {
			fail("Fails because it should not exist!");
		} catch (UserProfileNotFoundException ex) {
			fail("Fails because it should exist!");
		}
	}	
	
	
}

