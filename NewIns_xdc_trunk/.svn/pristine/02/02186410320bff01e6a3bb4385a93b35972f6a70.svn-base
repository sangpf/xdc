package com.newins.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.dao.QnAdvertDao;
import com.newins.model.QnAdvert;
import com.newins.service.QnAdvertService;

/**
 * @Description 答题结果页广告Service
 * @author Guan
 * @time 2016年5月23日 下午2:09:43
 */
@Service(value = "QnAdvertService")
public class QnAdvertServiceImp implements QnAdvertService{

	@Autowired
	private QnAdvertDao qnAdvDao;

	/**
	 * @Title: getQnAdvert  
	 * @Author: Guan
	 * @Description: 通过投放ID加载相应的答题广告信息
	 * @param deliveryId
	 * @return qnAdv
	 * @Time 2016年5月23日 下午8:25:14
	 */
	public QnAdvert getQnAdvert(int deliveryId) {
		System.out.println("this is service: getQnAdvert() ");
		QnAdvert qnAdv = qnAdvDao.getQnAdvert(deliveryId);
		return qnAdv;

	}

}
