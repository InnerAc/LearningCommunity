package com.lst.lc.entities;

// Generated 2015-7-18 14:55:52 by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Direction generated by hbm2java
 */
@Entity
@Table(name = "direction", catalog = "LearningCommunity")
public class Direction implements java.io.Serializable {

	private Integer directionId;
	private Admin admin;
	private String directionName;
	private Date time;
	private String description;
	private String enabled;
	private Set<Category> categories = new HashSet<Category>(0);
	private Set<Course> courses = new HashSet<Course>(0);

	public Direction() {
	}

	public Direction(Admin admin, String directionName, Date time,
			String description, String enabled) {
		this.admin = admin;
		this.directionName = directionName;
		this.time = time;
		this.description = description;
		this.enabled = enabled;
	}

	public Direction(Admin admin, String directionName, Date time,
			String description, String enabled, Set<Category> categories,
			Set<Course> courses) {
		this.admin = admin;
		this.directionName = directionName;
		this.time = time;
		this.description = description;
		this.enabled = enabled;
		this.categories = categories;
		this.courses = courses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "directionId", unique = true, nullable = false)
	public Integer getDirectionId() {
		return this.directionId;
	}

	public void setDirectionId(Integer directionId) {
		this.directionId = directionId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "adminId", nullable = false)
	public Admin getAdmin() {
		return this.admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Column(name = "directionName", nullable = false, length = 20)
	public String getDirectionName() {
		return this.directionName;
	}

	public void setDirectionName(String directionName) {
		this.directionName = directionName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time", nullable = false, length = 19)
	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Column(name = "description", nullable = false, length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "enabled", nullable = false, length = 10)
	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "direction")
	public Set<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "direction")
	public Set<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

}
