package wasdev.windsor.resources;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import wasdev.windsor.facade.NewWindsoriteFacade;

/**
 * @author Clóvis
 *
 */
public class DaemonEmailSender implements Runnable {
	
	private NewWindsoriteFacade facade = null;
	
	private long sleepTime;

	/**
	 * Daemon Class to send emails to the registered users
	 * 
	 * @param sleepTime This is the interval the Daemon will sleep to send a new message again. Use 1440000 to make is 24H.
	 * 
	 */
	public DaemonEmailSender(long sleepTime) {
		this.sleepTime = sleepTime; 
	}

	/**
	 * 
	 * 
	 */
	@Override
	public void run() {
		
       try {
    	   facade = NewWindsoriteFacade.getFacade();
    	   
    	   while (true) {
    		   System.out.println("######### [DEBUG] Started the DAEMON Email Thread !!!!");
        	   Collection<UserProfile> users = facade.retrieveAllUserProfiles();
        	   if (users != null) {
        		   Iterator usersIterator = users.iterator();
        		   System.out.println("######### [DEBUG] DAEMON Email Thread  - Will Start sending e-mails");
        		   while (usersIterator.hasNext()) {
        			   UserProfile user = (UserProfile)usersIterator.next();
    	    		   System.out.println("Send email to the user: " +  user.getUserName());
    	    		   System.out.println("Send email to the Email: " + user.getEmail());
    	    		   System.out.println("----------------------------");
    	    		   
    	    		   Date todayDate = new Date();
    	    		   String subjectContent = "NewWindsorite Recomendation Update #" + todayDate;
    	    		   String messageContent = "Testing content message"; 
    	    		   
    	    		   WindsoriteUtil.sendWindsoriteEmail(user.getEmail(),subjectContent,messageContent);
        		   }
        		   System.out.println("######### [DEBUG] DAEMON Email Thread  - Finished sending e-mails");
	    		   Thread.sleep(sleepTime);
        	   } else if (users != null && users.size() == 0) {
        		   System.out.println("######### [DEBUG] DAEMON Email Thread  - Users list is empty");
        	   }
    	   }
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
	
	/**
	 * 
	 * 
	 * @param args
	 */
//	public static void main(String[] args) throws Exception{
//		NewWindsoriteFacade facade = NewWindsoriteFacade.getFacade();
//		UserProfile user = new UserProfile("Clovis");
//		user.setEmail("clovis.nogueira@gmail.com");
//		facade.insertUserProfile(user);
//
//		
//		user = new UserProfile("Nogueira");
//		user.setEmail("nogueira.clovis@gmail.com");
//		facade.insertUserProfile(user);
//
//		Thread t = new Thread(new DaemonEmailSender(30000));
//		t.start();
//
//	}
	

}
