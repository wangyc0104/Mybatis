package wyc.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import wyc.pojo.PageInfo;
import wyc.service.PeopleService;

/**
 * 人的Service接口实现类
 * @author Yicheng Wang
 */
public class PeopleServiceImpl implements PeopleService {

	@Override
	public PageInfo showPage(int pageSize, int pageNumber) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		
		// 处理分页，查询参数为map类型
		PageInfo pi = new PageInfo();
		pi.setPageNumber(pageNumber);
		pi.setPageSize(pageSize);
		Map<String, Object> map = new HashMap<>();
		map.put("pageStart", pageSize * (pageNumber - 1));
		map.put("pageSize", pageSize);
		pi.setList(session.selectList("wyc.mapper.PeopleMapper.selByPage", map));
		
		// 查询所有数据的总条数，然后基于此计算页码
		long count = session.selectOne("wyc.mapper.PeopleMapper.selCount");
		pi.setTotal(count % pageSize == 0 ? count/ pageSize : count/ pageSize + 1);
		
		return pi;
	}

}
