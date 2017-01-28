package hackathon.gobot.pdf;


import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

public class CouncilAgendaManager {


	/**
	 * Don't dreate objects use the Static Methods
	 */
	private CouncilAgendaManager() {
	}
	
	/**
	 * 
	 * @return
	 */
	public static CouncilAgenda getNextCouncilAgenda() {
		// Here you have all the Agenda info
		// Date published in the page
		// Link to the HTTP server where the file is
		CouncilAgenda councilAgenda = CouncilPDFCrawler.getNextCouncilAgenda();
		return councilAgenda;
	}
	
	/**
	 * 
	 * 
	 * @param councilAgenda
	 * @return
	 * @throws IOException
	 */
	public static Collection<PDFTextNode> getPDFTextNodesForAgenda(CouncilAgenda councilAgenda) throws IOException {
		// Now xstart to load the file remotely
    	PDFFileHandler pdfManager = new PDFFileHandler(councilAgenda.getPDFFileLink(), true);
    	// Starts to parse the PDF file and prepare all the node
    	PDFParser pdfParser = new PDFParser(pdfManager);
    	return pdfParser.parse();
	}
	
	
	/**
	 * 
	 * 
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// Here you have all the Agenda info
		// Date published in the page
		// Link to the HTTP server where the file is
		CouncilAgenda councilAgenda = CouncilAgendaManager.getNextCouncilAgenda();
		System.out.println(councilAgenda);
		councilAgenda.getPDFFileLink();
		
		// Now start to load the file remotely
    	Collection<PDFTextNode> textNodes = CouncilAgendaManager.getPDFTextNodesForAgenda(councilAgenda);
    	for (Iterator<PDFTextNode> iterator = textNodes.iterator(); iterator.hasNext();) {
    		// How to navigate on the node
			PDFTextNode pdfTextNode = (PDFTextNode) iterator.next();
			System.out.println("Done");
			
//			System.out.println(pdfTextNode);
			// This will print somehting like
//			Keyword = Agreement
//			Text Chunk = From page: 128 => You will be contacted by a ministry regional advisor regarding funding and next steps, including the signing of a Contribution Agreement. All my best,  
		}
	}

}
