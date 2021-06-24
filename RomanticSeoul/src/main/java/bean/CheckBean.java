package bean;

public class CheckBean {
	private String mykey;
	private int myvalues;
	private String module;
	private String remark;

	@Override
	public String toString() {
		return "CheckBean [mykey=" + mykey + ", myvalues=" + myvalues + ", module=" + module + ", remark=" + remark
				+ "]";
	}

	public CheckBean() {
	}
	
	public String getMykey() {
		return mykey;
	}
	public void setMykey(String mykey) {
		this.mykey = mykey;
	}
	public int getMyvalues() {
		return myvalues;
	}
	public void setMyvalues(int myvalues) {
		this.myvalues = myvalues;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
