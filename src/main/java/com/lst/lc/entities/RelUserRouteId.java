package com.lst.lc.entities;

// Generated 2015-7-18 9:37:36 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * RelUserRouteId generated by hbm2java
 */
@Embeddable
public class RelUserRouteId implements java.io.Serializable {

	private int userId;
	private int routeId;

	public RelUserRouteId() {
	}

	public RelUserRouteId(int userId, int routeId) {
		this.userId = userId;
		this.routeId = routeId;
	}

	@Column(name = "userId", nullable = false)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "routeId", nullable = false)
	public int getRouteId() {
		return this.routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RelUserRouteId))
			return false;
		RelUserRouteId castOther = (RelUserRouteId) other;

		return (this.getUserId() == castOther.getUserId())
				&& (this.getRouteId() == castOther.getRouteId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getUserId();
		result = 37 * result + this.getRouteId();
		return result;
	}

}
