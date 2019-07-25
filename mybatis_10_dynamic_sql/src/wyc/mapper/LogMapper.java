package wyc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import wyc.pojo.Log;

public interface LogMapper {
	
	/**
	 * 根据转入账户查询
	 * @param accout
	 * @param accin
	 * @return
	 */
	List<Log> selByAccinAccout(@Param("accout") String accout, @Param("accin") String accin);

	/**
	 * 更新日志
	 * @param log
	 * @return
	 */
	int upd(Log log);

	/**
	 * 根据日志查询
	 * @param log
	 * @return
	 */
	List<Log> selByLog(Log log);

	/**
	 * 查询转入日志
	 * @param list
	 * @return
	 */
	List<Log> selIn(List<Integer> list);

	/**
	 * 插入数字
	 * @param list
	 * @return
	 */
	int ins(List<Integer> list);
	
}
