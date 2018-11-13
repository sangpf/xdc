package com.newins.service.imp;
/**
 * 解析JSON数据保存到数据库业务逻辑层
 */
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.dao.InsertJsonToDbDao;
import com.newins.dao.NiRegionDictMapper;
import com.newins.dao.NiSchoolDictMapper;
import com.newins.dao.NiUserBaseMapper;
import com.newins.dao.NiUserEduHistMapper;
import com.newins.dao.NiUserEducationMapper;
import com.newins.dao.NiUserIdentiferMapper;
import com.newins.model.InsertJson;
import com.newins.model.NiRegionDict;
import com.newins.model.NiSchoolDict;
import com.newins.model.NiUserBase;
import com.newins.model.NiUserEduHist;
import com.newins.model.NiUserEducation;
import com.newins.model.NiUserIdentifer;
import com.newins.service.InsertJsonToDbService;
import com.newins.util.StrUtils;
@Service
public class InsertJsonToDbServiceImp implements InsertJsonToDbService {
	//自动绑定相关Dao
	@Autowired
	private InsertJsonToDbDao insertJsonToDbDao;
	@Autowired
	private NiUserBaseMapper niUserBaseMapper;
	@Autowired
	private NiUserEducationMapper niUserEducationMapper;
	@Autowired
	private NiUserEduHistMapper niUserEduHistMapper;
	@Autowired
	private NiRegionDictMapper niRegionDictMapper;
	@Autowired
	private NiSchoolDictMapper niSchoolDictMapper;
	
