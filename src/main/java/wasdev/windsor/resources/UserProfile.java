package wasdev.windsor.resources;

public class UserProfile {
	
	private String _id;
	private static final String _rev = "00001";
	private String name;
	private String userName;
	private String email;
	private String passwordHash;
	private String address;
	private String zipCode;
	private String recomentation1;
	private String recomentation2;
	private String recomentation3;
	
	/**
	 * 
	 * @param newID
	 */
	public UserProfile(String userName) {
		this.userName = userName;
		this._id = userName;
	}
	
	/**
	 * 
	 * @return
	 */
	public String get_id() {
		return this._id;
	}
	
	/**
	 * 
	 * @return
	 */
	public String get_rev() {
		return _rev;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return this.name;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String getUserName() {
		return this.userName;
	}

	/**
	 * 
	 */
	public void setName(String newName) {
		this.name = newName;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getEmail() {
		return this.email;
	}	

	/**
	 * 
	 * @return
	 */
	public void setEmail(String newEmail) {
		this.email = newEmail;
	}	

	
	/**
	 * 
	 * @return
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 * 
	 * @return
	 */
	public void setAddress(String newAddress) {
		this.address = newAddress;
	}	
	
	/**
	 * 
	 * @return
	 */
	public String getZipCOde() {
		return this.zipCode;
	}	
	
	/**
	 * 
	 * @return
	 */
	public void setZipCOde(String newZipcode) {
		this.zipCode = newZipcode;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getPasswordHash() {
		return this.passwordHash;
	}	
	
	/**
	 * 
	 * @return
	 */
	public void setPasswordHash(String newPasswordHash) {
		this.passwordHash = newPasswordHash;
	}
	
	/**
	 * 
	 * @return
	 */
	public void setRecomentation1(String recomentation1) {
		this.recomentation1 = recomentation1;
	}	
	
	/**
	 * 
	 * @return
	 */
	public void setRecomentation2(String recomentation2) {
		this.recomentation2 = recomentation2;
	}
	
	/**
	 * 
	 * @return
	 */
	public void setRecomentation3(String recomentation3) {
		this.recomentation3 = recomentation3;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getRecomentation1() {
		return this.recomentation1;
	}	
	
	/**
	 * 
	 * @return
	 */
	public String getRecomentation2() {
		return this.recomentation2;
	}	
	
	/**
	 * 
	 * @return
	 */
	public String getRecomentation3() {
		return this.recomentation3;
	}	
	

	public String toString() {
		return "_id = " + _id + " / _rev = " + _rev + " / name = " + name + " / userName = " + userName + " / email = " + email + " / passwordHash = " + passwordHash + " / Address = " + address + " / zipcode = " + zipCode;
	}
}
