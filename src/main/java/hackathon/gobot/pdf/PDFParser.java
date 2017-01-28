package hackathon.gobot.pdf;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class PDFParser {
	
	private PDFFileHandler pdfHandler;

	public PDFParser(PDFFileHandler pdfHandler) {
		this.pdfHandler = pdfHandler;
	}
	
	/**
	 * 
	 * 
	 * @return
	 * @throws IOException
	 */
	public Collection<PDFTextNode> parse() throws IOException {
		Collection<PDFTextNode> textNodes = new LinkedList<PDFTextNode>(); 
		int total = pdfHandler.getTotalPages();
    	for (int page = 1; page <= total; page++) {
    		String fullPage = pdfHandler.toTextPage(page);
    		textNodes.addAll(parsePage(page,fullPage));
    	}
		return textNodes;
	}
	
	/**
	 * 
	 * 
	 * @param pageNumber
	 * @param pageText
	 * @return
	 */
	public Collection<PDFTextNode> parsePage(int pageNumber, String pageText) {
		LinkedList<PDFTextNode> textNodes = new LinkedList<PDFTextNode>();
		String pageLines[] = pageText.split("\\r?\\n");
		PDFTextNode textNode = null;
    	
		String pageHeader = "From page: " + pageNumber + " => ";
    	// Tokenizing the page  into lines
		for (int line = 0; line < pageLines.length; line++) {
			String chunkText = null;
			// First Line
			if (line == 0) {
				chunkText =  pageHeader + pageLines[0];
				if (pageLines.length >= 2) {
					chunkText =  chunkText + " " + pageLines[1];
				}
				if (pageLines.length >= 3) {
					chunkText =  chunkText + " " + pageLines[2];
				}				
				// Last line of the page
			}  else if (line == pageLines.length - 1) {
				chunkText =  pageHeader + pageLines[pageLines.length-1];
				if (pageLines.length-2 >= 0) {
					chunkText =  pageLines[pageLines.length-2] + " " + chunkText;
				}
				if (pageLines.length-3 >= 0) {
					chunkText =  pageLines[pageLines.length-3] + " " + chunkText;
				}
				// Somewhere in the middle of the page				
			} else if (line > 0) {
				chunkText =  pageHeader + pageLines[line - 1] + pageLines[line] + pageLines[line + 1];
			}
			
			String cleanLine = pageLines[line].replaceAll("[+.^:,?;!�()//]","");
			String lineWords[] = cleanLine.split(" ");
			for (int word = 0; word < lineWords.length; word++) {
				textNode = new PDFTextNode(lineWords[word], chunkText);
//				System.out.println("Keyword = " + lineWords[word]);	
//				System.out.println("Text Chunk = " + chunkText);
//				System.out.println("-------------------");
				textNodes.add(textNode);
			}
		}
		return textNodes;
	}
	
	/**
	 * 
	 * 
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
    	PDFFileHandler pdfManager = new PDFFileHandler("D://publicagendafeb62017withitemspagenumbers.pdf", false);
    	int total = pdfManager.getTotalPages();
    	PDFParser pdfParser = new PDFParser(pdfManager);
    	pdfParser.parse();
	}
	
}
