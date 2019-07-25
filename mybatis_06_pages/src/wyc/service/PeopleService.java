package wyc.service;

import java.io.IOException;

import wyc.pojo.PageInfo;

/**
 * 人的Service
 * @author Yicheng Wang
 */
public interface PeopleService {
	
	/**
	 * 分页显示
	 * @param pageSize
	 * @param pageNumber
	 * @return
	 */
	PageInfo showPage(int pageSize,int pageNumber) throws IOException;
	
}
