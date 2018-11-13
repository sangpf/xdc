package com.newins.service.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.dao.LotteryAwardMapper;
import com.newins.model.LotteryAward;
import com.newins.service.LotteryAwardService;

/**
 * @Description
 * @author MaNia_chAng
 * @time 2016年7月4日 下午2:50:32
 */
@Service
public class LotteryAwardServiceImp implements LotteryAwardService {

	@Autowired
	private LotteryAwardMapper lotteryAwardMapper;

	public List<LotteryAward> getLotteryAward(int deliveryId, int qnType,
			int channel, int awardMethod) {
		List<LotteryAward> awards = new ArrayList<>();// 初始化最终返回奖品信息list
		for (int i = 0; i < 3; i++) {
			LotteryAward awardItem = new LotteryAward();
			// 一次查询每个等级奖品的信息
			Map<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("deliveryId", deliveryId);
			hashMap.put("qnType", qnType);
			hashMap.put("channel", channel);
			hashMap.put("awardRank", i + 1);
			// 判断是随机抽奖还是倾向型抽奖
			if (awardMethod == 2) {// 随机抽奖
				awardItem = lotteryAwardMapper.getLotteryAward(hashMap);
				double awardQty = Double.parseDouble(awardItem.getAwardQty());
				if (awardQty >= 1) {
					String tempAwardQtyStr = String.valueOf(awardQty);
					String AwardQtyStrArr[] = tempAwardQtyStr.split("\\.");// 按小数点对字符串进行拆分
					awardItem.setAwardQty(AwardQtyStrArr[0] + "个");
				} else {
					awardItem.setAwardQty(String.valueOf(awardQty * 100) + "%");
				}
			} else if (awardMethod == 3) {// 倾向型抽奖
				awardItem = lotteryAwardMapper.getLotteryPreferAward(hashMap);
			}

			awardItem.setAwardRank(i + 1);

			awards.add(awardItem);
		}

		return awards;

	}

}
