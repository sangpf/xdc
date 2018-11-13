package com.newins.service.imp;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.newins.controller.UpdateAwardGetStatusController;
import com.newins.dao.UpdateAwardGetStatusMapper;
import com.newins.service.UpdateAwardGetStatusService;

/**@Description  
 * @author MaNia_chAng
 * @time 2016年8月20日 上午11:06:23
 */
@Service
public class UpdateAwardGetStatusServiceImp implements UpdateAwardGetStatusService{
	
	
	private static Logger log = Logger.getLogger(UpdateAwardGetStatusController.class);
	
	@Resource
	private UpdateAwardGetStatusMapper updateAwardGetStatusMapper;
	
	public int updateAwardGetAndPayStatus(int userId,int qnId,int qnType,int awardGetStatus,int awardPayStatus){
		log.info("This is service: updateAwardGetAndPayStatus");
		Map<String, Object> retMap = new HashMap<String, Object>();
		retMap.put("userId", userId);
		retMap.put("qnId", qnId);
		retMap.put("qnType", qnType);
		retMap.put("awardGetStatus", awardGetStatus);
		retMap.put("awardPayStatus", awardPayStatus);
		int updateAwardGetAndPayStatus = updateAwardGetStatusMapper.updateAwardGetAndPayStatus(retMap);
		return updateAwardGetAndPayStatus;
	}

}
