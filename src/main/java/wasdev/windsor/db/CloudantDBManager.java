package wasdev.windsor.db;

import java.util.Map.Entry;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.Response;
import com.cloudant.client.org.lightcouch.CouchDbException;
import com.cloudant.client.org.lightcouch.NoDocumentException;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import newwindsorite.db.UserProfileAlreadyExistentException;
import newwindsorite.db.UserProfileNotFoundException;
import wasdev.windsor.resources.UserProfile;

public class CloudantDBManager {

	private CloudantClient cloudant = null;
	private Database db = null;
	private String databaseName = "newwindsorite";
	private static CloudantDBManager singletonCloudant = null;
	private HashMap<String, UserProfile> dbDebug = new HashMap<String,UserProfile>();
	
	private static boolean debugMode = false; 

	/**
	 *    Private constructor for Singleton Pattern
	 */
	private CloudantDBManager() {}
	
	
	/**
	 *     Method to retrieve the SINGLE instance of the Database Manager.
	 * 
	 * @return Returns the singleton reference to the CloudantDBManager  
	 */
	public static CloudantDBManager getInstance() {
		synchronized (CloudantDBManager.class) {
			if (singletonCloudant == null) {
				singletonCloudant = new CloudantDBManager();
				System.out.println("######### [DEBUG] It is on debug mode!!!");
				if (!debugMode) {
					singletonCloudant.cloudant = createClient();
					try {
						singletonCloudant.db = singletonCloudant.cloudant.database(singletonCloudant.databaseName, true);
					} catch (Exception e) {
						throw new RuntimeException("DB Not found", e);
					}
				} else {
					System.out.println("######## [DEBUG] dbDebug is : " + singletonCloudant.db);
					// Instantiates the Hashmap for debug
				}
			}
		}
		
		return singletonCloudant;
	}
	
	
	/**
	 *  Creates CloudantClient to access Cloudant Database  
	 * 
	 * @return
	 */
	private static CloudantClient createClient() {
		// VCAP_SERVICES is a system environment variable
		// Parse it to obtain the NoSQL DB connection info
		String VCAP_SERVICES = System.getenv("VCAP_SERVICES");

		String serviceName = null;
		
		String user = "30c44038-8e2d-49dd-9798-f93d0a9e828d-bluemix";
		String password = "93e9e25f03d5b88071c8bce0c124852eb2c122de2644333ad4073a368c935e6a";


		//uncomment me
//		if (VCAP_SERVICES != null) {
//			// parse the VCAP JSON structure
//			JsonObject obj = (JsonObject) new JsonParser().parse(VCAP_SERVICES);
//			Entry<String, JsonElement> dbEntry = null;
//			Set<Entry<String, JsonElement>> entries = obj.entrySet();
//			// Look for the VCAP key that holds the cloudant no sql db information
//			for (Entry<String, JsonElement> eachEntry : entries) {
//				if (eachEntry.getKey().toLowerCase().contains("cloudant")) {
//					dbEntry = eachEntry;
//					break;
//				}
//			}
//			if (dbEntry == null) {
//				throw new RuntimeException("Could not find cloudantNoSQLDB key in VCAP_SERVICES env variable");
//			}
//
//			obj = (JsonObject) ((JsonArray) dbEntry.getValue()).get(0);
//			serviceName = (String) dbEntry.getKey();
//			System.out.println("Service Name - " + serviceName);
//
//			obj = (JsonObject) obj.get("credentials");
//
//			user = obj.get("username").getAsString();
//			password = obj.get("password").getAsString();
//
//		} else {
//			throw new RuntimeException("VCAP_SERVICES not found");
//		}

		try {
			CloudantClient client = ClientBuilder.account(user)
					.username(user)
					.password(password)
					.build();
			System.out.println("successfull");
			return client;
		} catch (CouchDbException e) {
			throw new RuntimeException("Unable to connect to repository", e);
		}
	}


