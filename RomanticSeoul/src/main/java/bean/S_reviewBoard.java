package bean;

public class S_reviewBoard extends Board {
	private int revseq;
	private int storeseq;
	private String id;
	private String regdate;
	private String content;
	private int grade;
	private String remark;
	private int likes;
	private String image;
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
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "S_reviewBoard [revseq=" + revseq + ", storeseq=" + storeseq + ", id=" + id + ", regdate=" + regdate
				+ ", content=" + content + ", grade=" + grade + ", remark=" + remark + ", likes=" + likes + ", image="
				+ image + "]";
	}
	
	
	
}
