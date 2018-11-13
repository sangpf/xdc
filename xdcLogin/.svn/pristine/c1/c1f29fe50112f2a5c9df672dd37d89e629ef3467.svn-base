package cn.xdc.login.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.newcapec.campus.oauth2.client.request.UserContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xdc.common.util.StrUtils;
import cn.xdc.login.dao.NiRegionDictMapper;
import cn.xdc.login.dao.NiSchoolDictMapper;
import cn.xdc.login.dao.NiUserBaseMapper;
import cn.xdc.login.dao.NiUserDeviceMapper;
import cn.xdc.login.dao.NiUserEduHistMapper;
import cn.xdc.login.dao.NiUserEducationMapper;
import cn.xdc.login.dao.NiUserIdentiferMapper;
import cn.xdc.login.dao.NiUserPostalMapper;
import cn.xdc.login.po.NiRegionDict;
import cn.xdc.login.po.NiSchoolDict;
import cn.xdc.login.po.NiUserBase;
import cn.xdc.login.po.NiUserEduHist;
import cn.xdc.login.po.NiUserEducation;
import cn.xdc.login.po.NiUserIdentifer;

import com.alibaba.fastjson.JSONObject;

@Service
public class NiUserIdentiferServiceImp implements NiUserIdentiferService{
	
	private static Logger log = Logger.getLogger(NiUserIdentiferServiceImp.class); 
	@Resource
	private NiUserIdentiferMapper niUserIdentiferMapper;
	@Resource
	private NiUserBaseMapper niUserBaseMapper;
	@Resource
	private NiUserPostalMapper niUserPostalMapper;
	@Resource
	private NiUserDeviceMapper niUserDeviceMapper;
	@Resource
	private NiUserEducationMapper niUserEducationMapper;
	@Resource
	private NiUserEduHistMapper niUserEduHistMapper;
	@Resource
	private NiSchoolDictMapper niSchoolDictMapper;
	@Resource
	private NiRegionDictMapper niRegionDictMapper;

