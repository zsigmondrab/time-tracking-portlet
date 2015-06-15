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
 * This class is a wrapper for {@link DaysOffCounter}.
 * </p>
 *
 * @author Laszlo Hudak
 * @see DaysOffCounter
 * @generated
 */
public class DaysOffCounterWrapper implements DaysOffCounter,
	ModelWrapper<DaysOffCounter> {
	public DaysOffCounterWrapper(DaysOffCounter daysOffCounter) {
		_daysOffCounter = daysOffCounter;
	}

	@Override
	public Class<?> getModelClass() {
		return DaysOffCounter.class;
	}

	@Override
	public String getModelClassName() {
		return DaysOffCounter.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dayOffCounterId", getDayOffCounterId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("workerUserId", getWorkerUserId());
		attributes.put("workerUserName", getWorkerUserName());
		attributes.put("ruleId", getRuleId());
		attributes.put("year", getYear());
		attributes.put("allDays", getAllDays());
		attributes.put("remainingDays", getRemainingDays());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dayOffCounterId = (Long)attributes.get("dayOffCounterId");

		if (dayOffCounterId != null) {
			setDayOffCounterId(dayOffCounterId);
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

		Long workerUserId = (Long)attributes.get("workerUserId");

		if (workerUserId != null) {
			setWorkerUserId(workerUserId);
		}

		String workerUserName = (String)attributes.get("workerUserName");

		if (workerUserName != null) {
			setWorkerUserName(workerUserName);
		}

		Long ruleId = (Long)attributes.get("ruleId");

		if (ruleId != null) {
			setRuleId(ruleId);
		}

		Integer year = (Integer)attributes.get("year");

		if (year != null) {
			setYear(year);
		}

		Integer allDays = (Integer)attributes.get("allDays");

		if (allDays != null) {
			setAllDays(allDays);
		}

		Integer remainingDays = (Integer)attributes.get("remainingDays");

		if (remainingDays != null) {
			setRemainingDays(remainingDays);
		}
	}

	/**
	* Returns the primary key of this days off counter.
	*
	* @return the primary key of this days off counter
	*/
	@Override
	public long getPrimaryKey() {
		return _daysOffCounter.getPrimaryKey();
	}

	/**
	* Sets the primary key of this days off counter.
	*
	* @param primaryKey the primary key of this days off counter
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_daysOffCounter.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the day off counter ID of this days off counter.
	*
	* @return the day off counter ID of this days off counter
	*/
	@Override
	public long getDayOffCounterId() {
		return _daysOffCounter.getDayOffCounterId();
	}

	/**
	* Sets the day off counter ID of this days off counter.
	*
	* @param dayOffCounterId the day off counter ID of this days off counter
	*/
	@Override
	public void setDayOffCounterId(long dayOffCounterId) {
		_daysOffCounter.setDayOffCounterId(dayOffCounterId);
	}

	/**
	* Returns the company ID of this days off counter.
	*
	* @return the company ID of this days off counter
	*/
	@Override
	public long getCompanyId() {
		return _daysOffCounter.getCompanyId();
	}

	/**
	* Sets the company ID of this days off counter.
	*
	* @param companyId the company ID of this days off counter
	*/
	@Override
	public void setCompanyId(long companyId) {
		_daysOffCounter.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this days off counter.
	*
	* @return the user ID of this days off counter
	*/
	@Override
	public long getUserId() {
		return _daysOffCounter.getUserId();
	}

	/**
	* Sets the user ID of this days off counter.
	*
	* @param userId the user ID of this days off counter
	*/
	@Override
	public void setUserId(long userId) {
		_daysOffCounter.setUserId(userId);
	}

	/**
	* Returns the user uuid of this days off counter.
	*
	* @return the user uuid of this days off counter
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _daysOffCounter.getUserUuid();
	}

	/**
	* Sets the user uuid of this days off counter.
	*
	* @param userUuid the user uuid of this days off counter
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_daysOffCounter.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this days off counter.
	*
	* @return the user name of this days off counter
	*/
	@Override
	public java.lang.String getUserName() {
		return _daysOffCounter.getUserName();
	}

	/**
	* Sets the user name of this days off counter.
	*
	* @param userName the user name of this days off counter
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_daysOffCounter.setUserName(userName);
	}

	/**
	* Returns the create date of this days off counter.
	*
	* @return the create date of this days off counter
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _daysOffCounter.getCreateDate();
	}

	/**
	* Sets the create date of this days off counter.
	*
	* @param createDate the create date of this days off counter
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_daysOffCounter.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this days off counter.
	*
	* @return the modified date of this days off counter
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _daysOffCounter.getModifiedDate();
	}

	/**
	* Sets the modified date of this days off counter.
	*
	* @param modifiedDate the modified date of this days off counter
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_daysOffCounter.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the worker user ID of this days off counter.
	*
	* @return the worker user ID of this days off counter
	*/
	@Override
	public long getWorkerUserId() {
		return _daysOffCounter.getWorkerUserId();
	}

	/**
	* Sets the worker user ID of this days off counter.
	*
	* @param workerUserId the worker user ID of this days off counter
	*/
	@Override
	public void setWorkerUserId(long workerUserId) {
		_daysOffCounter.setWorkerUserId(workerUserId);
	}

	/**
	* Returns the worker user uuid of this days off counter.
	*
	* @return the worker user uuid of this days off counter
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getWorkerUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _daysOffCounter.getWorkerUserUuid();
	}

	/**
	* Sets the worker user uuid of this days off counter.
	*
	* @param workerUserUuid the worker user uuid of this days off counter
	*/
	@Override
	public void setWorkerUserUuid(java.lang.String workerUserUuid) {
		_daysOffCounter.setWorkerUserUuid(workerUserUuid);
	}

	/**
	* Returns the worker user name of this days off counter.
	*
	* @return the worker user name of this days off counter
	*/
	@Override
	public java.lang.String getWorkerUserName() {
		return _daysOffCounter.getWorkerUserName();
	}

	/**
	* Sets the worker user name of this days off counter.
	*
	* @param workerUserName the worker user name of this days off counter
	*/
	@Override
	public void setWorkerUserName(java.lang.String workerUserName) {
		_daysOffCounter.setWorkerUserName(workerUserName);
	}

	/**
	* Returns the rule ID of this days off counter.
	*
	* @return the rule ID of this days off counter
	*/
	@Override
	public long getRuleId() {
		return _daysOffCounter.getRuleId();
	}

	/**
	* Sets the rule ID of this days off counter.
	*
	* @param ruleId the rule ID of this days off counter
	*/
	@Override
	public void setRuleId(long ruleId) {
		_daysOffCounter.setRuleId(ruleId);
	}

	/**
	* Returns the year of this days off counter.
	*
	* @return the year of this days off counter
	*/
	@Override
	public int getYear() {
		return _daysOffCounter.getYear();
	}

	/**
	* Sets the year of this days off counter.
	*
	* @param year the year of this days off counter
	*/
	@Override
	public void setYear(int year) {
		_daysOffCounter.setYear(year);
	}

	/**
	* Returns the all days of this days off counter.
	*
	* @return the all days of this days off counter
	*/
	@Override
	public int getAllDays() {
		return _daysOffCounter.getAllDays();
	}

	/**
	* Sets the all days of this days off counter.
	*
	* @param allDays the all days of this days off counter
	*/
	@Override
	public void setAllDays(int allDays) {
		_daysOffCounter.setAllDays(allDays);
	}

	/**
	* Returns the remaining days of this days off counter.
	*
	* @return the remaining days of this days off counter
	*/
	@Override
	public int getRemainingDays() {
		return _daysOffCounter.getRemainingDays();
	}

	/**
	* Sets the remaining days of this days off counter.
	*
	* @param remainingDays the remaining days of this days off counter
	*/
	@Override
	public void setRemainingDays(int remainingDays) {
		_daysOffCounter.setRemainingDays(remainingDays);
	}

	@Override
	public boolean isNew() {
		return _daysOffCounter.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_daysOffCounter.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _daysOffCounter.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_daysOffCounter.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _daysOffCounter.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _daysOffCounter.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_daysOffCounter.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _daysOffCounter.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_daysOffCounter.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_daysOffCounter.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_daysOffCounter.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DaysOffCounterWrapper((DaysOffCounter)_daysOffCounter.clone());
	}

	@Override
	public int compareTo(DaysOffCounter daysOffCounter) {
		return _daysOffCounter.compareTo(daysOffCounter);
	}

	@Override
	public int hashCode() {
		return _daysOffCounter.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<DaysOffCounter> toCacheModel() {
		return _daysOffCounter.toCacheModel();
	}

	@Override
	public DaysOffCounter toEscapedModel() {
		return new DaysOffCounterWrapper(_daysOffCounter.toEscapedModel());
	}

	@Override
	public DaysOffCounter toUnescapedModel() {
		return new DaysOffCounterWrapper(_daysOffCounter.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _daysOffCounter.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _daysOffCounter.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_daysOffCounter.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DaysOffCounterWrapper)) {
			return false;
		}

		DaysOffCounterWrapper daysOffCounterWrapper = (DaysOffCounterWrapper)obj;

		if (Validator.equals(_daysOffCounter,
					daysOffCounterWrapper._daysOffCounter)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public DaysOffCounter getWrappedDaysOffCounter() {
		return _daysOffCounter;
	}

	@Override
	public DaysOffCounter getWrappedModel() {
		return _daysOffCounter;
	}

	@Override
	public void resetOriginalValues() {
		_daysOffCounter.resetOriginalValues();
	}

	private DaysOffCounter _daysOffCounter;
}