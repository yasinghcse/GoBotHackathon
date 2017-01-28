package hackathon.gobot.pdf;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CouncilPDFCrawler {

	private static final String COUNCIL_AGENDA_PAGE_URL = "http://www.citywindsor.ca/cityhall/city-council-meetings/meetings-this-week/pages/current-council-agenda.aspx";
	
	// Use Static method only
	private CouncilPDFCrawler() {
	}
	
	
	/**
	 * 
	 * 
	 */
	public static CouncilAgenda getNextCouncilAgenda() {
		CouncilAgenda councilAgenda = null;
		boolean agendaFound = false;
		
    	try {
	   		// Connects to the Provided URL to Visit
	    	Connection connectionToURL = Jsoup.connect(COUNCIL_AGENDA_PAGE_URL);

	    	// Obtains the Document that in this case represents the HTML File
		    Document jSoupDoc = connectionToURL.get();

		    Elements classContents = jSoupDoc.getElementsByClass("ccw-Element-P");
		    if (classContents != null) {
		    	Iterator<Element> itElements = classContents.iterator();
		    	while (itElements.hasNext()) {
		    		Element tagElement = itElements.next();
//		    		System.out.println("## Tag Name = " + tagElement.tagName());
//		    		System.out.println("## Tag Text = " + tagElement.text());
		    		// found the assumed PARAGRAPH, lets do a few testings to make sure
		    		if (tagElement.tagName().equalsIgnoreCase("p")) {
						String meetingHeader = tagElement.text().toLowerCase();
						
						if(meetingHeader.contains("city") && meetingHeader.contains("council") 
								&& meetingHeader.contains("meeting") && meetingHeader.contains("next")) {
							
							// if contains all these words we will assume that this paragraph will contain the link to the Agenda
							// Let's get the elements inside the PARAGRAPH
			    			Elements elementsParagraph = tagElement.getAllElements();
			    			Iterator<Element> itElementsParagraph = elementsParagraph.iterator();
			    			while (itElementsParagraph.hasNext()) {
			    				Element tagElementParagraph = itElementsParagraph.next();
			    				// Found a link, lets do a few tests to make sure
			    				if (tagElementParagraph.tagName().equalsIgnoreCase("a")) {
			    					System.out.println("tagname = " + tagElementParagraph.tagName());
			    					System.out.println("text = " + tagElementParagraph.text());
			    					String meetingDate = tagElementParagraph.text().toLowerCase();
			    					if (containsProperDate(meetingDate)) {
			    						councilAgenda = new CouncilAgenda(tagElementParagraph.text(), tagElementParagraph.absUrl("href"));	    						
//			    						System.out.println(councilAgenda);
			    						agendaFound = true;
			    						break;
			    					}
			    				}
							}
						}
		    		}
		    		if (agendaFound) {
		    			break;
		    		}
		    	}
		    }
    	} catch (IOException ex) {
    		// A connection happened to the URL so it is considered to be a BROKEN URL
    		// In this case this NODE is marked as BAD it may not be considered while building the anything on this node.
    		ex.printStackTrace();
    	}
    	
    	return councilAgenda;
	}

	/**
	 * 
	 * @param meetingDate
	 * @return
	 */
	private static boolean containsProperDate(String meetingDate) {
		return (meetingDate.contains("january") || meetingDate.contains("february") || meetingDate.contains("march")
				|| meetingDate.contains("april") || meetingDate.contains("may") || meetingDate.contains("june")
				|| meetingDate.contains("july") || meetingDate.contains("august") || meetingDate.contains("september")
				|| meetingDate.contains("october") || meetingDate.contains("november") || meetingDate.contains("december"))
				&& 
				(meetingDate.contains("2013") || meetingDate.contains("2015") || meetingDate.contains("2016") || meetingDate.contains("2017")
						|| meetingDate.contains("2018") || meetingDate.contains("2019") || meetingDate.contains("2020"))
				&& (meetingDate.contains("1") || meetingDate.contains("2") || meetingDate.contains("3") || meetingDate.contains("4")
						|| meetingDate.contains("5") || meetingDate.contains("6") || meetingDate.contains("7") || meetingDate.contains("8") 
						|| meetingDate.contains("9") || meetingDate.contains("10") || meetingDate.contains("11") || meetingDate.contains("12") 
						|| meetingDate.contains("13") || meetingDate.contains("14") || meetingDate.contains("15") || meetingDate.contains("16")
						|| meetingDate.contains("17") || meetingDate.contains("18") || meetingDate.contains("19") || meetingDate.contains("20")										
						|| meetingDate.contains("21") || meetingDate.contains("22") || meetingDate.contains("23") || meetingDate.contains("24")
						|| meetingDate.contains("25") || meetingDate.contains("26") || meetingDate.contains("27") || meetingDate.contains("28")
						|| meetingDate.contains("29") || meetingDate.contains("30") || meetingDate.contains("31"));
	}
	
	/**
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
//		CouncilAgenda councilAgenda = CouncilPDFCrawler.getNextCouncilAgenda();
//		System.out.println(councilAgenda);
//		System.out.println(councilAgenda.getPDFFiileLink());
	}

}