	/**
	 * 	Searches for a User Profile in the Database based on the UserName
	 * 
	 * @param userName The User Name to search for its profile
	 * @return Returns the User profile if found and if not throws UserProfileNotFoundException 
	 * @throws UserProfileNotFoundException
	 */
	public UserProfile searchUserProfileByUserName(String userName) throws UserProfileNotFoundException {
		UserProfile retrievedUser = null;
		if (userName != null) {
			if (!debugMode) {
				HashMap<String, Object> foundDocument = null;
				try {
					foundDocument = db.find(HashMap.class, userName);
				} catch (NoDocumentException ex) {
				}
				if (foundDocument != null) {
					retrievedUser = new UserProfile(userName);
					retrievedUser.setName((String)foundDocument.get("Name"));
					retrievedUser.setEmail((String)foundDocument.get("Email"));
					retrievedUser.setAddress((String)foundDocument.get("Address"));
					retrievedUser.setZipCOde((String)foundDocument.get("ZipCode"));
					retrievedUser.setRecomentation1((String)foundDocument.get("Recomentation1"));					
					retrievedUser.setRecomentation2((String)foundDocument.get("Recomentation2"));
					retrievedUser.setRecomentation3((String)foundDocument.get("Recomentation3"));
					retrievedUser.setPasswordHash((String)foundDocument.get("PasswordHash"));
				} else {
					throw new UserProfileNotFoundException("User profile not found");
				}
			} else {
				System.out.println("######## [DEBUG] Search => Before searching is exists");
				retrievedUser = dbDebug.get(userName);
				System.out.println("######## [DEBUG] Search => User retrieved is = " + retrievedUser);
				if (retrievedUser == null) {
					System.out.println("######## [DEBUG] Search => User retrieved is NULL will throw a UserNotFoundException");
					throw new UserProfileNotFoundException("User profile not found");
				}
			}
		}
		return retrievedUser;
	}
	
	
	/**
	 * 
	 *  Inserts a new UserProfile in Database
	 *  If UserName already existent in the Database throws UserProfileAlreadyExistentException
	 * 
	 * @param UserProfile
	 * @throws UserProfileAlreadyExistentException
	 */
	public void insertUserProfile(UserProfile newUserProfile) throws UserProfileAlreadyExistentException {
		System.out.println("######## [DEBUG] Insertion => UserProfile = " + newUserProfile);
		if (!debugMode) {
			HashMap<String, Object> foundDocument = null;
			try {
				foundDocument = db.find(HashMap.class, newUserProfile.getUserName());
			} catch (NoDocumentException ex) {
			}
			
			if (foundDocument == null) {
				Map<String, Object> cloudantDocument = new HashMap<String, Object>();
				cloudantDocument.put("_id", newUserProfile.get_id());
				cloudantDocument.put("UserName", newUserProfile.getUserName());
				cloudantDocument.put("Name", newUserProfile.getName());
				cloudantDocument.put("Email",newUserProfile.getEmail());
				cloudantDocument.put("Address",newUserProfile.getAddress());		
				cloudantDocument.put("ZipCode",newUserProfile.getZipCOde());
				cloudantDocument.put("Recomentation1",newUserProfile.getRecomentation1());
				cloudantDocument.put("Recomentation2",newUserProfile.getRecomentation2());
				cloudantDocument.put("Recomentation3",newUserProfile.getRecomentation3());
				cloudantDocument.put("PasswordHash",newUserProfile.getPasswordHash());
				db.save(cloudantDocument);
			} else {
				throw new UserProfileAlreadyExistentException("User name already used");
			}
		} else {
			System.out.println("######## [DEBUG] Insertion => Begore testing if UserProfie exists");
			if (dbDebug.get(newUserProfile.getUserName()) == null) {
				System.out.println("######## [DEBUG] Insertion => Does not exist, will insert");
				System.out.println("######## [DEBUG] Insertion => UserProfile = " + newUserProfile);
				dbDebug.put(newUserProfile.getUserName(), newUserProfile);
			} else {
				throw new UserProfileAlreadyExistentException("User name already used");
			}
		}
	}
	
