package com.newins.service.imp;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newins.dao.NiCommentMapper;
import com.newins.model.NiComment;
import com.newins.model.NiCommentVO;
import com.newins.service.NiCommentService;
import com.newins.util.AjaxResult;
import com.newins.util.SensitivewordFilter;
import com.newins.util.StrUtils;

@Service
public class NiCommentServiceImp implements NiCommentService{
	private static Logger log = Logger.getLogger(NiCommentServiceImp.class);
	@Resource
	private NiCommentMapper niCommentMapper;

	//添加评论
	@Transactional
	public AjaxResult addNiComment(HttpServletRequest request,HttpServletResponse response) {
		AjaxResult ajaxResult = new AjaxResult();
		//接收前端传递的type
		int type=Integer.parseInt(request.getParameter("submitType"));
		String content;
		//判断type的值
		if(type==2){
			//进入这里表示用户保存的是回复
			//获取前端用户回复的内容引用
			String data_content=request.getParameter("data_content").toString();
			//给用户回复的内容进行一些操作
			content = request.getParameter("content");  //内容
			//接收前端传递的回复的用户昵称
			String nikeName=request.getParameter("nikeName");
			//拼接回复的内容
			content=content+"//\r回复@"+nikeName+":"+data_content;
		}else{
			//进入这里表示用户提交的是评论
			content = request.getParameter("content");  //内容
		}
		//将评论内容转码
		try {
			content=URLDecoder.decode(content, "utf-8");
		} catch (UnsupportedEncodingException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String commentObjId = request.getParameter("commentObjId"); //调查,测评,投票投放id 或者报告id
		String commentObjType = request.getParameter("commentObjType"); //评论类型
		HttpSession session = request.getSession();
		Object userId = session.getAttribute("userId");  //新洞察用户id
		if(userId!=null){
			String userIdStr = userId.toString();
			//判断内容中是否有敏感词
			long time1 = System.currentTimeMillis();
//			String sensitiveWords = SensitiveUtil.SensitiveWords(content,request);
			Set<String> wordSet = null;
			try {
				wordSet = SensitivewordFilter.SensitiveWords(content, request);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			log.info("检测敏感词所用时间:"+(System.currentTimeMillis()-time1));
			
			if(wordSet.size()>0){
				return AjaxResult.errorCode("内容包含敏感词", "001");
			}
			
//			if(StrUtils.isNotEmpty(sensitiveWords)){
////				return AjaxResult.errorResult("评论内容请勿包含:"+sensitiveWords+"字样");
//				return AjaxResult.errorCode("内容包含敏感词", "001");
//			}
			
			
			NiComment niComment = new NiComment();
			niComment.setCommentObjId(commentObjId);
			niComment.setCommentObjType(commentObjType);
			niComment.setCommentTime(new Date());
			niComment.setContent(content);
			niComment.setStatus(1);
			
			
			niComment.setUserId(Integer.valueOf(userIdStr));
			
			try {
				int insert = niCommentMapper.insert(niComment);
				if(insert>0){
					ajaxResult.put("success", true);
					ajaxResult.put("msg", "评论成功");
				}else{
					return AjaxResult.errorCode("保存评论失败", "002");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				return AjaxResult.errorCode("保存评论失败", "002");
			}
			
			
		}else{
			log.info("保存用户评论失败,原因未获取用户的id");
			return AjaxResult.errorCode("未获取用户登录信息,添加评论失败", "003");
		}
		
		return ajaxResult;
	}

	//查询评论列表信息
	public AjaxResult listNiComment(HttpServletRequest request) {
		String commentObjId = request.getParameter("commentObjId");
		String commentObjType = request.getParameter("commentObjType");
		
		AjaxResult ajaxResult = new AjaxResult();
		
//		返回 当前问卷或报告的  总:评论总数，    分 :每条评论的头像，昵称，学校，点赞数，评论时间，评论内容
		
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("commentObjId", commentObjId);
		hashMap.put("commentObjType", commentObjType);
		
		
		//创建集合存储新对象   根据时间倒叙排列
		List<NiCommentVO> newList = new ArrayList<NiCommentVO>();
		
		//根据点赞数大于50  前三
		List<NiCommentVO> goodList = new ArrayList<NiCommentVO>();
		
		//查询评论记录数
		int commentNum = niCommentMapper.findCount(hashMap);
		
		//根据问卷id,问卷类型查询所有评论信息
		
		//根据时间倒叙排列
		List<NiCommentVO> listNiCommentVO = niCommentMapper.listNiComment(hashMap);
		if(listNiCommentVO.size()>0){
			//遍历集合,将时间进行修改后重新封装到对象中
			for (NiCommentVO niCommentVO : listNiCommentVO) {
				Date commentTime = niCommentVO.getCommentTime();
				
				Date date = new Date();
				
				//两个时间相差秒
				long interval  = 0;
				if(commentTime!=null){
					interval  = (date.getTime() - commentTime.getTime()) / 1000;
					
				}
				
//				System.out.println("时间 :"+interval);
				
				if(interval<60){
					niCommentVO.setShowTime("刚刚");
				}else if(interval>60 && interval<3600){
					niCommentVO.setShowTime(interval/60+"分钟前");
				}else if(interval>3600 && interval<(60*60*24)){
					niCommentVO.setShowTime(interval/3600+"小时前");
				}else if(interval>(3600*24*1) && interval<(3600*24*30) ){
					niCommentVO.setShowTime(interval/(3600*24)+"天前");
				}else if(interval>(3600*24*30)){
					
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd HH:MM");
					niCommentVO.setShowTime(simpleDateFormat.format(commentTime));
					
				}
				//将对象放入集合
				newList.add(niCommentVO);
//				System.out.println(niCommentVO.getShowTime());
				
			}
			
		}else{
			return AjaxResult.errorCode("暂无评论", "001");
		}
		
		//根据点赞数排序   大于50个赞, 前三个
		List<NiCommentVO> goodCommentList = niCommentMapper.goodCommentList(hashMap);
		if(goodCommentList.size()>0){
			for (NiCommentVO niCommentVO : goodCommentList) {
				
				Date commentTime = niCommentVO.getCommentTime();
				
				Date date = new Date();
				
				//两个时间相差秒
				long interval  = 0;
				if(commentTime!=null){
					interval  = (date.getTime() - commentTime.getTime()) / 1000;
					
				}
				
//				System.out.println("时间 :"+interval);
				
				if(interval<60){
					niCommentVO.setShowTime("刚刚");
				}else if(interval>60 && interval<3600){
					niCommentVO.setShowTime(interval/60+"分钟前");
				}else if(interval>3600 && interval<(60*60*24)){
					niCommentVO.setShowTime(interval/3600+"小时前");
				}else if(interval>(3600*24*1) && interval<(3600*24*30) ){
					niCommentVO.setShowTime(interval/(3600*24)+"天前");
				}else if(interval>(3600*24*30)){
					
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd HH:MM");
					niCommentVO.setShowTime(simpleDateFormat.format(commentTime));
					
				}
				//将对象放入集合
				goodList.add(niCommentVO);
//				System.out.println(niCommentVO.getShowTime());
				
			}
			
		}
		
		ajaxResult.put("commentNum", commentNum);
		ajaxResult.put("commentList", newList);
		ajaxResult.put("goodCommentList", goodList);
		
		return ajaxResult;
	}

	//点赞
	public AjaxResult praiseComment(HttpServletRequest request) {
		String commentId = request.getParameter("commentId");
		String likeNum = request.getParameter("likeNum");
		
		AjaxResult ajaxResult = new AjaxResult();
		
		Map<String, Object> hashMap = new HashMap<String, Object>();
		
		if(StrUtils.isNotEmpty(commentId)){
			hashMap.put("commentId", commentId);
		}
		if(StrUtils.isNotEmpty(likeNum)){
			hashMap.put("likeNum", likeNum);
		}
		
//		List<String> arrayList = new ArrayList<String>();
		//判断是否为新用户, 如果是新用户可以点赞, 如果老用户,提示已经赞过
		
//		Object attribute = request.getSession().getAttribute("userId");
//		String user_Id = "";
//		if(attribute!=null){
//			user_Id = attribute.toString();
//		}
		
//		if(arrayList.contains(user_Id)){
//			
//			return AjaxResult.errorResult("你已经赞过!");
//		}else{
//			arrayList.add(user_Id);
//		}
		
		//根据评论id,将点赞数量+1
		try {
			int updateLikeNum = niCommentMapper.updateLikeNum(hashMap);
			if(updateLikeNum>0){
				ajaxResult.put("success", true);
				ajaxResult.put("msg", "成功");
			}else{
				return AjaxResult.errorCode("出现异常", "001");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return AjaxResult.errorCode("出现异常", "001");
		}
		
		return ajaxResult;
	}

	
	
}
