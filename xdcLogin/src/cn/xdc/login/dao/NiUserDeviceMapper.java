package cn.xdc.login.dao;

import cn.xdc.login.po.NiUserDevice;


public interface NiUserDeviceMapper {

    int deleteByPrimaryKey(Integer userid);

    int insert(NiUserDevice record);

    int insertSelective(NiUserDevice record);

    NiUserDevice selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(NiUserDevice record);

    int updateByPrimaryKey(NiUserDevice record);
    
}