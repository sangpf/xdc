package com.newins.service.imp;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newins.dao.SubmitVoteDao;
import com.newins.dao.VoteResultDao;
import com.newins.model.VoteData;
import com.newins.model.VoteDeliveryItem;
import com.newins.model.VoteOptionData;
import com.newins.model.VqnItem;
import com.newins.model.VqnOption;
import com.newins.service.LoadVqnService;
import com.newins.service.VoteResultService;

/**@Description  
 * @author MaNia_chAng
 * @time 2016年11月21日 下午8:57:18
 */
@Service
public class VoteResultServiceImp implements VoteResultService{
	
	@Resource
	private LoadVqnService loadVqnService;
	@Resource
	private VoteResultDao voteResultDao;
	@Resource
	private SubmitVoteDao submitVoteDao;
	
	//查询和统计投票结果
//	@Transactional
	public VoteData getVoteData(int vqnId,int deliveryId,int userId){
		VoteData voteData = new VoteData();
		//查询投票问卷信息（主要用到optionNum和optionDes）
		VqnItem vqnItem = loadVqnService.loadVqn(vqnId);
		List<VqnOption> vqnOption = vqnItem.getOptions();
		int optionNum = vqnItem.getOptionNum();
		voteData.setOptionNum(optionNum);
		
		//查询用户答案
		Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("userId", userId);
		hashMap.put("vqnId", vqnId);
		String userAnswer = voteResultDao.getUserAnswer(hashMap);
		voteData.setUserAnswer(userAnswer);
		
		int totalAmount = 0;//初始化选项总票数计数器
		
		//初始化每个选项票数计数器
		int[] amount = new int[26];
		for (int i = 0; i <26; i++) {
			amount[i]=0;
		}
		//取某个投票的答案,统计每个选项的票数
		List<String> choice = voteResultDao.getChoice(vqnId);
		for (int i = 0; i < choice.size(); i++){
			char [] choiceCharArray = choice.get(i).toCharArray();
				totalAmount = totalAmount+choiceCharArray.length;
			for(int j = 0;j < choiceCharArray.length;j++){
				switch(choiceCharArray[j]){
				case 'A':
					amount[0] = amount[0]+1;
					break;
				case 'B':
					amount[1] = amount[1]+1;
					break;
				case 'C':
					amount[2] = amount[2]+1;
					break;
				case 'D':
					amount[3] = amount[3]+1;
					break;	
				case 'E':
					amount[4] = amount[4]+1;
					break;
				case 'F':
					amount[5] = amount[5]+1;
					break;
				case 'G':
					amount[6] = amount[6]+1;
					break;
				case 'H':
					amount[7] = amount[7]+1;
					break;
				case 'I':
					amount[8] = amount[8]+1;
					break;
				case 'J':
					amount[9] = amount[9]+1;
					break;
				case 'K':
					amount[10] = amount[10]+1;
					break;
				case 'L':
					amount[11] = amount[11]+1;
					break;
				case 'M':
					amount[12] = amount[12]+1;
					break;
				case 'N':
					amount[13] = amount[13]+1;
					break;
				case 'O':
					amount[14] = amount[14]+1;
					break;
				case 'P':
					amount[15] = amount[15]+1;
					break;
				case 'Q':
					amount[16] = amount[16]+1;
					break;
				case 'R':
					amount[17] = amount[17]+1;
					break;
				case 'S':
					amount[18] = amount[18]+1;
					break;
				case 'T':
					amount[19] = amount[19]+1;
					break;
				case 'U':
					amount[20] = amount[20]+1;
					break;
				case 'V':
					amount[21] = amount[21]+1;
					break;
				case 'W':
					amount[22] = amount[22]+1;
					break;
				case 'X':
					amount[23] = amount[23]+1;
					break;
				case 'Y':
					amount[24] = amount[24]+1;
					break;
				case 'Z':
					amount[25] = amount[25]+1;
					break;
				}
			}
		}		
		voteData.setTotalAmount(totalAmount);
		
		//从从订单数量和运营调整数量统计参与人数(在第二步判断是否收满时已经查询过参与人数了)
		VoteDeliveryItem voteDeliveryItem = submitVoteDao.getCollectAndCollectedNumById(deliveryId);
		voteData.setParticipant(voteDeliveryItem.getCollectedNum());
		//获得每个选项的比例
		List<VoteOptionData> voteOptionDataList = new ArrayList<VoteOptionData>();
		DecimalFormat df = new DecimalFormat("0.00");//设置小数的格式
		List<String> optionDes = new ArrayList<>();
		for(int i=0;i<optionNum;i++){
			//存放选项描述
			String optionDesItem = vqnOption.get(i).getOptionDes();
			optionDes.add(optionDesItem);
			//初始化一个选项对象，设置其属性值
			VoteOptionData voteOptionData = new VoteOptionData();
			voteOptionData.setOptionId(i+1);
			voteOptionData.setOptionAmount(amount[i]);
			double percentDouble = (double)amount[i]/totalAmount;
			
			//格式化小数，保留两位,将voteOptionData写入List			
			String percent = df.format(percentDouble);
			voteOptionData.setOptionPercent(percent);
			voteOptionDataList.add(voteOptionData);
		}
		//设置外层对象的属性值
		voteData.setVoteOptionData(voteOptionDataList);
		
		//获取选项描述
		voteData.setOptionDes(optionDes);
		voteData.setSuccess("true");
		voteData.setComments("successfully get voteResult");
		
		return voteData;	
	}

}
