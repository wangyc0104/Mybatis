package wyc.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import wyc.pojo.People;
import wyc.service.PeopleService;

/**
 * 人的Service接口实现类 <br>
 * 注意：在DAO或Controller层处理异常，Service层中只抛出异常 <br>
 * @author Yicheng Wang
 */
public class PeopleServiceImpl implements PeopleService {

	@Override
	public List<People> show() throws IOException {
		// 构建者设计模式（意义: 简化对象实例化过程）
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		List<People> list = session.selectList("wyc.mapper.PeopleMapper.selAll");
		session.close();
		return list;
	}

}
