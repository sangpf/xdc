package com.newins.service;

import com.newins.model.NiAdFlowRecord;

/**
 * @author lj
 * @Description : 广告流水表的Service接口
 * @time : 2016年7月28日 下午7:52:15
 */
public interface NiAdFlowRecordService {


	/**
	 * @author lj
	 * @Description : 记录一条广告流水表
	 * @time : 2016年7月28日 下午7:56:45
	 * @param niAdFlowRecord
	 * @return int
	 */
	public int insertAdFlowRecord(NiAdFlowRecord niAdFlowRecord);
}
