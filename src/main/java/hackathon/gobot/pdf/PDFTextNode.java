package hackathon.gobot.pdf;



public class PDFTextNode {

	private String keyWord;
	private String textChunk;
	
	public PDFTextNode(String keyWord, String textChunk) {
		this.keyWord = keyWord;
		this.textChunk = textChunk;
	}
	
	public String getKeyWord() {
		return this.keyWord;
	}
	
	public String getTextChunk() {
		return this.textChunk;
	}
	
	public String toString() {
		return "Keyword = " + this.keyWord + System.getProperty("line.separator") + "Text Chunk = " + this.textChunk;
	}
	


}