	public Object InsertUser() {
		//声明三个表的方法返回值变量
		int tempBase=0;
		int tempEdu=0;
		int tempEdu_Hist=0;
		//获取当前时间
		Date date=new Date();
		//设置时间格式
		DateFormat df=new SimpleDateFormat("yyyy-MM-DD HH:mm");
		//得到当前时间
		String time=df.format(date);
		//将当前时间转为Date类类型
		Date nowTime = null;
		try {
			nowTime = df.parse(time);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("开始调用增加三个表biz层");
		//声明一个List用于保存添加操作的用户Id，用于判断此用户是否存在,防止重复添加用户信息
		List<Integer> userIdList=new ArrayList<Integer>();
		//思路:
		//1.调用得到Openid一样的数据方法
		//2.实例化它的实体类泛型的List并接受方法返回的数据
		List<InsertJson> jsonData=new ArrayList<>();
		jsonData=insertJsonToDbDao.InsertJsonData();
		//3.再将这三个实体需要的数据分别给他们
		//4.实例化这三个表的实体类分别接受这三个方法的返回数据
		NiUserBase base=new NiUserBase();
		NiUserEducation education=new NiUserEducation();
		NiUserEduHist eduHist=new NiUserEduHist();
		//声明userIdList中存在的userId数量变量
		boolean findUserId=false;
		//循环操作读取出来的JsonData集合
		for(int i=0;i<jsonData.size();i++){	
			//判断一下查询出来要插入其他表的userID是否已经存在
			//调用查询方法查询取出来的userId是否已经存在
			int userId=jsonData.get(i).getUserId();
			int resultTemp_userbase=insertJsonToDbDao.selectUserBaseUserId(userId);
			int resultTemp_education=insertJsonToDbDao.selectEduUserId(userId);
			int resultTemp_edu_hist=insertJsonToDbDao.selectEduHistUserId(userId);
			System.out.println("base表:"+resultTemp_userbase);
			System.out.println("education表:"+resultTemp_education);
			System.out.println("edu_hist表:"+resultTemp_edu_hist);
			if(resultTemp_education>0||resultTemp_userbase>0||resultTemp_edu_hist>0){
				//进这里说明其中有一个表的userId已经存在返回进入下一次循环
				
			}else{
				//循环判断当前操作的用户Id是否已经存在了，如果存在就跳过操作，不存在就继续执行更新其他三个表的操作
				for(int j=0;j<userIdList.size();j++){
					//符合这个条件说明这个userId
					if(jsonData.get(i).getUserId()==userIdList.get(j)){
						//将userId数量变量自增
						findUserId=true;
					}
				}
				//判断findUserId等于false就说明没有操作过这个用户
				if(findUserId==false){
					//进来这里说明没有存在的userId，不是在重复添加用户信息
					//1.给三个表的操作需要的参数赋值
					//给base表实体添加数据
					//添加userid
					base.setUserid(jsonData.get(i).getUserId());
					//添加name
					base.setUsername(jsonData.get(i).getName());
					//添加时间
					base.setUserctime(nowTime);
					//判断性别
					String sex=jsonData.get(i).getSex();
					//设置性别
					if(sex.trim().equals("男")){
						base.setGender(1);
					}else if(sex.trim().equals("女")){
						base.setGender(2);
					}else{
						base.setGender(0);
					} 
					//添加手机
					base.setPhone(jsonData.get(0).getMobile());
					//调用basemapper的insert方法
					try {
						tempBase=niUserBaseMapper.insert(base);
					} catch (Exception e) {
						e.printStackTrace();
					}
					//给education实体添加数据
					//添加userid属性
					education.setUserid(jsonData.get(i).getUserId());
					education.setBindcard(Boolean.parseBoolean(jsonData.get(i).getBind_Ecard()));
					education.setUsersn(jsonData.get(i).getStu_No());
					education.setWanxaccount(jsonData.get(i).getAccount());
					//获取地区信息
					String cityId = "";
					Object city_Id = jsonData.get(i).getCity_Id();
					if(city_Id!=null){
						cityId = city_Id.toString();
					}
					//玩校city_id 即为地区信息表中的 regionCode 字段
					//根据 city_id 查询地区信息
					NiRegionDict niRegionDict = null;
					if(StrUtils.isNotEmpty(cityId)){
						niRegionDict = niRegionDictMapper.findByRegionCode(cityId);
					}
					//添加地区ID属性--如果是空的就不管他，不空就添加，空的就不需要操作
					if(niRegionDict!=null){
						int reginId=niRegionDict.getRegionId();
						education.setRegionid(reginId);
					}
					//添加地区名称属性--如果是空的就不管他，不空就添加，空的就不做操作
					if(niRegionDict!=null){
						String reginName=niRegionDict.getRegionName();
						education.setRegionname(reginName);
					}
					//从在校教育表取值
					NiSchoolDict school = niSchoolDictMapper.selectByWanxSchoolName(jsonData.get(i).getSchool_Name());
					//防止报空指针
					if(school!=null){
						//给学校id属性添加数据
						education.setSchoolid(school.getSchoolid());
						//给学校名称属性添加数据
						education.setSchoolname(school.getSchoolname());
					}
					//执行educationMapper的insert方法
					try {
						niUserEducationMapper.insert(education);
					} catch (Exception e) {
						e.printStackTrace();
					}
					//防止报空指针
					if(school!=null){
						//给edu_hist实体添加数据
						eduHist.setSchoolid(school.getSchoolid());
						//添加学校名称属性
						eduHist.setSchoolname(school.getSchoolname());
					}
					//添加是否绑定一卡通属性
					eduHist.setBindcard(Boolean.parseBoolean(jsonData.get(i).getBind_Ecard()));
					eduHist.setUserid(jsonData.get(i).getUserId());
					eduHist.setUsersn(jsonData.get(i).getStu_No());
					//执行eduhistMapper的insert()方法
					try {
						niUserEduHistMapper.insert(eduHist);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				//单独保存用户Id到userIdList中,放在最下面防止错误判断已经存在的userId
				userIdList.add(base.getUserid());
				
			}
			System.out.println("增加了第"+i+"条数据");
		}
		System.out.println("结束调用增加三个表biz层");
		return "执行完成";
	}
	

}
