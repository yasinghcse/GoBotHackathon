package wasdev.windsor.facade;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;

import newwindsorite.db.UserProfileAlreadyExistentException;
import newwindsorite.db.UserProfileNotFoundException;
import wasdev.windsor.db.CloudantDBManager;
import wasdev.windsor.resources.UserProfile;
import wasdev.windsor.resources.WindsoriteUtil;


public class NewWindsoriteFacade {
	
	
	private static NewWindsoriteFacade facade = null;
	private CloudantDBManager cloudantManager = null;
	
	/**
	 *    Gets access to NewWindsorite Facade
	 * 
	 * @return Returns a reference to NewWindsoriteFacade
	 */
	public static NewWindsoriteFacade getFacade() {
		if (facade == null) {
			synchronized (NewWindsoriteFacade.class) {
				facade = new NewWindsoriteFacade();
			} 
		}
		return facade;
	}

	/**
	 *    Private constructor for Singleton Pattern
	 * 
	 */
	private NewWindsoriteFacade() {
		// Initiates the Cloudant DB at startup
		this.cloudantManager = CloudantDBManager.getInstance();
	}
	
	/**
	 * 
	 * @param userName
	 * @return
	 * @throws UserProfileNotFoundException 
	 */
	public UserProfile searchUserProfileByUserName(String userName) throws UserProfileNotFoundException {
		return cloudantManager.searchUserProfileByUserName(userName);
	}
	
	/**
	 * 
	 * @param newUserProfile
	 * @return
	 * @throws UserProfileAlreadyExistentException 
	 */
	public void insertUserProfile(UserProfile newUserProfile) throws UserProfileAlreadyExistentException {
		cloudantManager.insertUserProfile(newUserProfile);
	}
	
	/**
	 * 
	 * @param userProfile
	 * @return
	 * @throws UserProfileNotFoundException 
	 */
	public void removeUserProfile(String userName) throws UserProfileNotFoundException {
		cloudantManager.removeUserProfileByUserName(userName);
	}
	
	/**
	 * 
	 * @param userProfile
	 * @return
	 * @throws UserProfileNotFoundException 
	 */
	public void updateUserProfile(UserProfile userProfile) throws UserProfileNotFoundException {
		cloudantManager.updateUserProfileByUserName(userProfile);
	}
	
	/**
	 * 	Retrieves a collection of users to send email recomentations
	 * 
	 * @return
	 */
	public Collection<UserProfile> retrieveAllUserProfiles() {
		return cloudantManager.retrieveAllUserProfiles();
	}
	
	
	/**
	 * 
	 * 
	 * 
	 * @param userName
	 * @param userPassPlain
	 * @return UserProfile If users Exists and Password is valid, returns is Profile
	 * @throws UserProfileNotFoundException
	 */
	public UserProfile systemLogin(String userName,String userPassPlain) throws UserProfileNotFoundException {
		UserProfile userProfile = null;
		if (userName != null && userPassPlain != null) {
			userProfile = this.searchUserProfileByUserName(userName);
			if(!WindsoriteUtil.isWordHasMatch(userPassPlain, userProfile.getPasswordHash())) {
				userProfile = null;
			}
		}
		return userProfile;
	}
	
	
	
	
	
}
