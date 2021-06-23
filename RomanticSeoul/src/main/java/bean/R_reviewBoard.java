package bean;

public class R_reviewBoard extends Board {
	private int revseq; //코스 리뷰 시퀀스
	private int resseq;// 예약 시퀀스
	private String id;
	private int grade; // 점수
	private String title;
	private int readhit;
	private int likes;
	
	@Override
	public String toString() {
		return super.toString()+ "R_reviewsBoard [revseq=" + revseq + ", resseq=" + resseq + ", id=" + id + ", grade=" + grade
				+ ", title=" + title + ", readhit=" + readhit + ", likes=" + likes + "]";
	}

	public R_reviewBoard() {
		// TODO Auto-generated constructor stub
	}
	
	public int getRevseq() {
		return revseq;
	}
	public void setRevseq(int revseq) {
		this.revseq = revseq;
	}
	public int getResseq() {
		return resseq;
	}
	public void setResseq(int resseq) {
		this.resseq = resseq;
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
