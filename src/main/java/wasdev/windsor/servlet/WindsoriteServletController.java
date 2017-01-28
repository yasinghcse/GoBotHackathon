package wasdev.windsor.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;
import newwindsorite.db.UserProfileAlreadyExistentException;
import newwindsorite.db.UserProfileNotFoundException;
import wasdev.windsor.db.CloudantDBManager;
import wasdev.windsor.facade.NewWindsoriteFacade;
import wasdev.windsor.resources.*;

/**
 * 	Servlet Controller for interaction between Web Layer and System Layer
 *
 */
@WebServlet("/Controller")
public class WindsoriteServletController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // Reference to the System Facade
    private NewWindsoriteFacade windsoriteFacade = null;


    /**
     *  simply creates or loads some data that will be used throughout the life of the servlet
     *
     */
    public void init() throws ServletException {
    	windsoriteFacade = NewWindsoriteFacade.getFacade();

    	// Starts a Thread to send e-mails to the Registered Users.
//		Thread t = new Thread(new DaemonEmailSender(30000));
//		t.start();

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     *
     *
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try {
        	System.out.println("Act input in servelt " + request.getParameter("act"));
	        String controllerAction = request.getParameter("act");

	        if (controllerAction != null) {
	        	System.out.println("Debug1");
	        	if (controllerAction.equals("logout")) {
	        		systemLogout(request, response);
	    			RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/login.jsp");
	    			reqDispatcher.forward(request,response);
	        	} 
	        	else if (controllerAction.equals("updtRec")) {
		       		System.out.println("Debug3");
					// get the user info from session
					HttpSession s = request.getSession(false);
					UserProfile userProfile = (UserProfile) s.getAttribute("UserProfile");
					System.out.println("username in controller ****" + userProfile.getUserName());
					System.out.println("userProfile1.email" + userProfile.getEmail());
					System.out.println("user email we got = " + userProfile.getEmail());
					System.out.println("p1 in session = " + userProfile.getRecomentation1());
					System.out.println("p2 in the session = " + userProfile.getRecomentation2());
					System.out.println("p3 in the session = " + userProfile.getRecomentation3());

					// calling the update function
					updateUserRec(request, response, userProfile);
				} else if (controllerAction.equals("getRecommendations")) {

					System.out.println("before creating session");
					// get the user info from session
					HttpSession s = request.getSession(false);

					System.out.println("after creating session");
					
					// local test code
//					UserProfile userProfile = new UserProfile("test2");
//					userProfile.setRecomentation1("TrafficCharacter");
//					userProfile.setRecomentation2("forgot things");
//					userProfile.setRecomentation3("SocialCharacter");
//					System.out.println("after setting recommendations");
					
					UserProfile userProfile =(UserProfile)s.getAttribute("UserProfile");
					System.out.println("username in controller ****" + userProfile.getUserName());

					// calling the OpenData API to get all the required
					WindsorOpenDataApi obj = new WindsorOpenDataApi();
					response.getWriter().print(obj.getAllRecommendations(userProfile));

				} else if (controllerAction.equals("getRecommendationsProfile")) {
			   		System.out.println("Debug4");
					// get the user info from session
					HttpSession s = request.getSession(false);

					// local test code
					//UserProfile userProfile = new UserProfile("test2");

					 UserProfile userProfile =(UserProfile)s.getAttribute("UserProfile");
					System.out.println("username in controller ****" + userProfile.getUserName());

					// calling the OpenData API to get all the required
					response.getWriter().print(getUserProfile(request, response, userProfile.getUserName()));

				} 
	        	else {
	        		System.out.println("Debug2");
	    			RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/home.jsp");
	    			reqDispatcher.forward(request,response);
	        	}
	        }
	        else {
	       		System.out.println("Debug5");
				RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/home.jsp");
				reqDispatcher.forward(request,response);
	        }
        } catch (Exception ex) {
       		System.out.println("Debug6");
        	response.flushBuffer();
        	ex.printStackTrace(response.getWriter());
        }
    }


    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     *
     *
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try {
	        String controllerAction = request.getParameter("act");
					System.out.println("contoller action ==" + controllerAction);

	        if (controllerAction != null) {
	        	if (controllerAction.equals("updtProf")) {
	        		System.out.println("######### [DEBUG] System update profile will be called!");
	        		if (isSessionValid(request)) {
						HttpSession session = request.getSession(false);
						UserProfile sessionUserProfile = (UserProfile) session.getAttribute("UserProfile");
						UserProfile userProfile = new UserProfile(sessionUserProfile.getUserName());
						userProfile.setName(sessionUserProfile.getName());
		        		userProfile.setEmail(request.getParameter("email"));
		        		userProfile.setAddress(request.getParameter("address"));
		        		userProfile.setZipCOde(request.getParameter("zipcode"));
		        		userProfile.setRecomentation1(sessionUserProfile.getRecomentation1());
		        		userProfile.setRecomentation2(sessionUserProfile.getRecomentation2());
		        		userProfile.setRecomentation3(sessionUserProfile.getRecomentation3());
		        		updateUserProfile(request, response, userProfile);
	        		}
	        	} else if (controllerAction.equals("insProf")) {
	        		UserProfile userProfile = new UserProfile(request.getParameter("username"));
	        		userProfile.setEmail(request.getParameter("email"));
	        		userProfile.setName(request.getParameter("name"));
	        		userProfile.setAddress(request.getParameter("address"));
	        		userProfile.setZipCOde(request.getParameter("zipcode"));
	        		String hashedPassword = WindsoriteUtil.generateStringHash(request.getParameter("password"));
	        		userProfile.setPasswordHash(hashedPassword);
	        		insertUserProfile(request, response, userProfile);
	        	} else if (controllerAction.equals("delProf")) {
	        		removeUserProfile(request, response, request.getParameter("userName"));
	        	} else if (controllerAction.equals("finProf")) {
	        		searchUserProfile(request, response, request.getParameter("userName"));
	        	} else if (controllerAction.equals("login")) {
	        		systemLogin(request, response, request.getParameter("username"), request.getParameter("password"));
	        	} else if (controllerAction.equals("logout")) {
	        		systemLogout(request, response);
	        	} else {
	        		System.out.println("######### [DEBUG] System no ACT was selected!!!!");
	    			RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/home.jsp");
	    			reqDispatcher.forward(request,response);
	        	}
	        } else {
	        	System.out.println("######### [DEBUG] System action is null!");
				RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/home.jsp");
				reqDispatcher.forward(request,response);
	        }
        } catch (Exception ex) {
        	response.flushBuffer();
        	ex.printStackTrace(response.getWriter());
        }
    }


    /**
     *
     *
     * @param request
     * @param response
     * @throws IOException
     */
    private void systemLogout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			System.out.println("######### [DEBUG] System Loging out, Invalidating Session!");
			session.invalidate();
			//Servlet JSP communication
			RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/login.jsp");
			reqDispatcher.forward(request,response);
		} else {
			System.out.println("######### [DEBUG] System Loging out, Session was already NULL!");
			//Servlet JSP communication
			RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/login.jsp");
			reqDispatcher.forward(request,response);
		}
	}

	/**
     *
     *
     * @param request
     * @param response
     * @param parameter
     * @param parameter2
     * @return
     * @throws IOException
     */
    private void systemLogin(HttpServletRequest request, HttpServletResponse response, String userName,
			String passwordPlain) throws IOException, ServletException  {
		try {
			UserProfile user = windsoriteFacade.systemLogin(userName, passwordPlain);
			if (user != null) {
				System.out.println("######### [DEBUG] System login successfuly, Authenticated user!");
				System.out.println("######### [DEBUG] System will check is session already existed....");
				// Checks is there is already an user loged in with a valid session, if so, destroys it and creates a new one
				HttpSession session = request.getSession(false);
				if (session != null) {
					System.out.println("######### [DEBUG] session already existed.... Will destroy it and create nw one as it is a new login");
					session.invalidate();
				}
				System.out.println("######### [DEBUG] New session being created.... ");
				session = request.getSession(true);
				session.setAttribute("UserProfile", user);
				System.out.println("######### [DEBUG] Session received new User.... => " + user.getUserName());

				//communicating to the JSP
				String message = "User Logged In Succesfully!";
				System.out.println("######### [DEBUG] System login successfuly, returning message to JSP => " + message);
				request.setAttribute("LoginMessage", message);

				//Servlet JSP communication
				RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/home.jsp");
				reqDispatcher.forward(request,response);
			} else {
				//communicating to the JSP
				String message = "Invalid Password!";
				System.out.println("######### [DEBUG] System login Invalid Password, returning message to JSP => " + message);
				request.setAttribute("LoginMessage", message);

				//Servlet JSP communication
				RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/login.jsp");
				reqDispatcher.forward(request,response);
			}
		} catch (UserProfileNotFoundException ex) {
			//communicating to the JSP
			String message = "User not found!";
			request.setAttribute("LoginMessage", message);
			System.out.println("######### [DEBUG] System login User not found, returning message to JSP => " + message);

			//Servlet JSP communication
			RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/login.jsp");
			reqDispatcher.forward(request,response);
		}
	}

	/**
     *
     *
     * @param request
     * @param response
     * @param userName
     * @throws IOException
     */
	private void searchUserProfile(HttpServletRequest request, HttpServletResponse response, String userName) throws IOException {
		try {
			response.getWriter().print("Search Result: <BR>");
			UserProfile user = windsoriteFacade.searchUserProfileByUserName(userName);
			response.getWriter().print("User Profile by User Name '" + userName + "' FOUND!<BR><BR>");
			response.getWriter().print("id = " + user.get_id() + "<BR>");
			response.getWriter().print("UserName = " + user.getUserName() + "<BR>");
			response.getWriter().print("Name = " + user.getName() + "<BR>");
			response.getWriter().print("Email = " + user.getEmail() + "<BR>");
			response.getWriter().print("Address = " + user.getAddress() + "<BR>");
			response.getWriter().print("ZipCode = " + user.getZipCOde() + "<BR>");
			response.getWriter().print("Recomendation 1 = " + user.getRecomentation1() + "<BR>");
			response.getWriter().print("Recomendation 2 = " + user.getRecomentation2() + "<BR>");
			response.getWriter().print("Recomendation 3 = " + user.getRecomentation3() + "<BR>");
		} catch (UserProfileNotFoundException ex) {
			response.getWriter().print("User Profile by User Name '" + userName + "' NOT FOUND!<BR>");
		}
	}

	// yadi
		private JSONObject getUserProfile(HttpServletRequest request, HttpServletResponse response, String userName)
				throws IOException {

			UserProfile user = null;
			// local variable
			JSONObject obj = new JSONObject();
			try {
				user = windsoriteFacade.searchUserProfileByUserName(userName);
				if(user.getName() != null){
					obj.put("name", user.getName());
				}
				if(user.getEmail() != null){
					obj.put("email", user.getEmail());
				}
				if(user.getAddress() != null){
					obj.put("address", user.getAddress());
				}
				if(user.getZipCOde() != null){
					obj.put("zipcode", user.getZipCOde());
				}
			} catch (UserProfileNotFoundException ex) {
				response.getWriter().print("User Profile by User Name '" + userName + "' NOT FOUND!<BR>");
			}
			return obj;
		}

	/**
	 *
	 * @param request
	 * @param response
	 * @param userName
	 * @throws IOException
	 */
	private void removeUserProfile(HttpServletRequest request, HttpServletResponse response, String userName) throws IOException {
		try {
			response.getWriter().print("Removal Result: <BR>");
			windsoriteFacade.removeUserProfile(userName);
			response.getWriter().print("User Profile by User Name '" + userName + "' REMOVED!<BR>");
		} catch (UserProfileNotFoundException ex) {
			response.getWriter().print("User Profile by User Name '" + userName + "' NOT FOUND!<BR>");
		}
	}

	/**
	 *
	 * @param request
	 * @param response
	 * @param userProfile
	 * @throws IOException
	 */
	private void insertUserProfile(HttpServletRequest request, HttpServletResponse response, UserProfile user) throws IOException, ServletException {
		try {
			System.out.println("######### [DEBUG] System will insert new UserProfile");
			windsoriteFacade.insertUserProfile(user);
			System.out.println("######### [DEBUG] System Created new User will Log him in!");
			// Proceeds to the login process
			HttpSession session = request.getSession(true);
			session.setAttribute("UserProfile", user);
			System.out.println("######### [DEBUG] System created session for user!");

			//Servlet JSP communication
			RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/home.jsp");
			reqDispatcher.forward(request,response);
		} catch (UserProfileAlreadyExistentException ex) {
			//communicating to the JSP
			String message = "User Name already taken, try another one!";
			System.out.println("######### [DEBUG] System cannot create new user, it is already existent.");
			System.out.println("######### [DEBUG] System creating new user profile, returning message to JSP => " + message);
			request.setAttribute("SignUpMessage", message);

			//Servlet JSP communication
			RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/register.jsp");
			reqDispatcher.forward(request,response);
		}
	}

	/**
	 *
	 * @param request
	 * @param response
	 * @param user
	 * @throws IOException
	 */
	private void updateUserProfile(HttpServletRequest request, HttpServletResponse response, UserProfile user) throws IOException, ServletException{
		if (isSessionValid(request)) {
			try {
				windsoriteFacade.updateUserProfile(user);
				//communicating to the JSP
				System.out.println("######### [DEBUG] Update profile done fine!");
				System.out.println("######### [DEBUG] Update profile new User = " + user);
				HttpSession session = request.getSession(false);
				if (session != null) {
					System.out.println("######### [DEBUG] Update session not null, updating user in the session!");
					session.setAttribute("UserProfile", user);
				} else {
					System.out.println("######### [DEBUG] Update session is null, but should not be!");
				}

				//Servlet JSP communication
				RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/profile.jsp");
				reqDispatcher.forward(request,response);

			} catch (UserProfileNotFoundException ex) {
				//Servlet JSP communication
				RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/home.jsp");
				reqDispatcher.forward(request,response);			}
		} else {
			//Servlet JSP communication
			RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/login.jsp");
			reqDispatcher.forward(request,response);
		}
	}

	
	/**
	 *
	 * @param request
	 * @param response
	 * @param user
	 * @throws IOException
	 */
	private void updateUserRec(HttpServletRequest request, HttpServletResponse response, UserProfile user) throws IOException, ServletException{
		if (isSessionValid(request)) {
			try {
				windsoriteFacade.updateUserProfile(user);
				System.out.println("######### [DEBUG] Update profile done fine!");
				System.out.println("######### [DEBUG] Update profile new User = " + user);
				HttpSession session = request.getSession(false);
				if (session != null) {
					System.out.println("######### [DEBUG] Update session not null, updating user in the session!");
					session.setAttribute("UserProfile", user);
				} else {
					System.out.println("######### [DEBUG] Update session is null, but should not be!");
				}

			} catch (UserProfileNotFoundException ex) {
				System.out.println("failure");
			}
		} else {
			System.out.println("failure");
		}
	}

	/**
	 *
	 *
	 * @param request
	 * @return
	 */
	private boolean isSessionValid(HttpServletRequest request) {
		boolean isValid = false;
		if (request.getSession(false) != null) {
			isValid = true;
		}
		return isValid;
	}
}
