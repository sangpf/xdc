package com.newins.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.dao.NiAdFlowRecordMapper;
import com.newins.model.NiAdFlowRecord;
import com.newins.service.NiAdFlowRecordService;


/**
 * @author lj
 * @Description : 广告流水表的Service实现类
 * @time : 2016年7月28日 下午7:58:29
 */
@Service
public class NiAdFlowRecordServiceImp implements NiAdFlowRecordService {

	@Autowired
	private NiAdFlowRecordMapper niAdFlowRecordMapper;
	
	/**

	 */
	/**
	 * @author lj
	 * @Description : 插入一条广告流水记录
	 * @time : 2016年7月28日 下午8:01:06
	 * @param NiAdFlowRecord
	 * @return int
	 */
	public int insertAdFlowRecord(NiAdFlowRecord niAdFlowRecord) {
		// TODO Auto-generated method stub
		int insertAdRecord=niAdFlowRecordMapper.insertAdFlowRecord(niAdFlowRecord);
		return insertAdRecord;
	}

}
