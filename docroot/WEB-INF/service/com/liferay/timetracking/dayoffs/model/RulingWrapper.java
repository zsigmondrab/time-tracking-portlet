/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.timetracking.dayoffs.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Ruling}.
 * </p>
 *
 * @author LĂˇszlĂł HudĂˇk
 * @see Ruling
 * @generated
 */
public class RulingWrapper implements Ruling, ModelWrapper<Ruling> {
	public RulingWrapper(Ruling ruling) {
		_ruling = ruling;
	}

	@Override
	public Class<?> getModelClass() {
		return Ruling.class;
	}

	@Override
	public String getModelClassName() {
		return Ruling.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ruleId", getRuleId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("ruleName", getRuleName());
		attributes.put("multiplier", getMultiplier());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ruleId = (Long)attributes.get("ruleId");

		if (ruleId != null) {
			setRuleId(ruleId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String ruleName = (String)attributes.get("ruleName");

		if (ruleName != null) {
			setRuleName(ruleName);
		}

		Double multiplier = (Double)attributes.get("multiplier");

		if (multiplier != null) {
			setMultiplier(multiplier);
		}
	}

	/**
	* Returns the primary key of this ruling.
	*
	* @return the primary key of this ruling
	*/
	@Override
	public long getPrimaryKey() {
		return _ruling.getPrimaryKey();
	}

	/**
	* Sets the primary key of this ruling.
	*
	* @param primaryKey the primary key of this ruling
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_ruling.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the rule ID of this ruling.
	*
	* @return the rule ID of this ruling
	*/
	@Override
	public long getRuleId() {
		return _ruling.getRuleId();
	}

	/**
	* Sets the rule ID of this ruling.
	*
	* @param ruleId the rule ID of this ruling
	*/
	@Override
	public void setRuleId(long ruleId) {
		_ruling.setRuleId(ruleId);
	}

	/**
	* Returns the group ID of this ruling.
	*
	* @return the group ID of this ruling
	*/
	@Override
	public long getGroupId() {
		return _ruling.getGroupId();
	}

	/**
	* Sets the group ID of this ruling.
	*
	* @param groupId the group ID of this ruling
	*/
	@Override
	public void setGroupId(long groupId) {
		_ruling.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this ruling.
	*
	* @return the company ID of this ruling
	*/
	@Override
	public long getCompanyId() {
		return _ruling.getCompanyId();
	}

	/**
	* Sets the company ID of this ruling.
	*
	* @param companyId the company ID of this ruling
	*/
	@Override
	public void setCompanyId(long companyId) {
		_ruling.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this ruling.
	*
	* @return the user ID of this ruling
	*/
	@Override
	public long getUserId() {
		return _ruling.getUserId();
	}

	/**
	* Sets the user ID of this ruling.
	*
	* @param userId the user ID of this ruling
	*/
	@Override
	public void setUserId(long userId) {
		_ruling.setUserId(userId);
	}

	/**
	* Returns the user uuid of this ruling.
	*
	* @return the user uuid of this ruling
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ruling.getUserUuid();
	}

	/**
	* Sets the user uuid of this ruling.
	*
	* @param userUuid the user uuid of this ruling
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_ruling.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this ruling.
	*
	* @return the user name of this ruling
	*/
	@Override
	public java.lang.String getUserName() {
		return _ruling.getUserName();
	}

	/**
	* Sets the user name of this ruling.
	*
	* @param userName the user name of this ruling
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_ruling.setUserName(userName);
	}

	/**
	* Returns the create date of this ruling.
	*
	* @return the create date of this ruling
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _ruling.getCreateDate();
	}

	/**
	* Sets the create date of this ruling.
	*
	* @param createDate the create date of this ruling
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_ruling.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this ruling.
	*
	* @return the modified date of this ruling
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _ruling.getModifiedDate();
	}

	/**
	* Sets the modified date of this ruling.
	*
	* @param modifiedDate the modified date of this ruling
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_ruling.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the rule name of this ruling.
	*
	* @return the rule name of this ruling
	*/
	@Override
	public java.lang.String getRuleName() {
		return _ruling.getRuleName();
	}

	/**
	* Sets the rule name of this ruling.
	*
	* @param ruleName the rule name of this ruling
	*/
	@Override
	public void setRuleName(java.lang.String ruleName) {
		_ruling.setRuleName(ruleName);
	}

	/**
	* Returns the multiplier of this ruling.
	*
	* @return the multiplier of this ruling
	*/
	@Override
	public double getMultiplier() {
		return _ruling.getMultiplier();
	}

	/**
	* Sets the multiplier of this ruling.
	*
	* @param multiplier the multiplier of this ruling
	*/
	@Override
	public void setMultiplier(double multiplier) {
		_ruling.setMultiplier(multiplier);
	}

	@Override
	public boolean isNew() {
		return _ruling.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_ruling.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _ruling.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_ruling.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _ruling.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _ruling.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_ruling.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _ruling.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_ruling.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_ruling.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_ruling.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RulingWrapper((Ruling)_ruling.clone());
	}

	@Override
	public int compareTo(com.liferay.timetracking.dayoffs.model.Ruling ruling) {
		return _ruling.compareTo(ruling);
	}

	@Override
	public int hashCode() {
		return _ruling.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.timetracking.dayoffs.model.Ruling> toCacheModel() {
		return _ruling.toCacheModel();
	}

	@Override
	public com.liferay.timetracking.dayoffs.model.Ruling toEscapedModel() {
		return new RulingWrapper(_ruling.toEscapedModel());
	}

	@Override
	public com.liferay.timetracking.dayoffs.model.Ruling toUnescapedModel() {
		return new RulingWrapper(_ruling.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _ruling.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _ruling.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_ruling.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RulingWrapper)) {
			return false;
		}

		RulingWrapper rulingWrapper = (RulingWrapper)obj;

		if (Validator.equals(_ruling, rulingWrapper._ruling)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Ruling getWrappedRuling() {
		return _ruling;
	}

	@Override
	public Ruling getWrappedModel() {
		return _ruling;
	}

	@Override
	public void resetOriginalValues() {
		_ruling.resetOriginalValues();
	}

	private Ruling _ruling;
}