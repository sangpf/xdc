package com.newins.service.imp;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.dao.MyCognitionDao;
import com.newins.model.MyCognitionModel;
import com.newins.service.MyCognitionService;
/**
 * @Description 
 * @author 星仔
 * @time 2017年2月21日下午3:24:16
 */
@Service("myCognitionService")
public class MyCognitionServiceImp implements MyCognitionService {

	@Autowired
	private MyCognitionDao myCognitionDao;
	
	public MyCognitionDao getMyCognitionDao() {
		return myCognitionDao;
	}

	public void setMyCognitionDao(MyCognitionDao myCognitionDao) {
		this.myCognitionDao = myCognitionDao;
	}

	/**
	 * 查询用户名和头像
	 */
	@Override
	public MyCognitionModel getMyCognitionList(int userId) {
		//获取myTags
		MyCognitionModel myTagsModel = myCognitionDao.myTagsList(userId);
		//System.out.println(myTagsModel.toString());
		
		List<String> myTagsList = new ArrayList<String>();
		
		if (myTagsModel!=null) {
			System.out.println(myTagsList.toString());
			//性别，年级，单身，星座，性格，品格
			//判断性别_1
			if (myTagsModel.getGender()==null) {
				myTagsList.add(0, "null");
			}else if (myTagsModel.getGender().equals("0")) {
				myTagsList.add(0, "null");
			}else if (myTagsModel.getGender().equals("1")) {
				myTagsList.add(0, "男");
			}else if (myTagsModel.getGender().equals("2")) {
				myTagsList.add(0, "女");
			}
			
			//判断年级_2
			if (myTagsModel.getGrade()==null) {
				myTagsList.add(1, "null");
			}else if (myTagsModel.getGrade().equals("0")) {
				myTagsList.add(1, "null");
			}else if (myTagsModel.getGrade().equals("1")) {
				myTagsList.add(1, "高一");
			}else if (myTagsModel.getGrade().equals("2")) {
				myTagsList.add(1, "高二");
			}else if (myTagsModel.getGrade().equals("3")) {
				myTagsList.add(1, "高三");
			}else if (myTagsModel.getGrade().equals("4")) {
				myTagsList.add(1, "大一");
			}else if (myTagsModel.getGrade().equals("5")) {
				myTagsList.add(1, "大二");
			}else if (myTagsModel.getGrade().equals("6")) {
				myTagsList.add(1, "大三");
			}else if (myTagsModel.getGrade().equals("7")) {
				myTagsList.add(1, "大四");
			}else if (myTagsModel.getGrade().equals("8")) {
				myTagsList.add(1, "大五");
			}else if (myTagsModel.getGrade().equals("9")) {
				myTagsList.add(1, "研一");
			}else if (myTagsModel.getGrade().equals("10")) {
				myTagsList.add(1, "研二");
			}else if (myTagsModel.getGrade().equals("11")) {
				myTagsList.add(1, "研三");
			}else if (myTagsModel.getGrade().equals("12")) {
				myTagsList.add(1, "博一");
			}else if (myTagsModel.getGrade().equals("13")) {
				myTagsList.add(1, "博二");
			}else if (myTagsModel.getGrade().equals("14")) {
				myTagsList.add(1, "博三");
			}else if (myTagsModel.getGrade().equals("15")) {
				myTagsList.add(1, "博四");
			}else if (myTagsModel.getGrade().equals("16")) {
				myTagsList.add(1, "博五");
			}else if (myTagsModel.getGrade().equals("17")) {
				myTagsList.add(1, "其他");
			}
			
			//判断恋爱状态_3
			if (myTagsModel.getLoveCondition()==null) {
				myTagsList.add(2, "null");
			}else if (myTagsModel.getLoveCondition().equals("0")) {
				myTagsList.add(2, "null");
			}else if (myTagsModel.getLoveCondition().equals("1")) {
				myTagsList.add(2, "单身");
			}else if (myTagsModel.getLoveCondition().equals("2")) {
				myTagsList.add(2, "恋爱萌芽");
			}else if (myTagsModel.getLoveCondition().equals("3")) {
				myTagsList.add(2, "热恋期");
			}else if (myTagsModel.getLoveCondition().equals("4")) {
				myTagsList.add(2, "稳定期");
			}else if (myTagsModel.getLoveCondition().equals("5")) {
				myTagsList.add(2, "矛盾期");
			}else if (myTagsModel.getLoveCondition().equals("6")) {
				myTagsList.add(2, "修好期");
			}else if (myTagsModel.getLoveCondition().equals("7")) {
				myTagsList.add(2, "分手期");
			}else if (myTagsModel.getLoveCondition().equals("8")) {
				myTagsList.add(2, "失恋期");
			}else if (myTagsModel.getLoveCondition().equals("9")) {
				myTagsList.add(2, "已婚");
			}else if (myTagsModel.getLoveCondition().equals("10")) {
				myTagsList.add(2, "离异");
			}else if (myTagsModel.getLoveCondition().equals("11")) {
				myTagsList.add(2, "独身主义");
			}else if (myTagsModel.getLoveCondition().equals("12")) {
				myTagsList.add(2, "其他");
			}
			
			//判断星座_4
			if (myTagsModel.getStarSign()==null) {
				myTagsList.add(3, "null");
			}else if (myTagsModel.getStarSign().equals("0")) {
				myTagsList.add(3, "null");
			}else if (myTagsModel.getStarSign().equals("1")) {
				myTagsList.add(3, "水瓶座");
			}else if (myTagsModel.getStarSign().equals("2")) {
				myTagsList.add(3, "双鱼座");
			}else if (myTagsModel.getStarSign().equals("3")) {
				myTagsList.add(3, "白羊座");
			}else if (myTagsModel.getStarSign().equals("4")) {
				myTagsList.add(3, "金牛座");
			}else if (myTagsModel.getStarSign().equals("5")) {
				myTagsList.add(3, "双子座");
			}else if (myTagsModel.getStarSign().equals("6")) {
				myTagsList.add(3, "巨蟹座");
			}else if (myTagsModel.getStarSign().equals("7")) {
				myTagsList.add(3, "狮子座");
			}else if (myTagsModel.getStarSign().equals("8")) {
				myTagsList.add(3, "处女座");
			}else if (myTagsModel.getStarSign().equals("9")) {
				myTagsList.add(3, "天秤座");
			}else if (myTagsModel.getStarSign().equals("10")) {
				myTagsList.add(3, "天蝎座");
			}else if (myTagsModel.getStarSign().equals("11")) {
				myTagsList.add(3, "射手座");
			}else if (myTagsModel.getStarSign().equals("12")) {
				myTagsList.add(3, "摩羯座");
			}
			
			//判断性格_5
			if (myTagsModel.getCharacter()==null) {
				myTagsList.add(4, "null");
			}else if (myTagsModel.getCharacter().equals("0")) {
				myTagsList.add(4, "null");
			}else if (myTagsModel.getCharacter().equals("1")) {
				myTagsList.add(4, "柔弱");
			}else if (myTagsModel.getCharacter().equals("2")) {
				myTagsList.add(4, "坚强");
			}else if (myTagsModel.getCharacter().equals("3")) {
				myTagsList.add(4, "悲观");
			}else if (myTagsModel.getCharacter().equals("4")) {
				myTagsList.add(4, "乐观");
			}else if (myTagsModel.getCharacter().equals("5")) {
				myTagsList.add(4, "内向");
			}else if (myTagsModel.getCharacter().equals("6")) {
				myTagsList.add(4, "外向");
			}else if (myTagsModel.getCharacter().equals("7")) {
				myTagsList.add(4, "安静");
			}else if (myTagsModel.getCharacter().equals("8")) {
				myTagsList.add(4, "活泼");
			}else if (myTagsModel.getCharacter().equals("9")) {
				myTagsList.add(4, "依赖");
			}else if (myTagsModel.getCharacter().equals("10")) {
				myTagsList.add(4, "独立");
			}else if (myTagsModel.getCharacter().equals("11")) {
				myTagsList.add(4, "愚笨");
			}else if (myTagsModel.getCharacter().equals("12")) {
				myTagsList.add(4, "聪明");
			}else if (myTagsModel.getCharacter().equals("13")) {
				myTagsList.add(4, "随意");
			}else if (myTagsModel.getCharacter().equals("14")) {
				myTagsList.add(4, "严谨");
			}else if (myTagsModel.getCharacter().equals("15")) {
				myTagsList.add(4, "犹豫");
			}else if (myTagsModel.getCharacter().equals("16")) {
				myTagsList.add(4, "果断");
			}else if (myTagsModel.getCharacter().equals("17")) {
				myTagsList.add(4, "传统");
			}else if (myTagsModel.getCharacter().equals("18")) {
				myTagsList.add(4, "开放");
			}else if (myTagsModel.getCharacter().equals("19")) {
				myTagsList.add(4, "刻板");
			}else if (myTagsModel.getCharacter().equals("20")) {
				myTagsList.add(4, "灵活");
			}
			
			//判断品格_6
			if (myTagsModel.getMoral()==null) {
				myTagsList.add(5, "null");
			}else if (myTagsModel.getMoral().equals("0")) {
				myTagsList.add(5, "null");
			}else if (myTagsModel.getMoral().equals("1")) {
				myTagsList.add(5, "自私");
			}else if (myTagsModel.getMoral().equals("2")) {
				myTagsList.add(5, "无私");
			}else if (myTagsModel.getMoral().equals("3")) {
				myTagsList.add(5, "虚伪");
			}else if (myTagsModel.getMoral().equals("4")) {
				myTagsList.add(5, "诚实");
			}else if (myTagsModel.getMoral().equals("5")) {
				myTagsList.add(5, "懒惰");
			}else if (myTagsModel.getMoral().equals("6")) {
				myTagsList.add(5, "勤奋");
			}else if (myTagsModel.getMoral().equals("7")) {
				myTagsList.add(5, "正直");
			}else if (myTagsModel.getMoral().equals("8")) {
				myTagsList.add(5, "好色");
			}else if (myTagsModel.getMoral().equals("9")) {
				myTagsList.add(5, "残忍");
			}else if (myTagsModel.getMoral().equals("10")) {
				myTagsList.add(5, "善良");
			}else if (myTagsModel.getMoral().equals("11")) {
				myTagsList.add(5, "狭隘");
			}else if (myTagsModel.getMoral().equals("12")) {
				myTagsList.add(5, "宽宏");
			}else if (myTagsModel.getMoral().equals("13")) {
				myTagsList.add(5, "吝啬");
			}else if (myTagsModel.getMoral().equals("14")) {
				myTagsList.add(5, "仗义");
			}else if (myTagsModel.getMoral().equals("15")) {
				myTagsList.add(5, "幻想");
			}else if (myTagsModel.getMoral().equals("16")) {
				myTagsList.add(5, "实际");
			}else if (myTagsModel.getMoral().equals("17")) {
				myTagsList.add(5, "骄傲");
			}else if (myTagsModel.getMoral().equals("18")) {
				myTagsList.add(5, "谦虚");
			}else if (myTagsModel.getMoral().equals("19")) {
				myTagsList.add(5, "激进");
			}else if (myTagsModel.getMoral().equals("20")) {
				myTagsList.add(5, "平和");
			}
			
			for (int i = 0; i < myTagsList.size(); i++) {
				if (myTagsList.get(i).equals("null")) {
					myTagsList.remove(i);
				}
			}
			
			
			MyCognitionModel list = myCognitionDao.myCognitionList(userId);
			list.setMyAssess(this.getMyAssessCount(userId));
			list.setMyAwardLiangpiao(this.getMyAwardCount(userId));
			list.setMyFavoriteReport(this.getMyFavoriteReportCount(userId));
			list.setMySuperSurvey(this.getMySuperSurveyCount(userId));
			list.setMyTags(myTagsList);
			return list;
			
		}else {
			MyCognitionModel list = myCognitionDao.myCognitionList(userId);
			list.setMyAssess(this.getMyAssessCount(userId));
			list.setMyAwardLiangpiao(this.getMyAwardCount(userId));
			list.setMyFavoriteReport(this.getMyFavoriteReportCount(userId));
			list.setMySuperSurvey(this.getMySuperSurveyCount(userId));
//			list.setMyTags(myTagsList);
			return list;
		}
		
		
		
		
		
		
		
		//判断性别
//		if (myTagsModel.getGender().equals("1")) {
//			myTagsList.add(0, "男");
//		}else if (myTagsModel.getGender().equals("2")) {
//			myTagsList.add(0, "女");
//		}else {
//			myTagsList.add(0, null);
//		}
//		
//		//判断恋爱状态
//		if (myTagsModel.getLoveCondition().equals("1")) {
//			myTagsList.add(1, "单身");
//		}else if (myTagsModel.getLoveCondition().equals("2")) {
//			myTagsList.add(1, "恋爱萌芽");
//		}else if (myTagsModel.getLoveCondition().equals("3")) {
//			myTagsList.add(1, "热恋期");
//		}else if (myTagsModel.getLoveCondition().equals("2")) {
//			myTagsList.add(1, "稳定期");
//		}else if (myTagsModel.getLoveCondition().equals("2")) {
//			myTagsList.add(1, "矛盾期");
//		}else if (myTagsModel.getLoveCondition().equals("2")) {
//			myTagsList.add(1, "修好期");
//		}else if (myTagsModel.getLoveCondition().equals("2")) {
//			myTagsList.add(1, "分手期");
//		}else if (myTagsModel.getLoveCondition().equals("2")) {
//			myTagsList.add(1, "失恋期");
//		}else if (myTagsModel.getLoveCondition().equals("2")) {
//			myTagsList.add(1, "已婚");
//		}else if (myTagsModel.getLoveCondition().equals("2")) {
//			myTagsList.add(1, "离异");
//		}else if (myTagsModel.getLoveCondition().equals("2")) {
//			myTagsList.add(1, "独身主义");
//		}else if (myTagsModel.getLoveCondition().equals("2")) {
//			myTagsList.add(1, "其他");
//		}else{
//			myTagsList.add(1, null);
//		}
//		
//		//判断星座
//		if (myTagsModel.getStarSign().equals("1")) {
//			myTagsList.add(2, "水瓶座");
//		}else if (myTagsModel.getStarSign().equals("2")) {
//			myTagsList.add(2, "双鱼座");
//		}else if (myTagsModel.getStarSign().equals("3")) {
//			myTagsList.add(2, "白羊座");
//		}else if (myTagsModel.getStarSign().equals("4")) {
//			myTagsList.add(2, "金牛座");
//		}else if (myTagsModel.getStarSign().equals("5")) {
//			myTagsList.add(2, "双子座");
//		}else if (myTagsModel.getStarSign().equals("6")) {
//			myTagsList.add(2, "巨蟹座");
//		}else if (myTagsModel.getStarSign().equals("7")) {
//			myTagsList.add(2, "狮子座");
//		}else if (myTagsModel.getStarSign().equals("8")) {
//			myTagsList.add(2, "处女座");
//		}else if (myTagsModel.getStarSign().equals("9")) {
//			myTagsList.add(2, "天秤座");
//		}else if (myTagsModel.getStarSign().equals("10")) {
//			myTagsList.add(2, "天蝎座");
//		}else if (myTagsModel.getStarSign().equals("11")) {
//			myTagsList.add(2, "射手座");
//		}else if (myTagsModel.getStarSign().equals("12")) {
//			myTagsList.add(2, "摩羯座");
//		}else {
//			myTagsList.add(2,null);
//		}
//		
//		//判断性格
//		if (myTagsModel.getCharacter().equals("1")) {
//			myTagsList.add(3, "柔弱");
//		}else if (myTagsModel.getCharacter().equals("2")) {
//			myTagsList.add(3, "坚强");
//		}else if (myTagsModel.getCharacter().equals("3")) {
//			myTagsList.add(3, "悲观");
//		}else if (myTagsModel.getCharacter().equals("4")) {
//			myTagsList.add(3, "乐观");
//		}else if (myTagsModel.getCharacter().equals("5")) {
//			myTagsList.add(3, "内向");
//		}else if (myTagsModel.getCharacter().equals("6")) {
//			myTagsList.add(3, "外向");
//		}else if (myTagsModel.getCharacter().equals("7")) {
//			myTagsList.add(3, "安静");
//		}else if (myTagsModel.getCharacter().equals("8")) {
//			myTagsList.add(3, "活泼");
//		}else if (myTagsModel.getCharacter().equals("9")) {
//			myTagsList.add(3, "依赖");
//		}else if (myTagsModel.getCharacter().equals("10")) {
//			myTagsList.add(3, "独立");
//		}else if (myTagsModel.getCharacter().equals("11")) {
//			myTagsList.add(3, "愚笨");
//		}else if (myTagsModel.getCharacter().equals("12")) {
//			myTagsList.add(3, "聪明");
//		}else if (myTagsModel.getCharacter().equals("13")) {
//			myTagsList.add(3, "随意");
//		}else if (myTagsModel.getCharacter().equals("14")) {
//			myTagsList.add(3, "严谨");
//		}else if (myTagsModel.getCharacter().equals("15")) {
//			myTagsList.add(3, "犹豫");
//		}else if (myTagsModel.getCharacter().equals("16")) {
//			myTagsList.add(3, "果断");
//		}else if (myTagsModel.getCharacter().equals("17")) {
//			myTagsList.add(3, "传统");
//		}else if (myTagsModel.getCharacter().equals("18")) {
//			myTagsList.add(3, "开放");
//		}else if (myTagsModel.getCharacter().equals("19")) {
//			myTagsList.add(3, "刻板");
//		}else if (myTagsModel.getCharacter().equals("20")) {
//			myTagsList.add(3, "灵活");
//		}
//		
//		//判断品格
//		if (myTagsModel.getMoral().equals("1")) {
//			myTagsList.add(4, "自私");
//		}else if (myTagsModel.getMoral().equals("2")) {
//			myTagsList.add(4, "无私");
//		}else if (myTagsModel.getMoral().equals("3")) {
//			myTagsList.add(4, "虚伪");
//		}else if (myTagsModel.getMoral().equals("4")) {
//			myTagsList.add(4, "诚实");
//		}else if (myTagsModel.getMoral().equals("5")) {
//			myTagsList.add(4, "懒惰");
//		}else if (myTagsModel.getMoral().equals("6")) {
//			myTagsList.add(4, "勤奋");
//		}else if (myTagsModel.getMoral().equals("7")) {
//			myTagsList.add(4, "正直");
//		}else if (myTagsModel.getMoral().equals("8")) {
//			myTagsList.add(4, "好色");
//		}else if (myTagsModel.getMoral().equals("9")) {
//			myTagsList.add(4, "残忍");
//		}else if (myTagsModel.getMoral().equals("10")) {
//			myTagsList.add(4, "善良");
//		}else if (myTagsModel.getMoral().equals("11")) {
//			myTagsList.add(4, "狭隘");
//		}else if (myTagsModel.getMoral().equals("12")) {
//			myTagsList.add(4, "宽宏");
//		}else if (myTagsModel.getMoral().equals("13")) {
//			myTagsList.add(4, "吝啬");
//		}else if (myTagsModel.getMoral().equals("14")) {
//			myTagsList.add(4, "仗义");
//		}else if (myTagsModel.getMoral().equals("15")) {
//			myTagsList.add(4, "幻想");
//		}else if (myTagsModel.getMoral().equals("16")) {
//			myTagsList.add(4, "实际");
//		}else if (myTagsModel.getMoral().equals("17")) {
//			myTagsList.add(4, "骄傲");
//		}else if (myTagsModel.getMoral().equals("18")) {
//			myTagsList.add(4, "谦虚");
//		}else if (myTagsModel.getMoral().equals("19")) {
//			myTagsList.add(4, "激进");
//		}else if (myTagsModel.getMoral().equals("20")) {
//			myTagsList.add(4, "平和");
//		}
//		
//		//判断年级
//		if (myTagsModel.getGrade().equals("1")) {
//			myTagsList.add(5, "高一");
//		}else if (myTagsModel.getGrade().equals("2")) {
//			myTagsList.add(5, "高二");
//		}else if (myTagsModel.getGrade().equals("3")) {
//			myTagsList.add(5, "高三");
//		}else if (myTagsModel.getGrade().equals("4")) {
//			myTagsList.add(5, "大一");
//		}else if (myTagsModel.getGrade().equals("5")) {
//			myTagsList.add(5, "大二");
//		}else if (myTagsModel.getGrade().equals("6")) {
//			myTagsList.add(5, "大三");
//		}else if (myTagsModel.getGrade().equals("7")) {
//			myTagsList.add(5, "大四");
//		}else if (myTagsModel.getGrade().equals("8")) {
//			myTagsList.add(5, "研一");
//		}else if (myTagsModel.getGrade().equals("9")) {
//			myTagsList.add(5, "研二");
//		}else if (myTagsModel.getGrade().equals("10")) {
//			myTagsList.add(5, "研三");
//		}else if (myTagsModel.getGrade().equals("11")) {
//			myTagsList.add(5, "博一");
//		}else if (myTagsModel.getGrade().equals("12")) {
//			myTagsList.add(5, "博二");
//		}else if (myTagsModel.getGrade().equals("13")) {
//			myTagsList.add(5, "博三");
//		}else if (myTagsModel.getGrade().equals("14")) {
//			myTagsList.add(5, "博四");
//		}
//		
		
		
//		System.out.println("在serviceimp");
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		
//		JSONObject jsonObject = new JSONObject();
//		jsonObject.put("1", list);
	}
	

	/**
	 * 查询用户参与过的调查总数
	 */
	@Override
	public int getMySuperSurveyCount(int userId) {
		int num = myCognitionDao.mySuperSurveyCount(userId);
		return num;
	}

	@Override
	public int getMyAssessCount(int userId) {
		int num = myCognitionDao.myAssessCount(userId);
		return num;
	}

	@Override
	public int getMyFavoriteReportCount(int userId) {
		int num = myCognitionDao.myFavoriteReportCount(userId);
		return num;
	}

	@Override
	public int getMyAwardCount(int userId) {
		int num = myCognitionDao.myAwardCount(userId);
		return num;
	}

	
	
}
