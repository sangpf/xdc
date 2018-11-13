package com.newins.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.dao.NiMessageboardDao;
import com.newins.model.NiMessageboardModel;
import com.newins.service.NiMessageboardService;

/**
 * @Description 留言建议
 * @author 星仔
 * @time 2017年2月24日上午10:47:02
 */
@Service("niMessageboardService")
public class NiMessageServiceImp implements NiMessageboardService {
	
	@Autowired
	private NiMessageboardDao niMessageboardDao;
	public NiMessageboardDao getNiMessageboardDao() {
		return niMessageboardDao;
	}

	public void setNiMessageboardDao(NiMessageboardDao niMessageboardDao) {
		this.niMessageboardDao = niMessageboardDao;
	}


	@Override
	public int useAddNiMessageboard(NiMessageboardModel niMessageboard) {
		//调用Dao层方法
		int num = niMessageboardDao.addNiMessageboard(niMessageboard);
		if (num==1) {			
			return num;
		}else {
			return 0;
		}
		
	}

}
