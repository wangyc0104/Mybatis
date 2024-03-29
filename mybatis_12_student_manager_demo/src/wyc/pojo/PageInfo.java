package wyc.pojo;

import java.util.List;

/**
 * 分页辅助对象
 * @author Yicheng Wang
 */
public class PageInfo {
	
	private int pageSize;
	private int pageNumber;
	private long total;
	private List<?> list;
	
	// 学生姓名
	private String sname;
	// 老师姓名
	private String tname;
	// 起始行
	private int pageStart;

	public int getPageStart() {
		return pageStart;
	}

	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	@Override
	public String toString() {
		return "PageInfo [pageSize=" + pageSize + ", pageNumber=" + pageNumber + ", total=" + total + ", list=" + list + ", sname=" + sname + ", tname=" + tname + ", pageStart=" + pageStart + "]";
	}
	
}
