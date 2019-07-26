package wyc.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import wyc.pojo.Log;
import wyc.pojo.PageInfo;
import wyc.service.LogService;

/**
 * 账户日志Service接口实现类
 * @author Yicheng Wang
 */
public class LogServiceImpl implements LogService {

	@Override
	public PageInfo showPage(int pageSize, int pageNumber) throws IOException {
		// 初始化Session
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		// 分页查询
		Map<String, Object> param = new HashMap<>();
		param.put("pageStart", pageSize * (pageNumber - 1));
		param.put("pageSize", pageSize);
		List<Log> list = session.selectList("wyc.mapper.LogMapper.selByPage", param);
		long count = session.selectOne("wyc.mapper.LogMapper.selCount");
		PageInfo pi = new PageInfo();
		pi.setList(list);
		pi.setPageNumber(pageNumber);
		pi.setPageSize(pageSize);
		pi.setTotal(count % pageSize == 0 ? count/ pageSize : count/ pageSize + 1);
		return pi;
	}

}
