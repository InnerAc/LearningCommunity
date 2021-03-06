package com.lst.lc.entities;

// Generated 2015-7-18 14:55:52 by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * QuestionAnswer generated by hbm2java
 */
@Entity
@Table(name = "questionAnswer", catalog = "LearningCommunity")
public class QuestionAnswer implements java.io.Serializable {

	private Integer answerId;
	private Question question;
	private User user;
	private Date time;
	private String content;
	private String head;

	public QuestionAnswer() {
	}

	public QuestionAnswer(Question question, User user, Date time,
			String content) {
		this.question = question;
		this.user = user;
		this.time = time;
		this.content = content;
	}

	public QuestionAnswer(Question question, User user, Date time,
			String content, String head) {
		this.question = question;
		this.user = user;
		this.time = time;
		this.content = content;
		this.head = head;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "answerId", unique = true, nullable = false)
	public Integer getAnswerId() {
		return this.answerId;
	}

	public void setAnswerId(Integer answerId) {
		this.answerId = answerId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "questionId", nullable = false)
	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "authorId", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time", nullable = false, length = 19)
	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Column(name = "content", nullable = false, length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "head", length = 200)
	public String getHead() {
		return this.head;
	}

	public void setHead(String head) {
		this.head = head;
	}

}
