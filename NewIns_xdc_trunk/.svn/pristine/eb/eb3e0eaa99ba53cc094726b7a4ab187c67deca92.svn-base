/**
 * 
 */
package com.newins.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.dao.LogPersonalInfoDao;
import com.newins.model.LogPersonalInfo;
import com.newins.service.LogPersonalInfoService;

/**@Description  
 * @author Guan
 * @time 2017年3月22日 上午11:20:56
 */
@Service
public class LogPersonalInfoServiceImp implements LogPersonalInfoService{
	@Autowired
	private LogPersonalInfoDao logPersonalInfoDao;
	public LogPersonalInfo getPersonalInfo(int userId){
		return logPersonalInfoDao.getLogPersonalInfo(userId);
	} 

}
