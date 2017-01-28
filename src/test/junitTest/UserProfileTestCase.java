package junitTest;

import junit.framework.TestCase;
import wasdev.windsor.resources.UserProfile;

public class UserProfileTestCase extends TestCase {

	/**
	 *  Constructor Test Method
	 */
	public void testUserProfileContructor() {
			UserProfile userProfile = new UserProfile("UserNameTest");
			assertEquals(userProfile.get_id(), userProfile.getUserName());			
			assertEquals(userProfile.get_id(), "UserNameTest");
			assertEquals(userProfile.getUserName(), "UserNameTest");
			UserProfile userProfile2 = new UserProfile(null);
			assertEquals(userProfile2.get_id(), null);			
			assertEquals(userProfile2.get_id(), null);
			assertEquals(userProfile2.getUserName(), null);			
	}

	/**
	 *  
	 */
	public void testSetEmail() {
		UserProfile userProfile = new UserProfile("UserNameTest");
		userProfile.setEmail("NameTest@gmail.com");
		assertEquals(userProfile.getEmail(), "NameTest@gmail.com");			
	}	
	
	/**
	 * 
	 */
	public void testSetName() {
		UserProfile userProfile = new UserProfile("UserNameTest");
		userProfile.setName("NameTest");
		assertEquals(userProfile.getUserName(), "UserNameTest");
	}	
	
	/**
	 * 
	 */
	public void testSetAddress() {
		UserProfile userProfile = new UserProfile("UserNameTest");
		userProfile.setAddress("FakeTestAddress");
		assertEquals(userProfile.getAddress(), "FakeTestAddress");
	}	
	
	/**
	 * 
	 */
	public void testSetZipCode() {
		UserProfile userProfile = new UserProfile("UserNameTest");
		userProfile.setZipCOde("FakeTestZipCode");
		assertEquals(userProfile.getZipCOde(), "FakeTestZipCode");
	}	
	
	/**
	 * 
	 */
	public void testSetRecomentation() {
		UserProfile userProfile = new UserProfile("UserNameTest");
		userProfile.setRecomentation1("Fake Recomendation 1");
		userProfile.setRecomentation2("Fake Recomendation 2");
		userProfile.setRecomentation3("Fake Recomendation 3");
		assertEquals(userProfile.getRecomentation1(), "Fake Recomendation 1");
		assertEquals(userProfile.getRecomentation2(), "Fake Recomendation 2");
		assertEquals(userProfile.getRecomentation3(), "Fake Recomendation 3");
	}	
	
	/**
	 * 
	 */
	public void testSetPassword() {
		UserProfile userProfile = new UserProfile("UserNameTest");
		userProfile.setPasswordHash("fakeHashPassword");
		assertEquals(userProfile.getPasswordHash(), "fakeHashPassword");
	}	

}
