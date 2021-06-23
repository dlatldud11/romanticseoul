package bean;

public class S_reviewBoard extends Board {
	private int revseq; //리뷰 시퀀스
	private int storeseq;//가게 시퀀스
	private String id;
	private int grade; //점수
	private int likes; //좋아요

	
	@Override
	public String toString() {
		return super.toString()+ "S_reviewsBoard [revseq=" + revseq + ", storeseq=" + storeseq + ", id=" + id + ", grade=" + grade
				+ ", likes=" + likes + "]";
	}

	public S_reviewBoard() {
		// TODO Auto-generated constructor stub
	}
	
	public int getRevseq() {
		return revseq;
	}
	public void setRevseq(int revseq) {
		this.revseq = revseq;
	}
	public int getStoreseq() {
		return storeseq;
	}
	public void setStoreseq(int storeseq) {
		this.storeseq = storeseq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	
	
}
