/**
 * This class is holding 4 functions
 * which are used to get data from Windsor Open Data API
 * 
 * @author yadwindersingh
 */

package wasdev.windsor.resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class WindsorOpenDataApi {

	/**
	 * This API will return waste collection schedule for upcoming 1 week in
	 * Windsor
	 * 
	 * @return
	 */
	public String[] getGarabageCollDetails() {
		// local variables
		URL url = null;
		HttpURLConnection conn = null;
		BufferedReader br = null;
		String output = new String(), output1 = new String();
		JSONParser parser = new JSONParser();
		JSONObject array = null, array4 = null;
		;
		Object obj = null, obj2 = null;
		String arrayString = null;
		JSONArray array3 = null;
		String title = "Service: ";
		String date = " | Date: ";
		String scheduleList[] = null;
		String startDate = null, endDate = null;

		// Get Start Date
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		startDate = dateFormat.format(cal.getTime());

		// Get End Date
		cal.add(Calendar.DATE, 7);
		endDate = dateFormat.format(cal.getTime());

		// Main logic
		try {
			url = new URL("http://opendata.citywindsor.ca/api/events/wasteCollection?start=" + startDate + "&end="
					+ endDate + "&location=1A");
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				output1 = output;
			}

			// parsing JSON
			try {
				array = new JSONObject();
				obj = parser.parse(output1);
				array = (JSONObject) obj;

				// get events
				arrayString = array.get("events").toString();
				obj2 = parser.parse(arrayString);
				array3 = (JSONArray) obj2;

				// get schedule
				scheduleList = new String[array3.size()];
				for (int i = 0; i < array3.size(); i++) {
					array4 = (JSONObject) array3.get(i);
					scheduleList[i] = title.concat(array4.get("title").toString()).concat(date)
							.concat(array4.get("end").toString().substring(0, 10));
				}
				for (String s : scheduleList) {
					System.out.println(s);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// return string array of dates
		return scheduleList;
	}

	/**
	 * Get the construction information
	 * 
	 * @return
	 */
	public String[] getConstructionDetails() {
		// local variables
		URL url = null;
		HttpURLConnection conn = null;
		BufferedReader br = null;
		String output = new String(), output1 = new String();
		JSONParser parser = new JSONParser();
		JSONObject array2 = null;
		;
		Object obj = null;
		JSONArray array = null;
		String date1 = "From Date: ";
		String date2 = " | To Date: ";
		String place1 = " | Roads will be blocked From Place: ";
		String place2 = " | To Place: ";
		String desc = " | Description: ";
		ArrayList<String> scheduleList = new ArrayList<>();
		String startDate = null, endDate = null;
		String result[] = null;
		int index;

		// Get Start Date
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		startDate = dateFormat.format(cal.getTime());

		// Get End Date
		cal.add(Calendar.DATE, 7);
		endDate = dateFormat.format(cal.getTime());

		// Main logic
		try {
			url = new URL("http://opendata.citywindsor.ca/api/construction?start=" + startDate + "&end=" + endDate);
			System.out.println("URL used : " + url);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			while ((output = br.readLine()) != null) {
				output1 = output;
			}

			// parsing JSON
			try {
				array = new JSONArray();
				obj = parser.parse(output1);
				array = (JSONArray) obj;

				// get schedule
				for (int i = 0; i < array.size(); i++) {
					array2 = (JSONObject) array.get(i);
					// System.out.println(array2);
					Date d1 = dateFormat.parse(startDate);
					Date d2 = dateFormat.parse(endDate);
					Date d3 = dateFormat.parse(array2.get("start").toString().substring(0, 10).replaceAll("-", "/"));
					Date d4 = dateFormat.parse(array2.get("end").toString().substring(0, 10).replaceAll("-", "/"));

					if (d3.compareTo(d2) <= 0 && (d4.compareTo(d1) >= 0)
							&& (array2.get("fromStreet") != null && array2.get("toStreet") != null)) {

						scheduleList.add(date1.concat(array2.get("start").toString().substring(0, 10)).concat(date2)
								.concat(array2.get("end").toString().substring(0, 10)).concat(place1)
								.concat(array2.get("fromStreet").toString()).concat(place2)
								.concat(array2.get("toStreet").toString())
						// .concat(desc).concat(array2.get("description").toString().replaceAll("</*p>",
						// ""))
						);
					}
				}

				if (scheduleList.size() > 0) {
					result = new String[scheduleList.size()];
				}

				System.out.println("Road blockage list " + scheduleList.size());
				for (index = 0; index < scheduleList.size(); index++) {
					result[index] = scheduleList.get(index);
					System.out.println(result[index]);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// return string array of schedule
		return result;
	}

	/**
	 * This API will return public events for upcoming 1 week in Windsor
	 * 
	 * @return
	 */
	public String[] getEventDetails() {
		// local variables
		URL url = null;
		HttpURLConnection conn = null;
		BufferedReader br = null;
		String output = new String(), output1 = new String();
		JSONParser parser = new JSONParser();
		JSONObject array = null, array4 = null;
		;
		Object obj = null, obj2 = null;
		String arrayString = null;
		JSONArray array3 = null;
		String title = "Event Name: ";
		String date = " | From: ";
		String date1 = " To: ";
		String location = " | Location: ";
		String infoLink = " | More Info: ";
		String scheduleList[] = null;
		String startDate = null, endDate = null;

		// Get Start Date
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		startDate = dateFormat.format(cal.getTime());

		// Get End Date
		cal.add(Calendar.DATE, 1);
		endDate = dateFormat.format(cal.getTime());

		// Main logic
		try {
			url = new URL("http://opendata.citywindsor.ca/api/events/snapd?start=" + startDate + "&end=" + endDate);
			System.out.println("URL used :" + url);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				output1 = output;
			}

			// parsing JSON
			try {
				array = new JSONObject();
				obj = parser.parse(output1);
				array = (JSONObject) obj;

				// get events
				arrayString = array.get("events").toString();
				obj2 = parser.parse(arrayString);
				array3 = (JSONArray) obj2;

				// get schedule
				scheduleList = new String[array3.size()];
				for (int i = 0; i < array3.size(); i++) {
					array4 = (JSONObject) array3.get(i);
					// System.out.println(array4);
					scheduleList[i] = title.concat(array4.get("title").toString()).concat(date)
							.concat(array4.get("start").toString().substring(0, 10)).concat(date1)
							.concat(array4.get("end").toString().substring(0, 10)).concat(location)
							.concat(array4.get("googleaddress").toString()).concat(infoLink)
							.concat(array4.get("link").toString())
					// .concat(location).concat(array4.get(""))
					;
				}
				for (String s : scheduleList) {
					System.out.println(s);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// return string array of dates
		return scheduleList;
	}

	/**
	 * This class will get all the recommendations of the user These
	 * recommendations will be displayed on the Watson Recommendation page.
	 * 
	 * @param user
	 */
	public JSONObject getAllRecommendations(UserProfile user) {

		// Print the Users Recommendations
		System.out.println("P1 : " + user.getRecomentation1());
		System.out.println("P2 : " + user.getRecomentation2());
		System.out.println("P3 : " + user.getRecomentation3());

		// local varibale
		JSONObject obj = new JSONObject();

		if (user.getRecomentation1() != null) {
			if (user.getRecomentation1().equals("TrafficCharacter")) {
				JSONArray arr = new JSONArray();
				String test[] = getConstructionDetails();
				for (int i = 0; i < test.length; i++) {
					arr.add(test[i]);
				}
				obj.put("TrafficCharacter", arr);
			} else if (user.getRecomentation1().equals("forgot things")) {
				JSONArray arr = new JSONArray();
				String test[] = getGarabageCollDetails();
				for (int i = 0; i < test.length; i++) {
					arr.add(test[i]);
				}
				obj.put("forgot things", arr);
			} else if (user.getRecomentation1().equals("SocialCharacter")) {
				JSONArray arr = new JSONArray();
				String test[] = getEventDetails();
				for (int i = 0; i < test.length; i++) {
					arr.add(test[i]);
				}
				obj.put("SocialCharacter", arr);
			} else {
				System.out.println("invalid input");
			}
		}
		if (user.getRecomentation2() != null) {
			if (user.getRecomentation2().equals("TrafficCharacter")) {
				JSONArray arr = new JSONArray();
				String test[] = getConstructionDetails();
				for (int i = 0; i < test.length; i++) {
					arr.add(test[i]);
				}
				obj.put("TrafficCharacter", arr);
			} else if (user.getRecomentation2().equals("forgot things")) {
				JSONArray arr = new JSONArray();
				String test[] = getGarabageCollDetails();
				for (int i = 0; i < test.length; i++) {
					arr.add(test[i]);
				}
				obj.put("forgot things", arr);
			} else if (user.getRecomentation2().equals("SocialCharacter")) {
				JSONArray arr = new JSONArray();
				String test[] = getEventDetails();
				for (int i = 0; i < test.length; i++) {
					arr.add(test[i]);
				}
				obj.put("SocialCharacter", arr);
			} else {
				System.out.println("invalid input");
			}
		}
		if (user.getRecomentation3() != null) {
			if (user.getRecomentation3().equals("TrafficCharacter")) {
				JSONArray arr = new JSONArray();
				String test[] = getConstructionDetails();
				for (int i = 0; i < test.length; i++) {
					arr.add(test[i]);
				}
				obj.put("TrafficCharacter", arr);
			} else if (user.getRecomentation3().equals("forgot things")) {
				JSONArray arr = new JSONArray();
				String test[] = getGarabageCollDetails();
				for (int i = 0; i < test.length; i++) {
					arr.add(test[i]);
				}
				obj.put("forgot things", arr);
			} else if (user.getRecomentation3().equals("SocialCharacter")) {
				JSONArray arr = new JSONArray();
				String test[] = getEventDetails();
				for (int i = 0; i < test.length; i++) {
					arr.add(test[i]);
				}
				obj.put("SocialCharacter", arr);
			} else {
				System.out.println("invalid input");
			}
		}
		return obj;

	}

	// Test Function
	public static void main(String[] arr) {
		WindsorOpenDataApi obj = new WindsorOpenDataApi();
		System.out.println("================Wastage collection Result for 7 days==============");
		obj.getGarabageCollDetails();
		System.out.println("================construction Result for 7 days==============");
		obj.getConstructionDetails();
		System.out.println("================Event Result for 2 days==============");
		obj.getEventDetails();
	}

}
