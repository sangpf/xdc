package com.newins.dao;

import com.newins.model.NiAssessDeliveryWanxFlow;
import com.newins.model.NiReportFlow;
import com.newins.model.NiSurveyDeliveryWanxFlow;
import com.newins.model.NiVoteWanxFlow;

public interface FlowStatisticsMapper {
	int insertNiSurveyDeliveryWanxFlow(
			NiSurveyDeliveryWanxFlow niSurveyDeliveryWanxFlow);

	int insertNiAssessDeliveryWanxFlow(
			NiAssessDeliveryWanxFlow niAssessDeliveryWanxFlow);

	int insertNiVoteWanxFlow(NiVoteWanxFlow niVoteWanxFlow);

	int insertNiReportFlow(NiReportFlow niReportFlow);
}
