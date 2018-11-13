package com.newins.service;

import com.newins.model.NiAssessDeliveryWanxFlow;
import com.newins.model.NiReportFlow;
import com.newins.model.NiSurveyDeliveryWanxFlow;
import com.newins.model.NiVoteWanxFlow;

/**
 * @Description 流水统计
 * @author wanq
 *
 */
public interface FlowStatisticsService {
	int insertNiSurveyDeliveryWanxFlow(NiSurveyDeliveryWanxFlow niSurveyDeliveryWanxFlow);
	int insertNiAssessDeliveryWanxFlow(NiAssessDeliveryWanxFlow niAssessDeliveryWanxFlow);
	int insertNiVoteWanxFlow(NiVoteWanxFlow niVoteWanxFlow);
	int insertNiReportFlow(NiReportFlow niReportFlow);
}