	/**
	 * 根据玩校返回用户信息查询 用户标识表
	 */
	@Transactional
	public void updateUserInfo(String detailUserInfo,HttpSession session) {
		if(detailUserInfo!=null){
			//获取用户详细的信息
			JSONObject fromObject1 = JSONObject.parseObject(detailUserInfo);
			
			log.info("玩校返回的信息===========================>>"+fromObject1.toString());
			if(fromObject1.toString().contains("errorCode")){
				log.info("================>>当前登录用户我们无权限获取详细信息!!");
				
			}else{
				String sex = fromObject1.getString("sex");   //性别
				String stu_no = fromObject1.getString("stu_no");  //学号
				String school_name = (String) fromObject1.get("school_name");//学校名称
				Integer wanxUserid = fromObject1.getIntValue("userid");    
				boolean bind_ecard = fromObject1.getBoolean("bind_ecard");  //是否绑定一卡通
//				int school_id = fromObject1.getInt("school_id");//学校 id
				String name = fromObject1.getString("name");    //名称
//				String wanxOpenid = (String) fromObject1.get("openid");   //openid
				String mobile = fromObject1.getString("mobile");
				String nickname = fromObject1.getString("nickname");
				//将schoolId保存到session中
				session.setAttribute("schoolId",fromObject1.getIntValue("school_id"));
				//获取地区信息
				String cityId = "";
				Object city_Id = session.getAttribute("cityId");
				if(city_Id!=null){
					cityId = city_Id.toString();
				}
				//玩校city_id 即为地区信息表中的 regionCode 字段
				//根据 city_id 查询地区信息
				NiRegionDict niRegionDict = null;
				if(StrUtils.isNotEmpty(cityId)){
					niRegionDict = niRegionDictMapper.findByRegionCode(cityId);
				}
				
				//创建查询条件
				if(wanxUserid != null){
					
					//纪录未存到数据库
					Integer userid = null;
					String userId = "";
					//从session中获取新增的用户id
					Object attribute = session.getAttribute("userId");
					if(attribute!=null){
						userId = attribute.toString();
					}
					if(StrUtils.isNotEmpty(userId)){
						userid = Integer.valueOf(userId);
					}
					
					//如果userId 为null,用户标识信息表未创建  则不执行所有更新表操作
					if(userid!=null){
						//根据玩校userId查询用户标识表,因为新用户第一次登录的时候未同步玩校userId
						NiUserIdentifer niUserIdentifer = niUserIdentiferMapper.selectByWanxuserId(wanxUserid);
						//如果为null,说明是新增用户,将详细信息同步到数据库
						if(niUserIdentifer == null){
							log.info("==============>>新用户详细信息同步到用户库...");
							//从在校教育表取值
							NiSchoolDict selectByWanxSchoolName = niSchoolDictMapper.selectByWanxSchoolName(school_name);
							
							//更新用户标识信息表 玩校id
							NiUserIdentifer niUserIdentifer2 = new NiUserIdentifer();
							niUserIdentifer2.setUserId(userid);
							niUserIdentifer2.setWanxUserId(wanxUserid);
							try {
								int updateByPrimaryKeySelective = niUserIdentiferMapper.updateByPrimaryKeySelective(niUserIdentifer2);
								if(updateByPrimaryKeySelective>0){
									//获取本地id
									log.info("==================>> 保存到 用户标识信息表成功!");
								}
							} catch (Exception e) {
								e.printStackTrace();
								log.info("==================>> 保存到 用户标识信息表 失败");
							}
							
							//用户基础信息表
							NiUserBase niUserBase = new NiUserBase();
							niUserBase.setUserid(userid);
							if(sex.trim().equals("男")){
								niUserBase.setGender(1);
							}else if(sex.trim().equals("女")){
								niUserBase.setGender(2);
							}else{
								niUserBase.setGender(0);
							}
							niUserBase.setPhone(mobile);
							niUserBase.setUserfirstctime(new Date());
							niUserBase.setUsername(name);
							
							try {
								int insertSelective = niUserBaseMapper.insert(niUserBase);
								if(insertSelective>0){
									log.info("===============>>保存到 用户基础信息表成功");
								}
							} catch (Exception e) {
								e.printStackTrace();
								log.info("===============>>保存到 用户基础信息表 失败");
							}
							
							//用户邮政信息表   无需更新
							/*	NiUserPostal niUserPostal = new NiUserPostal();
							niUserPostal.setUserid(userid);
							niUserPostal.setUtime(new Date());
							try {
								int insertSelective = niUserPostalMapper.insertSelective(niUserPostal);
								if(insertSelective>0){
									log.info("=================>> 添加到 用户邮政信息表 成功");
								}
							} catch (Exception e) {
								e.printStackTrace();
								log.info("添加到 用户邮政信息表 失败");
							}*/
							
							//在线用户教育信息表
							NiUserEducation niUserEducation = new NiUserEducation();
							niUserEducation.setUserid(userid);
							niUserEducation.setBindcard(bind_ecard);
							niUserEducation.setUsersn(stu_no);   //学号
							
							//更新用户地区信息 到教育信息表
							if(niRegionDict!=null){
								Integer regionId = niRegionDict.getRegionId();
								String regionName = niRegionDict.getRegionName();
								niUserEducation.setRegionid(regionId);
								niUserEducation.setRegionname(regionName);
							}
							
							if(selectByWanxSchoolName!=null){
								Integer school_Id = selectByWanxSchoolName.getSchoolid();
								niUserEducation.setSchoolid(school_Id);
								niUserEducation.setSchoolname(school_name);
							}else{
								log.info("===================>>玩校学校名称与新洞察学校字典表中名称不相同, 将学校名称暂时存入教育信息表,并在字典表中新增一条记录,记录该条信息");
								niUserEducation.setSchoolname(school_name);
								niUserEducation.setSchoolid(null);
								
								//封装数据
								NiSchoolDict niSchoolDict = new NiSchoolDict();
								niSchoolDict.setSchoolid(null);
								niSchoolDict.setWanxschoolname(school_name);
								
								try {
									int insert = niSchoolDictMapper.insert(niSchoolDict);
									if(insert>0){
										log.info("=================玩校 学校名称和新洞察学校名称不相同, 新增一条到新洞察学校字典表记录成功");
									}else{
										log.info("=================玩校 学校名称和新洞察学校名称不相同, 新增一条到新洞察学校字典表记录失败");
									}
								} catch (Exception e) {
									e.printStackTrace();
									log.info("====================更新学校字典表失败");
								}
							}
							
							try {
								int insertSelective = niUserEducationMapper.insert(niUserEducation);
								if(insertSelective>0){
									log.info("====================>>添加到用户教育信息表成功");
								}
							} catch (Exception e1) {
								e1.printStackTrace();
								log.info("====================>>添加到用户教育信息表 异常");
							}
							
							//教育背景表
							NiUserEduHist niUserEduHist = new NiUserEduHist();
							niUserEduHist.setUserid(userid);
							
							//修改学校信息
							if(selectByWanxSchoolName!=null){
								//存在, 直接将玩校学校名称,id存入
								Integer schoolid = selectByWanxSchoolName.getSchoolid();   // 查询新洞察学校id
								niUserEduHist.setSchoolid(schoolid);
								niUserEduHist.setSchoolname(school_name);  //学校名称与新洞察名称相同
								
							}else{
								log.info("===================>>玩校学校名称与新洞察学校字典表中名称不相同, 将学校名称暂时存入教育信息表,并在字典表中新增一条记录,记录该条信息");
								//不存在 , 将玩校名称存入 , id 为空, 在学校字典表中新增记录 , id为空
								niUserEduHist.setSchoolname(school_name);
								niUserEduHist.setSchoolid(null);
							}
							
							niUserEduHist.setBindcard(bind_ecard);
							niUserEduHist.setUsersn(stu_no);
							try {
								int insertSelective = niUserEduHistMapper.insert(niUserEduHist);
								if(insertSelective>0){
									log.info("==================>>添加教育背景表成功");
								}
							} catch (Exception e1) {
								e1.printStackTrace();
								log.info("==================>>添加教育背景表异常");
							}
							
							//用户终端信息表   无需跟新,数据不全
							/*NiUserDevice niUserDevice = new NiUserDevice();
							niUserDevice.setUserid(userid);
							try {
								int insertSelective = niUserDeviceMapper.insert(niUserDevice);
								if(insertSelective>0){
									log.info("===============>> 添加用户终端信息 成功");
								}
							} catch (Exception e) {
								e.printStackTrace();
								log.info("===============>> 添加用户终端信息 失败");
							}*/
						}
						
						
						
						//不管新老用户全部更新用户头像 , 昵称 (其他的手机号,性别,学校等基础用户信息以后再说!)
						String headimg = session.getAttribute("headimg").toString();
						
						NiUserIdentifer niUserIdentifer_sel = niUserIdentiferMapper.selectByPrimaryKey(userid);
						if(niUserIdentifer_sel!=null){
							niUserIdentifer_sel.setWanxHeadImg(headimg);
							niUserIdentifer_sel.setWanxNickname(nickname);
							try {
								niUserIdentiferMapper.updateByPrimaryKeySelective(niUserIdentifer_sel);
							} catch (Exception e) {
								e.printStackTrace();
								log.info("更新玩校用户头像失败");
							}
						}
						
					}else{
						log.info("--------------->>用户标识信息表未创建,session中未获取出新洞察userId , userId为 null .....");
					}
					
				}
			}
		}
	}
	
