package bean;
// 자유게시판과 코스후기 댓글 같이 사용하는 빈
public class Reply {
	private int replyseq; // 댓글 시퀀스
	private int boseq; // 게시판 글 시퀀스
	private String id; //댓글 작성자
	private String rid;//대댓글 작성자
	private int likes;
	private String content;
	private String regdate;
	private int groupno;
	private int depth;
	private int orderno;
	private String remark;
	private String nickname; //댓글 작성자 닉네임
	
	public Reply() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "Reply [replyseq=" + replyseq + ", boseq=" + boseq + ", id=" + id + ", rid=" + rid + ", likes=" + likes
				+ ", content=" + content + ", regdate=" + regdate + ", groupno=" + groupno + ", depth=" + depth
				+ ", orderno=" + orderno + ", remark=" + remark + ", nickname=" + nickname + "]";
	}


	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getReplyseq() {
		return replyseq;
	}
	public void setReplyseq(int replyseq) {
		this.replyseq = replyseq;
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
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
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
	public int getGroupno() {
		return groupno;
	}
	public void setGroupno(int groupno) {
		this.groupno = groupno;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getOrderno() {
		return orderno;
	}
	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
