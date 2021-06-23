package bean;

public class Board {
	private String content;
	private String regdate;
	private String image;
	private String remark;
	private String meimage; //프로필사진
	
	public Board() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Board [content=" + content + ", regdate=" + regdate + ", image=" + image + ", remark=" + remark
				+ ", meimage=" + meimage + "]";
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getMeimage() {
		return meimage;
	}

	public void setMeimage(String meimage) {
		this.meimage = meimage;
	}
	
	
}
