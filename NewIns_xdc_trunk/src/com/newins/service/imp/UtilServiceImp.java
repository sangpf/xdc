/**
 * 
 */
package com.newins.service.imp;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newins.dao.UtilMapper;
import com.newins.model.AssessDeliveryInfo;
import com.newins.model.SurveyDeliveryInfo;
import com.newins.model.VoteDeliveryInfo;
import com.newins.service.UtilService;
import com.newins.util.AjaxResult;

/**
 * @Description
 * @author Guan
 * @time 2017年1月16日 下午2:45:03
 */
@Service
public class UtilServiceImp implements UtilService {
	@Resource
	private UtilMapper utilMapper;

	@SuppressWarnings("unused")
	public Object updateRelatedUrl(String version, int qnType) {
		// 根据问卷类型加载出投放信息
		if (qnType == 1) {
			List<SurveyDeliveryInfo> svyDeliveryInfoListUpdate = new ArrayList<SurveyDeliveryInfo>();
			List<SurveyDeliveryInfo> svyDeliveryInfoList = utilMapper
					.getSurveyDeliveryInfo();
			if (svyDeliveryInfoList != null) {
				for (int i = 0; i < svyDeliveryInfoList.size(); i++) {// 遍历list
					SurveyDeliveryInfo svyDelivery = svyDeliveryInfoList.get(i);
					int deliveryId = svyDelivery.getDeliveryId();
					String newRelatedUrl1;
					String newRelatedUrl2;
					String newRelatedUrl3;
					String relatedUrl1 = svyDelivery.getRelatedUrl1();
					String relatedUrl2 = svyDelivery.getRelatedUrl2();
					String relatedUrl3 = svyDelivery.getRelatedUrl3();
					newRelatedUrl1 = relatedUrl1;
					newRelatedUrl2 = relatedUrl2;
					newRelatedUrl3 = relatedUrl3;
					if (relatedUrl1 != null || relatedUrl2 != null
							|| relatedUrl3 != null) {
						if (relatedUrl1 != null
								&& relatedUrl1.contains("version=")) {
							String[] s = relatedUrl1.split("version=");
							newRelatedUrl1 = s[0] + "version=" + version
									+ s[1].substring(3);
						}
						if (relatedUrl2 != null
								&& relatedUrl2.contains("version=")) {
							String[] s = relatedUrl2.split("version=");
							newRelatedUrl2 = s[0] + "version=" + version
									+ s[1].substring(3);
						}
						if (relatedUrl3 != null
								&& relatedUrl3.contains("version=")) {
							String[] s = relatedUrl3.split("version=");
							newRelatedUrl3 = s[0] + "version=" + version
									+ s[1].substring(3);
						}
						if (!(relatedUrl1.equals(newRelatedUrl1)
								&& relatedUrl2.equals(newRelatedUrl2) && relatedUrl3
									.equals(newRelatedUrl3))) {
							SurveyDeliveryInfo newSurveyDelivery = new SurveyDeliveryInfo();
							newSurveyDelivery.setDeliveryId(deliveryId);
							newSurveyDelivery.setRelatedUrl1(newRelatedUrl1);
							newSurveyDelivery.setRelatedUrl2(newRelatedUrl2);
							newSurveyDelivery.setRelatedStr3(newRelatedUrl3);
							svyDeliveryInfoListUpdate.add(newSurveyDelivery);
						}
					} else
						continue;
				}
			}
			if (svyDeliveryInfoListUpdate != null) {
				return utilMapper
						.updateSurveyRelatedUrl(svyDeliveryInfoListUpdate);
			} else {
				return AjaxResult.successInfo("success", "no update record");
			}
		} else if (qnType == 2) {
			List<AssessDeliveryInfo> assessDeliveryInfoListUpdate = new ArrayList<AssessDeliveryInfo>();
			List<AssessDeliveryInfo> assessDeliveryInfoList = utilMapper
					.getAssessDeliveryInfo();
			if (assessDeliveryInfoList != null) {
				for (int i = 0; i < assessDeliveryInfoList.size(); i++) {// 遍历list
					AssessDeliveryInfo assessDelivery = assessDeliveryInfoList
							.get(i);
					int deliveryId = assessDelivery.getDeliveryId();
					String newRelatedUrl1;
					String newRelatedUrl2;
					String newRelatedUrl3;
					String relatedUrl1 = assessDelivery.getRelatedUrl1();
					String relatedUrl2 = assessDelivery.getRelatedUrl2();
					String relatedUrl3 = assessDelivery.getRelatedUrl3();
					newRelatedUrl1 = relatedUrl1;
					newRelatedUrl2 = relatedUrl2;
					newRelatedUrl3 = relatedUrl3;
					if (relatedUrl1 != null || relatedUrl2 != null
							|| relatedUrl3 != null) {
						if (relatedUrl1 != null
								&& relatedUrl1.contains("version=")) {
							String[] s = relatedUrl1.split("version=");
							newRelatedUrl1 = s[0] + "version=" + version
									+ s[1].substring(3);
						}
						if (relatedUrl2 != null
								&& relatedUrl2.contains("version=")) {
							String[] s = relatedUrl2.split("version=");
							newRelatedUrl2 = s[0] + "version=" + version
									+ s[1].substring(3);
						}
						if (relatedUrl3 != null
								&& relatedUrl3.contains("version=")) {
							String[] s = relatedUrl3.split("version=");
							newRelatedUrl3 = s[0] + "version=" + version
									+ s[1].substring(3);
						}
						if (!(relatedUrl1.equals(newRelatedUrl1)
								&& relatedUrl2.equals(newRelatedUrl2) && relatedUrl3
									.equals(newRelatedUrl3))) {
							AssessDeliveryInfo newAssessDelivery = new AssessDeliveryInfo();
							newAssessDelivery.setDeliveryId(deliveryId);
							newAssessDelivery.setRelatedUrl1(newRelatedUrl1);
							newAssessDelivery.setRelatedUrl2(newRelatedUrl2);
							newAssessDelivery.setRelatedStr3(newRelatedUrl3);
							assessDeliveryInfoListUpdate.add(newAssessDelivery);
						}
					} else
						continue;
				}
			}
			if (assessDeliveryInfoListUpdate.size() != 0) {
				return utilMapper
						.updateAssessRelatedUrl(assessDeliveryInfoListUpdate);
			} else {
				return AjaxResult.successInfo("success", "no update record");
			}
		} else if (qnType == 3) {
			List<VoteDeliveryInfo> assessDeliveryInfoListUpdate = new ArrayList<VoteDeliveryInfo>();
			List<VoteDeliveryInfo> assessDeliveryInfoList = utilMapper
					.getVoteDeliveryInfo();
			if (assessDeliveryInfoList != null) {
				for (int i = 0; i < assessDeliveryInfoList.size(); i++) {// 遍历list
					VoteDeliveryInfo voteDelivery = assessDeliveryInfoList
							.get(i);
					int deliveryId = voteDelivery.getDeliveryId();
					String newRelatedUrl1;
					String newRelatedUrl2;
					String newRelatedUrl3;
					String relatedUrl1 = voteDelivery.getRelatedUrl1();
					String relatedUrl2 = voteDelivery.getRelatedUrl2();
					String relatedUrl3 = voteDelivery.getRelatedUrl3();
					newRelatedUrl1 = relatedUrl1;
					newRelatedUrl2 = relatedUrl2;
					newRelatedUrl3 = relatedUrl3;
					if (relatedUrl1 != null || relatedUrl2 != null
							|| relatedUrl3 != null) {
						if (relatedUrl1.contains("version=")) {
							String[] s = relatedUrl1.split("version=");
							newRelatedUrl1 = s[0] + "version=" + version
									+ s[1].substring(3);
						}
						if (relatedUrl2.contains("version=")) {
							String[] s = relatedUrl2.split("version=");
							newRelatedUrl2 = s[0] + "version=" + version
									+ s[1].substring(3);
						}
						if (relatedUrl3.contains("version=")) {
							String[] s = relatedUrl3.split("version=");
							newRelatedUrl3 = s[0] + "version=" + version
									+ s[1].substring(3);
						}
						if (!(relatedUrl1.equals(newRelatedUrl1)
								&& relatedUrl2.equals(newRelatedUrl2) && relatedUrl3
									.equals(newRelatedUrl3))) {
							VoteDeliveryInfo newVoteDelivery = new VoteDeliveryInfo();
							newVoteDelivery.setDeliveryId(deliveryId);
							newVoteDelivery.setRelatedUrl1(newRelatedUrl1);
							newVoteDelivery.setRelatedUrl2(newRelatedUrl2);
							newVoteDelivery.setRelatedStr3(newRelatedUrl3);
							assessDeliveryInfoListUpdate.add(newVoteDelivery);
						}
					} else
						continue;
				}
			}
			if (assessDeliveryInfoListUpdate != null) {
				return utilMapper
						.updateVoteRelatedUrl(assessDeliveryInfoListUpdate);
			} else {
				return AjaxResult.successInfo("success", "no update record");
			}
		} else {
			return AjaxResult.errorResult("qnType is wrong");
		}
	}
}
