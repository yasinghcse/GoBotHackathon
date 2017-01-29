package hackathon.gobot.resources;

import com.github.scribejava.apis.GoogleApi20;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuthService;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.lang.reflect.Type;
import java.util.Map;

public class ShortenUrlApi {
	public static String shortenUrl(String longUrl) throws IOException, JSONException {
		@SuppressWarnings("unused")
		OAuthService oAuthService = new ServiceBuilder().apiKey("anonymous").apiSecret("anonymous")
				.scope("https://www.googleapis.com/auth/urlshortener").build(GoogleApi20.instance());
		OAuthRequest oAuthRequest = new OAuthRequest(Verb.POST,
				"https://www.googleapis.com/urlshortener/v1/url?key=AIzaSyCNrZGy8oLPkQxzf6xQxqyTKjXCjCH4ZYw",
				oAuthService);
		oAuthRequest.addHeader("Content-Type", "application/json");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("longUrl", longUrl);
		oAuthRequest.addPayload(jsonObject.toString());
		Response response = oAuthRequest.send();
		Type typeOfMap = new TypeToken<Map<String, String>>() {
		}.getType();
		Map<String, String> responseMap = new GsonBuilder().create().fromJson(response.getBody(), typeOfMap);
		String st = responseMap.get("id");
		return st;

	}

	public static void main(String[] args) throws IOException, JSONException {
		System.out.println(ShortenUrlApi.shortenUrl(
				"http://www.citywindsor.ca/cityhall/City-Council-Meetings/Meetings-This-Week/Documents/public%20agenda%20feb%206%202017%20with%20items%20page%20numbers.pdf"));

	}

}
