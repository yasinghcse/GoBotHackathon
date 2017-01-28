package junitTest;
import junit.framework.TestCase;
import newwindsorite.db.UserProfileAlreadyExistentException;
import newwindsorite.db.UserProfileNotFoundException;
import wasdev.windsor.facade.NewWindsoriteFacade;
import wasdev.windsor.resources.UserProfile;
import wasdev.windsor.resources.WindsoriteUtil;

public class NewWindsoriteFacadeTestCase extends TestCase {

	/**
	 *  Test the Singleton Pattern GetInstance
	 */
	public void testGetInstance() {
		NewWindsoriteFacade facade = NewWindsoriteFacade.getFacade();
		assertNotNull(facade);
		assertEquals(facade, NewWindsoriteFacade.getFacade());
	}
	
	/**
	 * 
	 * 
	 */
	public void testUserLogin() {
		NewWindsoriteFacade facade = NewWindsoriteFacade.getFacade();
		try {
			UserProfile userProfile = new UserProfile("UserNameTest4");
			userProfile.setName("Test Name");
			userProfile.setEmail("Testemail@gmail.com");
			userProfile.setAddress("NewFakeAddress");
			userProfile.setZipCOde("FakeZipCode");
			userProfile.setPasswordHash(WindsoriteUtil.generateStringHash("NewPassWord"));
			facade.insertUserProfile(userProfile);
			
			UserProfile loggerUser = facade.systemLogin("UserNameTest4", "NewPassWord");
			assertNotNull(loggerUser);
			
			UserProfile loggerUser1 = facade.systemLogin("UserNameTest4", "NewPassWordMismatch");
			assertNull(loggerUser1);
		} catch (UserProfileAlreadyExistentException e) {
			fail("Fails because it should not exist!");
		} catch (UserProfileNotFoundException ex) {
			fail("Fails because it should exist!");
		}
	}	
	
	/**
	 *  Tests the Insertion Method
	 */
	public void testInsertSearchUserProfile() {
		NewWindsoriteFacade facade = NewWindsoriteFacade.getFacade();
		try {
			UserProfile userProfile = new UserProfile("UserNameTest1");
			userProfile.setName("Test Name");
			userProfile.setEmail("Testemail@gmail.com");
			userProfile.setAddress("NewFakeAddress");
			userProfile.setZipCOde("FakeZipCode");
			userProfile.setPasswordHash("FakeHashPassword");
			facade.insertUserProfile(userProfile);
			
			UserProfile searchedUserProfile = facade.searchUserProfileByUserName(userProfile.getUserName());
			assertEquals(userProfile.getName(), searchedUserProfile.getName());
			assertEquals(userProfile.getUserName(), searchedUserProfile.getUserName());
			assertEquals(userProfile.getEmail(), searchedUserProfile.getEmail());
			assertEquals(userProfile.getAddress(), searchedUserProfile.getAddress());
			assertEquals(userProfile.getZipCOde(), searchedUserProfile.getZipCOde());
			
			facade.insertUserProfile(userProfile);
			fail("Fails because it should no accept to insert another user with already existent user name.");
		} catch (UserProfileAlreadyExistentException e) {
			
		} catch (UserProfileNotFoundException ex) {
			fail("Fails because it should exist!");
		}
		
		try {
			UserProfile searchedUserProfile2 = facade.searchUserProfileByUserName("NeverRegistered");
			fail("Fails because it should no accept to insert another user with already existent user name.");
		} catch (UserProfileNotFoundException ex) {
			
		}
	}	
	
	
	/**
	 *  Tests the Insertion Method
	 */
	public void testRemoveUserProfile() {
		NewWindsoriteFacade facade = NewWindsoriteFacade.getFacade();
		try {
			UserProfile userProfile = new UserProfile("UserNameTest2");
			userProfile.setName("Test Name");
			userProfile.setEmail("Testemail@gmail.com");
			userProfile.setAddress("NewFakeAddress");
			userProfile.setZipCOde("FakeZipCode");
			userProfile.setPasswordHash("FakeHashPassword");
			facade.insertUserProfile(userProfile);
			facade.removeUserProfile(userProfile.getUserName());
			facade.removeUserProfile(userProfile.getUserName());
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
		NewWindsoriteFacade facade = NewWindsoriteFacade.getFacade();
		try {
			UserProfile userProfile = new UserProfile("UserNameTest3");
			userProfile.setName("Test Name");
			userProfile.setEmail("Testemail@gmail.com");
			userProfile.setAddress("NewFakeAddress");
			userProfile.setZipCOde("FakeZipCode");
			userProfile.setPasswordHash("FakeHashPassword");
			facade.insertUserProfile(userProfile);
			
			userProfile.setEmail("NewEmailAfterChange");
			facade.updateUserProfile(userProfile);
			
			UserProfile newUser = facade.searchUserProfileByUserName(userProfile.getUserName());
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
