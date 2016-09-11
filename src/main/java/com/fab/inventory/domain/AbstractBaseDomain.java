package com.fab.inventory.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@MappedSuperclass
public class AbstractBaseDomain implements BaseDomain, Serializable {

	private static final long serialVersionUID = 98457373648389287L;

	@Id
	private String id = IdGenerator.createId();

	@Version
	private Integer version;

	@Column(name = "created_by")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", updatable = false)
	private Date createdDate = new Date();

	@Column(name = "updated_by")
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date")
	private Date updatedDate = new Date();

	@PreUpdate
	public void setLastUpdate() {
		this.updatedDate = new Date();
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public boolean equals(Object o) {

		if (o == null)
			return false;
		else if (this == o)
			return true;
		else if (!this.getClass().equals(o.getClass())) {
			return false;
		}
		BaseDomain other = (BaseDomain) o;
		if (this.id != null && other.getId() != null && this.id.equals(other.getId())) {
			return true;
		}
		return false;
	}

	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());

		return result;
	}

	public String toString() {
		return this.getClass().getName() + ":" + getId();
	}

	static class IdGenerator {
		public static String createId() {
			UUID uuid = java.util.UUID.randomUUID();
			return uuid.toString();
		}
	}
}