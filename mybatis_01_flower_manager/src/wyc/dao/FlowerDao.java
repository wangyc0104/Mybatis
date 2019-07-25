package wyc.dao;

import java.util.List;

import wyc.pojo.Flower;

/**
 * 数据库访问接口
 * @author Yicheng Wang
 */
public interface FlowerDao {
	
	/**
	 * 查询全部
	 * @return
	 */
	List<Flower> selAll();
	
	/**
	 * 新增
	 * @param flower
	 * @return
	 */
	int insFlower(Flower flower);
	
}
