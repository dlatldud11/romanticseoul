package bean;

public class BoardBoard extends Board {
	private int boseq;
	private String id;
	private String title;
	private int readhit;
	private int likes;
	
	@Override
	public String toString() {
		return super.toString()+"BoardBoard [boseq=" + boseq + ", id=" + id + ", title=" + title + ", readhit=" + readhit + ", likes="
				+ likes + "]";
	}

	public BoardBoard() {
		// TODO Auto-generated constructor stub
	}
	
	public int getBoseq() {
		return boseq;
	}
	public void setBoseq(int boseq) {
		this.boseq = boseq;
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
	public int getReadhit() {
		return readhit;
	}
	public void setReadhit(int readhit) {
		this.readhit = readhit;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	
	
}
