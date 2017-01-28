package hackathon.gobot.pdf;


public class CouncilAgenda {
	
	private String agendaDate;
	
	private String pdfFileLink;

	public CouncilAgenda(String agendaDate, String linkToPDf) {
		this.agendaDate = agendaDate;
		this.pdfFileLink = linkToPDf;
	}
	
	public String getAgendaDate() {
		return agendaDate;
	}
	
	public String getPDFFileLink() {
		return pdfFileLink;
	}	
	
	public String toString() {
		return "Agenda Held on: " + agendaDate + System.getProperty("line.separator") + "Link to Agenda in PDF at: " + pdfFileLink;
	}
}
