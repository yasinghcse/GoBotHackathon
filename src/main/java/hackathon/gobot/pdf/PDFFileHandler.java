package hackathon.gobot.pdf;



import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessBufferedFileInputStream;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 * This is an example on how to parse all text from PDF document.
 *
 * @author Clovis Nogueira
 * @author Yadi
 */
public class PDFFileHandler
{
	
	   private PDFParser parser;
	   private PDFTextStripper pdfStripper; 
	   private PDDocument pdDoc ;
	   private COSDocument cosDoc ;
	   private File pdfFile;
	   private boolean isHttpURL = false;
	   private InputStream pdfFileInputStream;
	   

	   /**
	    * 
	    * 
	    * @throws IOException
	    */
	   public PDFFileHandler(String filePath, boolean isHttpURL) throws IOException {
		   this.isHttpURL = isHttpURL;  
		   if (isHttpURL == false) {
		    	pdfFile = new File(filePath);
		        parser = new PDFParser(new RandomAccessFile(pdfFile,"r")); // update for PDFBox V 2.0
		        parser.parse();
		        cosDoc = parser.getDocument();
		        pdfStripper = new PDFTextStripper();
		        pdDoc = new PDDocument(cosDoc);
		   } else {
			   //Tricky here.....
			   // Is the file has spaces need to replace them for %20 in order to the HTTP Server to respond properly
			   	String newPath = filePath.replaceAll("[ ]", "%20");
			   
		        URL myURL = new URL(newPath);
		        HttpURLConnection connection = (HttpURLConnection) myURL.openConnection();
		        connection.setRequestMethod("GET");
		        connection.setDoOutput(true);
		        connection.connect();
	        
				pdfFileInputStream = connection.getInputStream();
				RandomAccessBufferedFileInputStream randomStreamFile = new RandomAccessBufferedFileInputStream(pdfFileInputStream);
				parser = new PDFParser(randomStreamFile); // update for PDFBox V 2.0
		        parser.parse();
		        cosDoc = parser.getDocument();
		        pdfStripper = new PDFTextStripper();
		        pdDoc = new PDDocument(cosDoc);
				pdfFileInputStream.close();
				
		   }
	    }

	   
	   /**
	    * 
	    *  
	    * @param page
	    * @return
	    * @throws IOException
	    */
	   public String toTextPage(int page) throws IOException {
	       pdfStripper.setStartPage(page);
	       pdfStripper.setEndPage(page);
	       return pdfStripper.getText(pdDoc);
	   }

	    /**
	     *
	     * 
	     * @return
	     */
	    public int getTotalPages() {
	    	return pdDoc.getNumberOfPages();
	    }
	    
	    public static void main(String[] args) throws IOException {

//	    	PDFFileHandler pdfManager = new PDFFileHandler("D://publicagendafeb62017withitemspagenumbers.pdf");
	    	PDFFileHandler pdfManager = new PDFFileHandler("http://www.citywindsor.ca/cityhall/City-Council-Meetings/Meetings-This-Week/Documents/public agenda feb 6 2017 with items page numbers.pdf", true);
	    	
	    	int total = pdfManager.getTotalPages();
	    	for (int page = 1; page <= total; page++) {
	    		System.out.println("Page " + page);
	    		System.out.println(pdfManager.toTextPage(1));
	    		System.out.println("################################################");
			}
		}
  
}

