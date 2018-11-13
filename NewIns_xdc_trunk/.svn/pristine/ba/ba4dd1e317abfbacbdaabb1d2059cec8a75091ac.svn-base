package com.newins.dao;
/**
 * 评论相关
 */
import java.util.List;
import java.util.Map;

import com.newins.model.NiComment;
import com.newins.model.NiCommentVO;


public interface NiCommentMapper {
	
	//保存评论
	int insert(NiComment recode);
	
	//列表查询
	List<NiCommentVO> listNiComment(Map<String, Object> map);
	
	//查询点赞数大于50 前三个
	List<NiCommentVO> goodCommentList(Map<String, Object> map);
	
	//点赞
	int updateLikeNum(Map<String, Object> map);
	
	//查询评论记录数
	int findCount(Map<String, Object> map);
	
}
