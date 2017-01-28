package wasdev.windsor.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import com.google.gson.JsonArray;

import wasdev.windsor.resources.WindsorOpenDataApi;

/**
 * Servlet implementation class OpenDataInteraction
 */
@WebServlet("/OpenDataInteraction")
public class OpenDataInteraction extends HttpServlet {
	//private variables
	private static WindsorOpenDataApi obj=  new WindsorOpenDataApi();
	String[] arr =null;
	JSONArray arr1 =  null;
	
	private static final long serialVersionUID = 1L;

    public OpenDataInteraction() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("input" + request.getParameter("call"));
		if (request.getParameter("call") == null) {
			System.out.println("insufficient parameters");
			response.getWriter().print("insufficient parameters");
		}
		else if (request.getParameter("call").equalsIgnoreCase("garbage")) {
			System.out.println("Calling the Wastage Collection API");
			 arr = obj.getGarabageCollDetails();
			 arr1 = new  JSONArray();
			for(int i=0; i < arr.length; i++){
				arr1.add(arr[i]);
			}
			System.out.println( "======" +arr1);
			response.getWriter().print(arr1);
		}
		else if (request.getParameter("call").equalsIgnoreCase("events")) {
			System.out.println("Calling the Event Info API");
			arr = obj.getEventDetails();
			arr1 = new  JSONArray();
			for(int i=0; i < arr.length; i++){
				arr1.add(arr[i]);
			}
			System.out.println( "======" +arr1);
			response.getWriter().print(arr1);
		}
		else if (request.getParameter("call").equalsIgnoreCase("construction")) {
			System.out.println("Calling the Construction Info API");
			arr = obj.getConstructionDetails();
			arr1 = new  JSONArray();
			for(int i=0; i < arr.length; i++){
				arr1.add(arr[i]);
			}
			System.out.println( "======" +arr1);
			response.getWriter().print(arr1);
		}
		else{
			System.out.println("invalid paramter");
			response.getWriter().print("invalid paramter");
		}	
	}
}
