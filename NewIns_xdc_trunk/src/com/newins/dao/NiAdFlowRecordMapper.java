package com.newins.dao;

import com.newins.model.NiAdFlowRecord;

/**
 * @author lj
 * @Description : 广告流水表对应的dao
 * @time : 2016年7月28日 下午7:44:12
 */
public interface NiAdFlowRecordMapper {
	

	/**
	 * @author lj
	 * @Description : 记录一条广告流水
	 * @time : 2016年7月28日 下午7:49:27
	 * @param niAdFlowRecord
	 * @return int
	 */
	public int insertAdFlowRecord(NiAdFlowRecord niAdFlowRecord);
}
