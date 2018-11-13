package com.newins.service.imp;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.newins.dao.ThumbUpAndDownMapper;
import com.newins.service.ThumbUpAndDownService;

/**@Description  
 * @author MaNia_chAng
 * @time 2016年8月29日 下午4:39:56
 */
@Service
public class ThumbUpAndDownServiceImp implements ThumbUpAndDownService{
	private static Logger log = Logger.getLogger(ThumbUpAndDownServiceImp.class);
	@Resource
	private ThumbUpAndDownMapper thumbUpAndDownMapper;
	
	public void updateThumbUpAndDown(Map<String, Object> hashMap) {
		thumbUpAndDownMapper.updateThumbUpAndDown(hashMap);
	}
	

}
