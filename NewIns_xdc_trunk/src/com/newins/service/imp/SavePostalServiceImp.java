package com.newins.service.imp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newins.dao.SavePostalMapper;
import com.newins.model.Postal;
import com.newins.service.SavePostalService;

/**@Description  
 * @author MaNia_chAng
 * @time 2016年7月21日 下午2:22:42
 */
@Service
public class SavePostalServiceImp implements SavePostalService{
	
	/**
	 * 保存实物奖励邮寄信息
	 */
	@Resource
	private SavePostalMapper savePostalMapper;
	public int savePostal(Postal postal){
		int savePostal = 0;
		savePostal = savePostalMapper.savePostal(postal);			
		return savePostal;		
	}
	

}
