package wyc.mapper;

import java.util.List;

import wyc.pojo.PageInfo;
import wyc.pojo.Student;

/**
 * 学生Mapper
 * @author Yicheng Wang
 */
public interface StudentMapper {
	
	/**
	 * 分页查询学生列表
	 * @param pi
	 * @return
	 */
	List<Student> selByPage(PageInfo pi);

	/**
	 * 查询条目数
	 * @param pi
	 * @return
	 */
	long selCountByPageInfo(PageInfo pi);
	
}
