package wyc.service.impl;

import org.apache.ibatis.session.SqlSession;

import wyc.mapper.LogMapper;
import wyc.pojo.Log;
import wyc.service.LogService;
import wyc.util.MyBatisUtil;

public class LogServiceImpl implements LogService {

	@Override
	public int ins(Log log) {
		SqlSession session = MyBatisUtil.getSession();
		LogMapper mapper = session.getMapper(LogMapper.class);
		return mapper.ins(log);
	}

}
