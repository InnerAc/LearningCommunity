package com.lst.lc.entities;

// Generated 2015-7-17 15:33:27 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Rank generated by hbm2java
 */
@Entity
@Table(name = "rank", catalog = "LearningCommunity")
public class Rank implements java.io.Serializable {

	private String rankName;
	private int integral;

	public Rank() {
	}

	public Rank(String rankName, int integral) {
		this.rankName = rankName;
		this.integral = integral;
	}

	@Id
	@Column(name = "rankName", unique = true, nullable = false, length = 50)
	public String getRankName() {
		return this.rankName;
	}

	public void setRankName(String rankName) {
		this.rankName = rankName;
	}

	@Column(name = "integral", nullable = false)
	public int getIntegral() {
		return this.integral;
	}

	public void setIntegral(int integral) {
		this.integral = integral;
	}

}