	/** 
	 * 更新玩校userId ,返回新洞察userId   新接口
	 */
	@Transactional
	public int mapUser(String detailUserInfo,UserContext userContext,HttpSession newSession,HttpServletRequest request) {
//		long time0 = System.currentTimeMillis();
		
		JSONObject fromObject1 = JSONObject.parseObject(detailUserInfo);
		
		log.info("玩校返回的信息===========================>>"+fromObject1.toString());
		HttpSession session = request.getSession();
		Integer userid = null;
		
		if(fromObject1.toString().contains("errorCode")){
			log.info("================>>当前登录用户我们无权限获取详细信息!!");
			
		}else{
			String nickname = (String) fromObject1.get("nickname");  //昵称
			String wanxOpenid = (String) fromObject1.get("openid");   //openid
			int wanxUserId = fromObject1.getIntValue("userid");   // 玩校userid
			String mobile =  (String) fromObject1.get("mobile");  //手机号
			//获取完校的用户校园名称
			String school_Name=fromObject1.get("school_name").toString();
			//-----------获取用户信息
			String sex = fromObject1.getString("sex");   //性别
			String stu_no = fromObject1.getString("stu_no");  //学号
			String school_name = (String) fromObject1.get("school_name");//学校名称
			boolean bind_ecard = fromObject1.getBoolean("bind_ecard");  //是否绑定一卡通
			String name = fromObject1.getString("name");    //名称

//			long time1 = System.currentTimeMillis();
//			log.info("-------从玩校返回信息中读取用户详细信息的时间:"+(time1-time0) );
			
			//根据玩校用户id查询用户标识信息表
			NiUserIdentifer niUserIdentifer = niUserIdentiferMapper.selectByWanxuserId(wanxUserId);
			
//			long time2 = System.currentTimeMillis();
//			log.info("-------根据玩校wanxUserId查询用户标识信息表,判断用户是否新用户的时间:"+(time2-time1) );
			
			//不管新老用户全部更新用户头像 , 昵称 (其他的手机号,性别,学校等基础用户信息以后再说!)
			String headimg = session.getAttribute("headimg").toString();
			
			//如果在标识信息表中存在记录,则为老用户 , 如果不在标识信息表中,则为新用户
			if(niUserIdentifer != null){
				//老用户 , 获取新洞察userId
				userid = niUserIdentifer.getUserId();
				newSession.setAttribute("userId", userid);
				
				//更新老用户 NiUserIdentifer 表中的昵称,头像信息,wanxUserId
				niUserIdentifer.setWanxUserId(wanxUserId);
				niUserIdentifer.setWanxNickname(nickname);
				niUserIdentifer.setWanxHeadImg(headimg);
				niUserIdentiferMapper.updateByPrimaryKeySelective(niUserIdentifer);
				
				log.info("=====================>>老用户信息匹配成功!");
				
			}else{
				//新用户 , 新增记录到新洞察数据库
				log.info("==============>>当前登录用户不存在 , 新增该用户的信息到数据库 ...");
				//纪录未存到数据库
				
				//用户标识信息表
				NiUserIdentifer niUserIdentifer2 = new NiUserIdentifer();
				niUserIdentifer2.setWanxUserId(wanxUserId);
				niUserIdentifer2.setBindPhone(mobile);
				niUserIdentifer2.setWanxOpenId(wanxOpenid);
				niUserIdentifer2.setWanxNickname(nickname);
				niUserIdentifer2.setWanxOpenIdChannel(1);
				niUserIdentifer2.setWanxOpenIdCtime(new Date());
				niUserIdentifer2.setWanxHeadImg(headimg);  //用户头像
				try {
					int insertSelective = niUserIdentiferMapper.insertSelective(niUserIdentifer2);
					if(insertSelective>0){
						//获取新洞察userid
						userid = niUserIdentifer2.getUserId();
						newSession.setAttribute("userId", userid);
						log.info("==================>> 保存到 用户标识信息表成功!");
					}else{
						log.info("==================>> 保存到 用户标识信息表失败");
					}
				} catch (Exception e) {
					e.printStackTrace();
					log.info("==================>> 保存到 用户标识信息表 失败");
				}
//				long time3 = System.currentTimeMillis();
//				log.info("-------新用户,新增到用户标识信息表的时间:"+(time3-time2) );
			}
			
			
			//针对目前数据库中,用户标识信息表中的数据多余用户基本信息表等其他用户表中的数据,分析如下:用户标识信息表为判断是否为新用户的标准,凡在用户标识信息表中存在的
			//用户均为老用户,但是因为有很多老用户没有保存用户的基础信息等,所以在登录功能中对所有的老用户进行检查,同步基础信息表,教育背景表,在线用户教育信息表,以达到亡羊补牢
			//的效果,使这些丢失用户信息的老用户再次登录的时候就能同步他的用户信息,如该老用户一直未登录,则将无法再次同步他的用户信息.
			//老用户需要同步的数据库表有 : 基础信息表,在线用户教育信息表,教育背景表
			
			//对于新用户,即在用户标识信息表中没有记录的用户,将他的数据同步到所有用户信息表中:用户标识信息表,基础信息表,在线用户教育信息表,教育背景表
			
//			long time3_0 = System.currentTimeMillis();
			//---------更新用户基础信息表-----
			//用户基础信息表
			NiUserBase niUserBase_0 = niUserBaseMapper.selectByPrimaryKey(userid);
			if(niUserBase_0!=null){
				//有数据,更新数据
//				log.info("-------------当前用户 基础信息表有数据");
			}else{
//				log.info("-------------当前用户   基础信息表无数据,开始新增");
				//无数据,新增数据
				NiUserBase niUserBase = new NiUserBase();
				niUserBase.setUserid(userid);
				if(sex.trim().equals("男")){
					niUserBase.setGender(1);
				}else if(sex.trim().equals("女")){
					niUserBase.setGender(2);
				}else{
					niUserBase.setGender(0);
				}
				niUserBase.setPhone(mobile);
				niUserBase.setUserfirstctime(new Date());
				niUserBase.setUsername(name);
				
				try {
					int insertSelective = niUserBaseMapper.insert(niUserBase);
					if(insertSelective>0){
						log.info("===============>>保存到 用户基础信息表成功");
					}
				} catch (Exception e) {
					e.printStackTrace();
					log.info("===============>>保存到 用户基础信息表 失败");
				}
			}
			
//			long time4 = System.currentTimeMillis();
//			log.info("-------更新用户基础信息表的时间:"+(time4-time3_0) );
			
			//从在校教育表取值
			NiSchoolDict selectByWanxSchoolName = niSchoolDictMapper.selectByWanxSchoolName(school_name);
			
			//-------------更新在线用户教育信息表
			NiUserEducation niUserEducation_0 = niUserEducationMapper.selectByPrimaryKey(userid);
			if(niUserEducation_0!=null){
				//已经有数据
//				log.info("-------------当前用户  在线用户教育信息表有数据");
			}else{
//				log.info("-------------当前用户   在线用户教育信息表无数据,开始新增");
				//无数据,新增
				//获取地区信息
				String cityId = "";
				Object city_Id = session.getAttribute("cityId");
				if(city_Id!=null){
					cityId = city_Id.toString();
				}
				//玩校city_id 即为地区信息表中的 regionCode 字段
				//根据 city_id 查询地区信息
				NiRegionDict niRegionDict = null;
				if(StrUtils.isNotEmpty(cityId)){
					niRegionDict = niRegionDictMapper.findByRegionCode(cityId);
				}

				//在线用户教育信息表
				NiUserEducation niUserEducation = new NiUserEducation();
				niUserEducation.setUserid(userid);
				niUserEducation.setBindcard(bind_ecard);
				niUserEducation.setUsersn(stu_no);   //学号
				
				//更新用户地区信息 到教育信息表
				if(niRegionDict!=null){
					Integer regionId = niRegionDict.getRegionId();
					String regionName = niRegionDict.getRegionName();
					niUserEducation.setRegionid(regionId);
					niUserEducation.setRegionname(regionName);
				}
				
				if(selectByWanxSchoolName!=null){
					Integer school_Id = selectByWanxSchoolName.getSchoolid();
					niUserEducation.setSchoolid(school_Id);
					niUserEducation.setSchoolname(school_name);
				}else{
					log.info("===================>>玩校学校名称与新洞察学校字典表中名称不相同, 将学校名称暂时存入教育信息表,并在字典表中新增一条记录,记录该条信息");
					niUserEducation.setSchoolname(school_name);
					niUserEducation.setSchoolid(null);
					
					//------------- 学校字典表
					NiSchoolDict niSchoolDict = new NiSchoolDict();
					niSchoolDict.setSchoolid(null);
					niSchoolDict.setWanxschoolname(school_name);
					
					try {
						int insert = niSchoolDictMapper.insert(niSchoolDict);
						if(insert>0){
							log.info("=================玩校 学校名称和新洞察学校名称不相同, 新增一条到新洞察学校字典表记录成功");
						}else{
							log.info("=================玩校 学校名称和新洞察学校名称不相同, 新增一条到新洞察学校字典表记录失败");
						}
					} catch (Exception e) {
						e.printStackTrace();
						log.info("====================更新学校字典表失败");
					}
				}
				
				try {
					int insertSelective = niUserEducationMapper.insert(niUserEducation);
					if(insertSelective>0){
						log.info("====================>>添加到用户教育信息表成功");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
					log.info("====================>>添加到用户教育信息表 异常");
				}
				
			}
			
//			long time5 = System.currentTimeMillis();
//			log.info("-------更新在线用户教育信息表的时间:"+(time5-time4) );
//			ni_user_edu_hist
			//-------------更新教育背景表---
			List<NiUserEduHist> niUserEduHist_list = niUserEduHistMapper.selectByUserId(userid);
			if(niUserEduHist_list!=null && niUserEduHist_list.size()>0){
				//有数据,更新
				//更新用户的学校名称
				//log.info("更新用户教育背景表");
				
//				log.info("-------------当前用户  教育背景表有数据");
			}else{
//				log.info("-------------当前用户  教育背景表无数据,开始新增");
				//无数据,新增
				NiUserEduHist niUserEduHist = new NiUserEduHist();
				niUserEduHist.setUserid(userid);
				
				//修改学校信息
				if(selectByWanxSchoolName!=null){
					//存在, 直接将玩校学校名称,id存入
					Integer schoolid = selectByWanxSchoolName.getSchoolid();   // 查询新洞察学校id
					niUserEduHist.setSchoolid(schoolid);
					niUserEduHist.setSchoolname(school_name);  //学校名称与新洞察名称相同
					
				}else{
					log.info("===================>>玩校学校名称与新洞察学校字典表中名称不相同, 将学校名称暂时存入教育信息表,并在字典表中新增一条记录,记录该条信息");
					//不存在 , 将玩校名称存入 , id 为空, 在学校字典表中新增记录 , id为空
					niUserEduHist.setSchoolname(school_name);
					niUserEduHist.setSchoolid(null);
				}
				
				niUserEduHist.setBindcard(bind_ecard);
				niUserEduHist.setUsersn(stu_no);
				try {
					int insertSelective = niUserEduHistMapper.insert(niUserEduHist);
					if(insertSelective>0){
						log.info("==================>>添加教育背景表成功");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
					log.info("==================>>添加教育背景表异常");
				}
			}
			
//			long time6 = System.currentTimeMillis();
//			log.info("-------更新教育背景表的时间:"+(time6-time5) );
			
			
		}
		
//		long time7 = System.currentTimeMillis();
//		log.info("----用户id :"+userid+"---更新用户信息 mapUser接口一共需要时间: "+(time7-time0) );
		
		return userid;
	}

}
