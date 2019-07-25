package wyc.service;

import java.io.IOException;

import wyc.pojo.PageInfo;

/**
 * 账户日志Service
 * @author Yicheng Wang
 */
public interface LogService  {
	
	/**
	 * 分页显示账户日志
	 * @param pageSize
	 * @param pageNumber
	 * @return
	 */
	PageInfo showPage(int pageSize,int pageNumber) throws IOException;
	
}
