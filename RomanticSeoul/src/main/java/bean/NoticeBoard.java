package bean;

public class NoticeBoard extends Board {
	private int boseq;
	private String title;
	private int readhit;
	
	public NoticeBoard() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return super.toString()+"NoticeBoard [boseq=" + boseq + ", title=" + title + ", readhit=" + readhit + "]";
	}
	
	public int getBoseq() {
		return boseq;
	}
	public void setBoseq(int boseq) {
		this.boseq = boseq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getReadhit() {
		return readhit;
	}
	public void setReadhit(int readhit) {
		this.readhit = readhit;
	}
	
}
