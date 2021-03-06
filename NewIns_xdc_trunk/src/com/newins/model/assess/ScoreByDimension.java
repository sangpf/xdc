package com.newins.model.assess;

import com.newins.model.AssessResult;

/**
 * 测评模型  查询每个维度的总得分 ,返回实体类封装
 * @author sang
 *
 */
public class ScoreByDimension extends AssessResult{
	
	private Integer dimension; //维度 编号
	
	private Integer priority; // 优先级
	
	private String dimensionStr;
	
	private Double score;  // MBTI类型查询 两个二级维度下 分数大的维度得分
	
	private Double avgScore;
	
	
	public Double getAvgScore() {
		return avgScore;
	}
	public void setAvgScore(Double avgScore) {
		this.avgScore = avgScore;
	}

	public Integer getDimension() {
		return dimension;
	}

	public void setDimension(Integer dimension) {
		this.dimension = dimension;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getDimensionStr() {
		return dimensionStr;
	}

	public void setDimensionStr(String dimensionStr) {
		this.dimensionStr = dimensionStr;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	
}
