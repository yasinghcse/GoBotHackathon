package wasdev.windsor.resources;

import java.io.IOError;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;

public class WindsoriteUtil {

	/**
	 * 
	 * 
	 * @param response
	 * @param message
	 * @throws IOException
	 */
	public static void printDebug(HttpServletResponse response, String message) throws IOException {
		boolean printConsole = false;
		if (printConsole) {
			System.out.println(message);
			
		} else {
			response.getWriter().print(message);
		}
	}
	
	/**
	 * 	Generates a Hash of the password for security purposes
	 * 
	 * @param passwordToHash
	 * @return Returns the Hashed word
	 */
	public static String generateStringHash(String wordtoHash) {
		String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(wordtoHash.getBytes());
            //Get the hash's bytes 
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
		return generatedPassword;
	}
	
	/**
	 * 	Tests if a String (Password) is valid with an existent Hash
	 * 
	 * @param passwordToHash
	 * @return Returns the Hashed word
	 */
	public static boolean isWordHasMatch(String wordtoHash, String hashedWord) {
		String generatedHash = null;
		boolean matches = false;
		
		generatedHash = WindsoriteUtil.generateStringHash(wordtoHash); 
        if (generatedHash != null && hashedWord != null) {
        	matches = generatedHash.equals(hashedWord); 
        }
		return matches;
	}
	
	
	/**
	 * 
	 *    Helper method to send and email from the Windsorite system
	 * 
	 * 
	 * @param recipients Recipient E-mails, can be one or more, separated by simple coma or space
	 * @param messageSubject Message Subject
	 * @param messageContent Message Content that can be in HTML format
	 */
	public static void sendWindsoriteEmail(String recipients, String messageSubject, String messageContent) {
	      // Sender's email ID - The NewWindsorite email created
	      String from = "NewWindsorite@gmail.com";
	      final String username = "NewWindsorite";
	      final String password = "newwindsor";//change accordingly

	      // Assuming you are sending email through Gmail
	      String host = "smtp.gmail.com";
	      // Gmail server properties
	      Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "587");
	      
//	      	    		  mail.smtp.port = 465
//	    		  mail.smtp.starttls.enable = true
//	    		  mail.smtp.socketFactory.port = 465
//	    		  mail.smtp.socketFactory.class = javax.net.ssl.SSLSocketFactory
//		

	      // Get the Session object.
	      Session session = Session.getInstance(props,
	         new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	               return new PasswordAuthentication(username, password);
	            }
		});

	      try {
	    	  // Create a default MimeMessage object.
	           Message message = new MimeMessage(session);

		   	   // Set From: header field of the header.
			   message.setFrom(new InternetAddress(from));
	
			   // Set To: header field of the header.
			   message.setRecipients(Message.RecipientType.TO,
		              InternetAddress.parse(recipients));
	
			   // Set Subject: header field
			   message.setSubject(messageSubject);
	
			   // Send the actual HTML message
			   message.setContent(messageContent,"text/html");
	
			   // Send message
			   Transport.send(message);

	      } catch (MessagingException e) {
			   e.printStackTrace();
			   throw new RuntimeException(e);
	      }
	}
	
	
	
	
	public static void main(String[] args) {
		
	}
	

}
