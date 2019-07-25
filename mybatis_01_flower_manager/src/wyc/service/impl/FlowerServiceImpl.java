package wyc.service.impl;

import java.util.List;

import wyc.dao.FlowerDao;
import wyc.dao.impl.FlowerDaoImpl;
import wyc.pojo.Flower;
import wyc.service.FlowerService;

/**
 * Service接口实现类
 * @author Yicheng Wang
 */
public class FlowerServiceImpl implements FlowerService {
	
	private FlowerDao flowerDao = new FlowerDaoImpl();

	@Override
	public List<Flower> show() {
		return flowerDao.selAll();
	}

	@Override
	public int add(Flower flower) {
		return flowerDao.insFlower(flower);
	}

}
