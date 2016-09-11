package com.fab.inventory.domain;

import java.util.Date;

public interface BaseDomain {

	public String getId();

	public void setId(String id);

	public Integer getVersion();

	public void setVersion(Integer version);

	String getCreatedBy();

	public void setCreatedBy(String createdBy);

	Date getCreatedDate();

	String getUpdatedBy();

	void setUpdatedBy(String updatedBy);

	Date getUpdatedDate();
}
