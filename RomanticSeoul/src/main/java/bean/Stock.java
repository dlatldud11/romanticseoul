package bean;

public class Stock {
	private int qtyseq;
	private int qty;
	private int coseq;
	private String remark;
	private String starts;
	private String ends;
	/**
	 * @return the qtyseq
	 */
	public int getQtyseq() {
		return qtyseq;
	}
	/**
	 * @param qtyseq the qtyseq to set
	 */
	public void setQtyseq(int qtyseq) {
		this.qtyseq = qtyseq;
	}
	/**
	 * @return the qty
	 */
	public int getQty() {
		return qty;
	}
	/**
	 * @param qty the qty to set
	 */
	public void setQty(int qty) {
		this.qty = qty;
	}
	/**
	 * @return the coseq
	 */
	public int getCoseq() {
		return coseq;
	}
	/**
	 * @param coseq the coseq to set
	 */
	public void setCoseq(int coseq) {
		this.coseq = coseq;
	}
	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * @return the starts
	 */
	public String getStarts() {
		return starts;
	}
	/**
	 * @param starts the starts to set
	 */
	public void setStarts(String starts) {
		this.starts = starts;
	}
	/**
	 * @return the ends
	 */
	public String getEnds() {
		return ends;
	}
	/**
	 * @param ends the ends to set
	 */
	public void setEnds(String ends) {
		this.ends = ends;
	}
	@Override
	public String toString() {
		return "Stock [qtyseq=" + qtyseq + ", qty=" + qty + ", coseq=" + coseq + ", remark=" + remark + ", starts="
				+ starts + ", ends=" + ends + "]";
	}
	
	
}
