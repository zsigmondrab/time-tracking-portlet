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
 * This class is a wrapper for {@link DaysOfYear}.
 * </p>
 *
 * @author LÃ¡szlÃ³ HudÃ¡k
 * @see DaysOfYear
 * @generated
 */
public class DaysOfYearWrapper implements DaysOfYear, ModelWrapper<DaysOfYear> {
	public DaysOfYearWrapper(DaysOfYear daysOfYear) {
		_daysOfYear = daysOfYear;
	}

	@Override
	public Class<?> getModelClass() {
		return DaysOfYear.class;
	}

	@Override
	public String getModelClassName() {
		return DaysOfYear.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dayOfYearId", getDayOfYearId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("dayId", getDayId());
		attributes.put("ruleId", getRuleId());
		attributes.put("classNameId", getClassNameId());
		attributes.put("classPK", getClassPK());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dayOfYearId = (Long)attributes.get("dayOfYearId");

		if (dayOfYearId != null) {
			setDayOfYearId(dayOfYearId);
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

		Date dayId = (Date)attributes.get("dayId");

		if (dayId != null) {
			setDayId(dayId);
		}

		Long ruleId = (Long)attributes.get("ruleId");

		if (ruleId != null) {
			setRuleId(ruleId);
		}

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}
	}

	/**
	* Returns the primary key of this days of year.
	*
	* @return the primary key of this days of year
	*/
	@Override
	public long getPrimaryKey() {
		return _daysOfYear.getPrimaryKey();
	}

	/**
	* Sets the primary key of this days of year.
	*
	* @param primaryKey the primary key of this days of year
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_daysOfYear.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the day of year ID of this days of year.
	*
	* @return the day of year ID of this days of year
	*/
	@Override
	public long getDayOfYearId() {
		return _daysOfYear.getDayOfYearId();
	}

	/**
	* Sets the day of year ID of this days of year.
	*
	* @param dayOfYearId the day of year ID of this days of year
	*/
	@Override
	public void setDayOfYearId(long dayOfYearId) {
		_daysOfYear.setDayOfYearId(dayOfYearId);
	}

	/**
	* Returns the group ID of this days of year.
	*
	* @return the group ID of this days of year
	*/
	@Override
	public long getGroupId() {
		return _daysOfYear.getGroupId();
	}

