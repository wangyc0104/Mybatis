package wyc.service;

import wyc.pojo.PageInfo;

/**
 * 学生Service
 * @author Yicheng Wang
 */
public interface StudentService {
	
	/**
	 * 展示页面
	 * @param sname 学生姓名
	 * @param tname 老师姓名
	 * @param pageSize 每页显示条数
	 * @param pageNumber 页码数
	 * @return
	 */
	PageInfo showPage(String sname, String tname, String pageSize, String pageNumber);
	
}
