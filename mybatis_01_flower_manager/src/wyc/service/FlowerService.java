package wyc.service;

import java.util.List;

import wyc.pojo.Flower;

/**
 * 花儿的Service
 * @author Yicheng Wang
 */
public interface FlowerService {
	
	/**
	 * 显示所有花卉信息
	 * @return
	 */
	List<Flower> show();
	
	/**
	 * 新增
	 * @param flower
	 * @return
	 */
	int add(Flower flower);
	
}
