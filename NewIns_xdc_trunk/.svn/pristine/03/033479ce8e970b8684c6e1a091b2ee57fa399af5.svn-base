package com.newins.dao;

import com.newins.model.NiUserDevice;
import com.newins.model.NiUserDeviceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NiUserDeviceMapper {
    int countByExample(NiUserDeviceExample example);

    int deleteByExample(NiUserDeviceExample example);

    int deleteByPrimaryKey(Integer userid);

    int insert(NiUserDevice record);

    int insertSelective(NiUserDevice record);

    List<NiUserDevice> selectByExample(NiUserDeviceExample example);

    NiUserDevice selectByPrimaryKey(Integer userid);

    int updateByExampleSelective(@Param("record") NiUserDevice record, @Param("example") NiUserDeviceExample example);

    int updateByExample(@Param("record") NiUserDevice record, @Param("example") NiUserDeviceExample example);

    int updateByPrimaryKeySelective(NiUserDevice record);

    int updateByPrimaryKey(NiUserDevice record);
}