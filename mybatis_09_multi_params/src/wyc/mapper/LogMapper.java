package wyc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import wyc.pojo.Log;

/**
 * 日志Mapper
 * @author Yicheng Wang
 */
public interface LogMapper {

	/**
	 * 查询所有
	 * @return
	 */
	List<Log> selAll();

	/**
	 * 根据条件查询
	 * mybatis把参数转换为map了,其中@Param("key")参数内容就是map的value
	 * @param 随你写什么都行
	 * @param 随你写什么都可以
	 * @return
	 */
	List<Log> selByAccInAccout(@Param("accin") String 随你写什么都行, @Param("accout") String 随你写什么都可以);

}