	/**
	 *  Removes a UserProfile from Database based on UserName
	 *  Throws UserProfileNotFoundException if UserName not found in the database
	 * 
	 * @param userName
	 * @throws UserProfileNotFoundException
	 */
	public void removeUserProfileByUserName(String userName) throws UserProfileNotFoundException {
		if (userName != null) {
			if (!debugMode) {
				HashMap<String, Object> foundDocument = null;
				try {
					foundDocument = db.find(HashMap.class, userName);
				} catch (NoDocumentException ex) {
				}
				if (foundDocument != null) {
					db.remove(foundDocument);
				} else {
					throw new UserProfileNotFoundException("User not found");
				}
			} else {
				System.out.println("######## [DEBUG] Remove => Before removing checks if exists UserName: " + userName);
				if (dbDebug.get(userName) != null) {
					System.out.println("######## [DEBUG] Remove => Found a userProfile then it will remove!");
					dbDebug.remove(userName);
				} else {
					System.out.println("######## [DEBUG] Remove => Not Found a userProfile then it will raise an exception NotFound");
					throw new UserProfileNotFoundException("User not found");
				}
			}
		}
	}
	
	/**
	 * 
	 *  Updates a UserProfile from Database
	 *  Throws UserProfileNotFoundException if UserName not found in the database
	 * 
	 * @param UserProfile User Profile to be Updated
	 * @throws UserProfileNotFoundException
	 */
	public void updateUserProfileByUserName(UserProfile updatedUser) throws UserProfileNotFoundException {
		if (updatedUser != null) {
			if (!debugMode) {
				HashMap<String, Object> foundDocument = null;
				try {
					foundDocument = db.find(HashMap.class, updatedUser.getUserName());
				} catch (NoDocumentException ex) {
				}
				if (foundDocument != null) {
					foundDocument.put("Name", updatedUser.getName());
					foundDocument.put("Email",updatedUser.getEmail());
					foundDocument.put("Address",updatedUser.getAddress());		
					foundDocument.put("ZipCode",updatedUser.getZipCOde());
					foundDocument.put("Recomentation1",updatedUser.getRecomentation1());
					foundDocument.put("Recomentation2",updatedUser.getRecomentation2());
					foundDocument.put("Recomentation3",updatedUser.getRecomentation3());
					db.update(foundDocument);
				} else {
					throw new UserProfileNotFoundException("User profile not found");
				}
			} else {
				if (dbDebug.get(updatedUser.getUserName()) != null) {
					UserProfile user = dbDebug.get(updatedUser.getUserName());
					user.setName(updatedUser.getName());
					user.setEmail(updatedUser.getEmail());
					user.setAddress(updatedUser.getAddress());
					user.setZipCOde(updatedUser.getZipCOde());
					user.setRecomentation1(updatedUser.getRecomentation1());
					user.setRecomentation2(updatedUser.getRecomentation2());
					user.setRecomentation3(updatedUser.getRecomentation3());
				} else {
					throw new UserProfileNotFoundException("User not found");
				}
			}
		}
	}
	
	/**
	 * 	Searches for a User Profile in the Database based on the UserName
	 * 
	 * @param userName The User Name to search for its profile
	 * @return Returns the User profile if found and if not throws UserProfileNotFoundException 
	 * @throws UserProfileNotFoundException
	 */
	public Collection<UserProfile> retrieveAllUserProfiles() {
		Collection<UserProfile> usersCollection = null;
		if (!debugMode) {
			throw new RuntimeException("Needs to be implements for Cloudant");
		} else {
			usersCollection = dbDebug.values();
		}
		
		return usersCollection;
	}
}

