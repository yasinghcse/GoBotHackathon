package hackathon.gobot.pdf;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
    	
		String pageHeader = "Page:" + pageNumber + " - ";
    	// Tokenizing the page  into lines
		for (int line = 0; line < pageLines.length; line++) {
			String chunkText = "";
			// First Line
			if (line == 0) {
				chunkText =  pageLines[0];
				if (pageLines.length >= 2) {
					chunkText =  chunkText + " " + pageLines[1];
				}
				if (pageLines.length >= 3) {
					chunkText =  chunkText + " " + pageLines[2];
				}				
				// Last line of the page
			}  else if (line == pageLines.length - 1) {
				chunkText =  pageLines[pageLines.length-1];
				if (pageLines.length-2 >= 0) {
					chunkText =  pageLines[pageLines.length-2] + " " + chunkText;
				}
				if (pageLines.length-3 >= 0) {
					chunkText =  pageLines[pageLines.length-3] + " " + chunkText;
				}
				// Somewhere in the middle of the page				
			} else if (line > 0) {
				chunkText =  pageLines[line - 1] + pageLines[line] + pageLines[line + 1];
			}
			
			String cleanLine = pageLines[line].replaceAll("[+.^:,?;!�()//]","");
			String lineWords[] = cleanLine.split(" ");
			for (int word = 0; word < lineWords.length; word++) {
				String keyWord = lineWords[word];
				String chunkTextAdjusted = chunkText; 
				int position = chunkTextAdjusted.indexOf(keyWord);
	
				if (chunkTextAdjusted.length() > 90) {
					if (position >= 0 && position <= 30) {
						// In this case word is more in the beggining of the chunk
						chunkTextAdjusted = chunkTextAdjusted.substring(0,89);
					} else if ((position + keyWord.length()) >  chunkTextAdjusted.length() - 30) {
						// In this case word is more in the end of the chunk
						int initialIndex = chunkTextAdjusted.length()-101;
						if (initialIndex < 0) {
							initialIndex = 0;
						}
						chunkTextAdjusted = chunkTextAdjusted.substring(initialIndex,chunkTextAdjusted.length()-1);
					} else {
						int initialIndex = position - 30;
						int finalIndex = position + keyWord.length() + 30;
						if (initialIndex < 0) {
							initialIndex = 0;
						}
						if (finalIndex > chunkTextAdjusted.length() - 1) {
							finalIndex = chunkTextAdjusted.length() - 1;
						}
						chunkTextAdjusted = chunkTextAdjusted.substring(initialIndex,finalIndex);
					}
				}
				
				chunkTextAdjusted = pageHeader + chunkTextAdjusted;
				textNode = new PDFTextNode(keyWord.toLowerCase(), chunkTextAdjusted);
//				System.out.println("Keyword = " + lineWords[word]);	
//				System.out.println("Text Chunk = " + chunkTextAdjusted);
//				System.out.println("Chunk Size = " + chunkTextAdjusted.length());
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
    	Collection<PDFTextNode> collection =  pdfParser.parse();
    	for (Iterator iterator = collection.iterator(); iterator.hasNext();) {
			PDFTextNode pdfTextNode = (PDFTextNode) iterator.next();
			System.out.println("Keyword = " + pdfTextNode.getKeyWord());	
			System.out.println("Text Chunk = " + pdfTextNode.getTextChunk());
			System.out.println("Chunk Size = " + pdfTextNode.getTextChunk().length());
			System.out.println("-------------------");
		}
    	
	}
	
}
