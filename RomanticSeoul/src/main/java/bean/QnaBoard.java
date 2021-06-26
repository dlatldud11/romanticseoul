package bean;

import org.springframework.web.multipart.MultipartFile;

public class QnaBoard {
	private int qnaseq;
	private String id;
	private String title;
	private String content;
	private String regdate;
	private String checks;
	private String recontent; // 답변
	private String reregdate; // 답변작성일자
	private String remark;
	private String image;
	private MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;

		if (this.file != null) {
			this.image = this.file.getOriginalFilename();
		}
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "QnaBoard [qnaseq=" + qnaseq + ", id=" + id + ", title=" + title + ", content=" + content + ", regdate="
				+ regdate + ", checks=" + checks + ", recontent=" + recontent + ", reregdate=" + reregdate + ", remark="
				+ remark + ", image=" + image + ", file=" + file + "]";
	}
	
	
}
