/**
 * This class hold the connection logic to watson
 * All Watson communication passes through this servlet
 * 
 * @author yadwindersingh
 */

package hackathon.gobot.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jettison.json.JSONException;

import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;

import hackathon.gobot.pdf.CouncilAgenda;
import hackathon.gobot.pdf.CouncilAgendaManager;
import hackathon.gobot.pdf.PDFTextNode;
import hackathon.gobot.resources.InvertedIndex;
import hackathon.gobot.resources.ShortenUrlApi;
import hackathon.gobot.resources.TwitterApi;

/**
 * Servlet implementation class WatsonInteraction
 */
@WebServlet("/WatsonInteraction")
public class WatsonInteraction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ConversationService service = null;
	private static MessageResponse lastConversation = null;
	private static TwitterApi twitterApiCall = new TwitterApi();
	private static String newStatus = null;
	private static InvertedIndex t = new InvertedIndex();
	private static CouncilAgenda councilAgenda = null;
	private static String[] msg = new String[5];

	public WatsonInteraction() {
		super();
	}

	public void init() throws ServletException {
		councilAgenda = CouncilAgendaManager.getNextCouncilAgenda();
		System.out.println(councilAgenda);
		councilAgenda.getPDFFileLink();

		// Now start to load the file remotely
		Collection<PDFTextNode> textNodes;
		try {
			textNodes = CouncilAgendaManager.getPDFTextNodesForAgenda(councilAgenda);
			String url = ShortenUrlApi.shortenUrl(councilAgenda.getPDFFileLink());
			System.out.println("Minified code for Url is =" + url);
			for (Iterator<PDFTextNode> iterator = textNodes.iterator(); iterator.hasNext();) {
				PDFTextNode pdfTextNode = (PDFTextNode) iterator.next();
				t.updatedloadData(url, pdfTextNode.getKeyWord().toLowerCase(), pdfTextNode.getTextChunk());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MessageRequest newMessage = null;
		MessageResponse response1 = null;
		if (request.getParameter("new") != null) {

			// connecting to the Watson API
			service = new ConversationService(ConversationService.VERSION_DATE_2016_07_11);
			service.setUsernameAndPassword("fd8dd41f-2f5f-4bbe-b42e-b519e85f39a4", "jxSvoafD6MYc");
			newMessage = new MessageRequest.Builder().inputText("").build();
			response1 = service.message("f11c5611-73e2-40b2-92e2-dec31008d783", newMessage).execute();
			System.out.println(response1.getText().get(0));
			lastConversation = response1;
			for (int i = 0; i < response1.getText().size(); i++) {
				response.getWriter().print(response1.getText().get(i) + "<br>");
				System.out.println("***********" + response1.getText().get(i) + "****************");
			}

		} else {
			System.out.println("last Contct" + lastConversation.getContext());
			System.out.println("Count value = " + lastConversation.getContext().get("count"));

			System.out.println("input " + request.getParameter("question"));
			MessageRequest newMessage1 = new MessageRequest.Builder().inputText(request.getParameter("question"))
					.context(lastConversation.getContext()).build();
			response1 = service.message("f11c5611-73e2-40b2-92e2-dec31008d783", newMessage1).execute();
			lastConversation = response1;
			try {
				System.out.println(response1.getText());
			} catch (Exception e) {
				return;
			}
			ArrayList<String> test = (ArrayList<String>) response1.getText();
			System.out.println("test" + test.get(0));

			// test if there is a need to call twitter api for update
			if (test.get(0).substring(0, 10).equalsIgnoreCase("Tweet Done")) {
				System.out.println("Input number is " + request.getParameter("question"));
				System.out.println("Printing Tweet for " + msg[Integer.parseInt(request.getParameter("question")) - 1]);

				newStatus = msg[Integer.parseInt(request.getParameter("question")) - 1].substring(0, 20)
						+ System.getProperty("line.separator")+ t.pdfName;
				System.out.println("Printing Tweet = " + newStatus);
				twitterApiCall.updateTwitterStatus(newStatus);
			}

			// preparing the response back to the user
			for (int i = 0; i < response1.getText().size(); i++) {
				response.getWriter().print(response1.getText().get(i) + "<br>");
				System.out.println("***********" + response1.getText().get(i) + "****************");
			}
			if (test.get(0).equalsIgnoreCase("Let me search for you")) {
				System.out.println("Searching for question" + request.getParameter("question"));
				try {
					TreeMap<Integer, String> localTree = t.invertedIdxArray
							.get(t.search(request.getParameter("question").toLowerCase()));
					int count = 1;
					for (Map.Entry<Integer, String> entry : localTree.entrySet()) {
						String value = entry.getValue();
						response.getWriter().print(count + ": " + value + "<br>");
						msg[count - 1] = value;
						count++;
						if (count >= 6) {
							break;
						}
					}

					// setting the count to handle the watson conversation
					lastConversation.getContext().put("count", 1);

				} catch (Exception e) {
					response.getWriter().print("******No Match found for this keyword*******<br>");
					try {
						// String[] guessword =
						// t.guessWord(request.getParameter("question"));
						String[] guessword = t.findCorrection((request.getParameter("question")).toLowerCase());
						if (guessword.length > 0) {
							System.out.println("Suggestion found");
							response.getWriter().print("Here are few Suggestion you can try: <br>");
							for (int i = 0; i < guessword.length; i++) {
								System.out.println("Guessed Word" + guessword[i]);
								response.getWriter().print(i + 1 + ": " + guessword[i] + "<br>");
							}
							lastConversation.getContext().put("count", 3);
						} else {
							System.out.println("No Suggestion found");
							lastConversation.getContext().put("count", 2);
						}
					} catch (Exception e1) {
						System.out.println("No Suggestion found");
						lastConversation.getContext().put("count", 2);
					}
				}
			}

		}

	}

}
