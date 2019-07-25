package wyc.service;

import java.io.IOException;
import java.util.List;

import wyc.pojo.People;

/**
 * 人的service（听起来怪怪的……）
 * @author Yicheng Wang
 */
public interface PeopleService {
	
	/**
	 * 显示全部的人
	 * @return
	 */
	List<People> show()  throws IOException;
	
}
