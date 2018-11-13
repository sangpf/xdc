package com.newins.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.newcapec.campus.oauth2.client.request.UserContext;

public interface NiUserIdentiferService {
	
//    List<NiUserIdentifer> selectList(NiUserIdentifer record);
    
    //更新用户信息
    void updateUserInfo(String detailUserInfo,HttpSession session);
    
    //拿到玩校userid 查询用户信息标识表, 更新匹配数据
    int mapUser(String detailUserInfo,UserContext userContext,HttpSession newSession,HttpServletRequest request);
    
}
