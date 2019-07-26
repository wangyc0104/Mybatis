package wyc.mapper;

import wyc.pojo.Teacher;

/**
 * 老师Mapper
 * @author Yicheng Wang
 */
public interface TeacherMapper {
	
	/**
	 * 根据id查询老师
	 * @param id
	 * @return
	 */
	Teacher selById(int id);
	
}
