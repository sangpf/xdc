package com.newins.service.imp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newins.dao.FlowStatisticsMapper;
import com.newins.model.NiAssessDeliveryWanxFlow;
import com.newins.model.NiReportFlow;
import com.newins.model.NiSurveyDeliveryWanxFlow;
import com.newins.model.NiVoteWanxFlow;
import com.newins.service.FlowStatisticsService;
@Service
public class FlowStatisticsServiceImp implements FlowStatisticsService{
	@Resource
	private FlowStatisticsMapper flowStatisticsMapper;
	@Override
	public int insertNiSurveyDeliveryWanxFlow(
			NiSurveyDeliveryWanxFlow niSurveyDeliveryWanxFlow) {
		int result = flowStatisticsMapper.insertNiSurveyDeliveryWanxFlow(niSurveyDeliveryWanxFlow);
		return result;
	}

	@Override
	public int insertNiAssessDeliveryWanxFlow(
			NiAssessDeliveryWanxFlow niAssessDeliveryWanxFlow) {
		int result = flowStatisticsMapper.insertNiAssessDeliveryWanxFlow(niAssessDeliveryWanxFlow);
		return result;
	}

	@Override
	public int insertNiVoteWanxFlow(NiVoteWanxFlow niVoteWanxFlow) {
		int result = flowStatisticsMapper.insertNiVoteWanxFlow(niVoteWanxFlow);
		return result;
	}

	@Override
	public int insertNiReportFlow(NiReportFlow niReportFlow) {
		int result = flowStatisticsMapper.insertNiReportFlow(niReportFlow);
		return result;
	}

}
