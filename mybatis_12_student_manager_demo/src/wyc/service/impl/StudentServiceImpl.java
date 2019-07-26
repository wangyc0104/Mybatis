package wyc.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import wyc.mapper.StudentMapper;
import wyc.mapper.TeacherMapper;
import wyc.pojo.PageInfo;
import wyc.pojo.Student;
import wyc.service.StudentService;
import wyc.util.MyBatisUtil;

/**
 * 学生Service接口实现类
 * @author Yicheng Wang
 */
public class StudentServiceImpl implements StudentService {

	@Override
	public PageInfo showPage(String sname, String tname, String pageSizeStr, String pageNumberStr) {
		// 默认分页设置
		int pageSize = 2;
		if (pageSizeStr != null && !pageSizeStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		int pageNumber = 1;
		if (pageNumberStr != null && !pageNumberStr.equals("")) {
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		
		// 根据分页信息查询学生
		SqlSession session = MyBatisUtil.getSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);

		PageInfo pi = new PageInfo();
		pi.setPageNumber(pageNumber);
		pi.setPageSize(pageSize);
		pi.setPageStart((pageNumber - 1) * pageSize);
		pi.setTname(tname);
		pi.setSname(sname);

		List<Student> list = studentMapper.selByPage(pi);
		
		// 查询出每个学生对应的老师信息
		TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
		for (Student student : list) {
			student.setTeacher(teacherMapper.selById(student.getTid()));
		}
		pi.setList(list);
		long count = studentMapper.selCountByPageInfo(pi);

		pi.setTotal(count % pageSize == 0 ? count/ pageSize : count/ pageSize + 1);

		return pi;
	}

}