	/**
	* Sets the group ID of this days of year.
	*
	* @param groupId the group ID of this days of year
	*/
	@Override
	public void setGroupId(long groupId) {
		_daysOfYear.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this days of year.
	*
	* @return the company ID of this days of year
	*/
	@Override
	public long getCompanyId() {
		return _daysOfYear.getCompanyId();
	}

	/**
	* Sets the company ID of this days of year.
	*
	* @param companyId the company ID of this days of year
	*/
	@Override
	public void setCompanyId(long companyId) {
		_daysOfYear.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this days of year.
	*
	* @return the user ID of this days of year
	*/
	@Override
	public long getUserId() {
		return _daysOfYear.getUserId();
	}

	/**
	* Sets the user ID of this days of year.
	*
	* @param userId the user ID of this days of year
	*/
	@Override
	public void setUserId(long userId) {
		_daysOfYear.setUserId(userId);
	}

	/**
	* Returns the user uuid of this days of year.
	*
	* @return the user uuid of this days of year
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _daysOfYear.getUserUuid();
	}

	/**
	* Sets the user uuid of this days of year.
	*
	* @param userUuid the user uuid of this days of year
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_daysOfYear.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this days of year.
	*
	* @return the user name of this days of year
	*/
	@Override
	public java.lang.String getUserName() {
		return _daysOfYear.getUserName();
	}

	/**
	* Sets the user name of this days of year.
	*
	* @param userName the user name of this days of year
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_daysOfYear.setUserName(userName);
	}

	/**
	* Returns the create date of this days of year.
	*
	* @return the create date of this days of year
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _daysOfYear.getCreateDate();
	}

	/**
	* Sets the create date of this days of year.
	*
	* @param createDate the create date of this days of year
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_daysOfYear.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this days of year.
	*
	* @return the modified date of this days of year
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _daysOfYear.getModifiedDate();
	}

	/**
	* Sets the modified date of this days of year.
	*
	* @param modifiedDate the modified date of this days of year
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_daysOfYear.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the day ID of this days of year.
	*
	* @return the day ID of this days of year
	*/
	@Override
	public java.util.Date getDayId() {
		return _daysOfYear.getDayId();
	}

	/**
	* Sets the day ID of this days of year.
	*
	* @param dayId the day ID of this days of year
	*/
	@Override
	public void setDayId(java.util.Date dayId) {
		_daysOfYear.setDayId(dayId);
	}

	/**
	* Returns the rule ID of this days of year.
	*
	* @return the rule ID of this days of year
	*/
	@Override
	public long getRuleId() {
		return _daysOfYear.getRuleId();
	}

	/**
	* Sets the rule ID of this days of year.
	*
	* @param ruleId the rule ID of this days of year
	*/
	@Override
	public void setRuleId(long ruleId) {
		_daysOfYear.setRuleId(ruleId);
	}

	/**
	* Returns the fully qualified class name of this days of year.
	*
	* @return the fully qualified class name of this days of year
	*/
	@Override
	public java.lang.String getClassName() {
		return _daysOfYear.getClassName();
	}

	@Override
	public void setClassName(java.lang.String className) {
		_daysOfYear.setClassName(className);
	}

	/**
	* Returns the class name ID of this days of year.
	*
	* @return the class name ID of this days of year
	*/
	@Override
	public long getClassNameId() {
		return _daysOfYear.getClassNameId();
	}

	/**
	* Sets the class name ID of this days of year.
	*
	* @param classNameId the class name ID of this days of year
	*/
	@Override
	public void setClassNameId(long classNameId) {
		_daysOfYear.setClassNameId(classNameId);
	}

	/**
	* Returns the class p k of this days of year.
	*
	* @return the class p k of this days of year
	*/
	@Override
	public long getClassPK() {
		return _daysOfYear.getClassPK();
	}

	/**
	* Sets the class p k of this days of year.
	*
	* @param classPK the class p k of this days of year
	*/
	@Override
	public void setClassPK(long classPK) {
		_daysOfYear.setClassPK(classPK);
	}

	@Override
	public boolean isNew() {
		return _daysOfYear.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_daysOfYear.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _daysOfYear.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_daysOfYear.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _daysOfYear.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _daysOfYear.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_daysOfYear.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _daysOfYear.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_daysOfYear.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_daysOfYear.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_daysOfYear.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DaysOfYearWrapper((DaysOfYear)_daysOfYear.clone());
	}

	@Override
	public int compareTo(
		com.liferay.timetracking.dayoffs.model.DaysOfYear daysOfYear) {
		return _daysOfYear.compareTo(daysOfYear);
	}

	@Override
	public int hashCode() {
		return _daysOfYear.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.timetracking.dayoffs.model.DaysOfYear> toCacheModel() {
		return _daysOfYear.toCacheModel();
	}

	@Override
	public com.liferay.timetracking.dayoffs.model.DaysOfYear toEscapedModel() {
		return new DaysOfYearWrapper(_daysOfYear.toEscapedModel());
	}

	@Override
	public com.liferay.timetracking.dayoffs.model.DaysOfYear toUnescapedModel() {
		return new DaysOfYearWrapper(_daysOfYear.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _daysOfYear.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _daysOfYear.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_daysOfYear.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DaysOfYearWrapper)) {
			return false;
		}

		DaysOfYearWrapper daysOfYearWrapper = (DaysOfYearWrapper)obj;

		if (Validator.equals(_daysOfYear, daysOfYearWrapper._daysOfYear)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public DaysOfYear getWrappedDaysOfYear() {
		return _daysOfYear;
	}

	@Override
	public DaysOfYear getWrappedModel() {
		return _daysOfYear;
	}

	@Override
	public void resetOriginalValues() {
		_daysOfYear.resetOriginalValues();
	}

	private DaysOfYear _daysOfYear;
}