package bean;

public class QnaBoard extends Board {
	private int qnaseq;
	private String id;
	private String title;
	private String checks;
	private String regdate;
	private String recontent; //답변
	private String reregdate; //답변작성일자
	
	
	@Override
	public String toString() {
		return super.toString() +"QnaBoard [qnaseq=" + qnaseq + ", id=" + id + ", title=" + title + ", checks=" + checks + ", recontent="
				+ recontent + ", reregdate=" + reregdate + "]";
	}
	public QnaBoard() {
	}
	
	public int getQnaseq() {
		return qnaseq;
	}
	public void setQnaseq(int qnaseq) {
		this.qnaseq = qnaseq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getChecks() {
		return checks;
	}
	public void setChecks(String checks) {
		this.checks = checks;
	}
	public String getRecontent() {
		return recontent;
	}
	public void setRecontent(String recontent) {
		this.recontent = recontent;
	}
	public String getReregdate() {
		return reregdate;
	}
	public void setReregdate(String reregdate) {
		this.reregdate = reregdate;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
}
