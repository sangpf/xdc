package com.newins.util;

import java.util.HashMap;
import java.util.Map;

/**@Description  根据输入中奖奖概率或数量、参与人数，随机生成中奖名单
 * @author MaNia_chAng
 * @time 2016年5月30日 下午11:28:46
 */
public class LotteryGenerator {

	/**
	 * @Title: lotteryGenerator  
	 * @Author: MaNia_chAng
	 * @Description: 根据输入中奖奖概率或数量、参与人数，随机生成中奖名单
	 * @param levelsOfRewards
	 * @param participants void
	 * @Time 2016年5月31日 下午3:10:59
	 */
	public static int[] lotteryGenerator(double[] levelsOfRewards, int participants) {
		int[] winner = new int[participants];
		for (int i = 0; i <participants; i++) {
			winner[i]=0;
		}
		for (int i = 0; i < levelsOfRewards.length; i++) {
			int currentLevel = levelsOfRewards.length - i;
			if (levelsOfRewards[i] < 1) {
				generatorByProb(levelsOfRewards[i], winner, currentLevel, participants);
			} else if (levelsOfRewards[i] >= 1) {
				generatorByNumbers(levelsOfRewards[i], winner, currentLevel, participants);
			}
		}
		return winner;
	}

	/**
	 * @Title: generatorByProb  
	 * @Author: MaNia_chAng
	 * @Description: 根据中奖概率生成中奖名单
	 * @param targetProb
	 * @param winner
	 * @param currentLevel
	 * @param participants void
	 * @Time 2016年6月1日 上午9:55:36
	 */
	public static void generatorByProb(double targetProb, int[] winner, int currentLevel,
			int participants) {
		Map<Double, Double> valueMap = new HashMap<Double, Double>();
		valueMap.put(0.05, 0.0038);
		valueMap.put(0.1, 0.01475);
		valueMap.put(0.15, 0.03221);
		valueMap.put(0.2, 0.0557);
		valueMap.put(0.25, 0.08475);
		valueMap.put(0.3, 0.11895);
		valueMap.put(0.35, 0.14628);
		valueMap.put(0.4, 0.18128);
		valueMap.put(0.5, 0.25701);
		valueMap.put(0.55, 0.29509);
		valueMap.put(0.6, 0.33324);

		double probIterator = valueMap.get(targetProb);
		double probability = probIterator;

		for (int i = 0; i < participants; i++) {
			if (hit(probability) == true) {
				probability = probIterator;
				winner[i] = currentLevel;
			} else {
				probability = probability + probIterator;
			}
		}
	}

	/**
	 * @Title: hit  
	 * @Author: MaNia_chAng
	 * @Description: 生成随机数判断某个人中奖与否
	 * @param probability
	 * @return boolean
	 * @Time 2016年5月31日 下午3:14:43
	 */
	public static boolean hit(double probability) {
		double randomNumber = Math.random();
		if (randomNumber < probability) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @Title: generatorByNumbers  
	 * @Author: MaNia_chAng
	 * @Description: 根据中奖数量生成中奖名单，随机数为0时重新生成，随机数重复时重新生成。
	 * @param numbersOfRewards
	 * @param winner
	 * @param currentLevel
	 * @param participants void
	 * @Time 2016年6月1日 上午9:54:54
	 */
	public static void generatorByNumbers(double numbersOfRewards,int[] winner, int currentLevel,int participants) {
		for (int i = 0; i < (int) numbersOfRewards; i++) {
			int win = (int) ((Math.random()) * participants);
			while(win==0){
				win = (int) ((Math.random()) * participants);
			}
			
			int duplicationCheck = winner[win];
			if (duplicationCheck == currentLevel) {
				do {
					win = (int) ((Math.random()) * participants);
					duplicationCheck = winner[win];
				} while (duplicationCheck == currentLevel);
				winner[win] = currentLevel;
			} else {
				winner[win] = currentLevel;
			}
		}
	}

	public static void main(String args[]) {
		double[] levelsOfRewards = { 0.4,0.1,10,1 };
		int participants = 1000;
		int[] winner = new int[participants];
		winner=lotteryGenerator(levelsOfRewards, participants);
		for(int i=0;i<participants;i++){
			System.out.println(winner[i]);
		}
	}
}
