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

package com.liferay.timetracking.activities.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ActivityAssignment}.
 * </p>
 *
 * @author Laszlo Hudak, Adam T. Nagy
 * @see ActivityAssignment
 * @generated
 */
public class ActivityAssignmentWrapper implements ActivityAssignment,
	ModelWrapper<ActivityAssignment> {
	public ActivityAssignmentWrapper(ActivityAssignment activityAssignment) {
		_activityAssignment = activityAssignment;
	}

	@Override
	public Class<?> getModelClass() {
		return ActivityAssignment.class;
	}

	@Override
	public String getModelClassName() {
		return ActivityAssignment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("activityAssignmentId", getActivityAssignmentId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("activityId", getActivityId());
		attributes.put("workDayId", getWorkDayId());
		attributes.put("startTime", getStartTime());
		attributes.put("endTime", getEndTime());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long activityAssignmentId = (Long)attributes.get("activityAssignmentId");

		if (activityAssignmentId != null) {
			setActivityAssignmentId(activityAssignmentId);
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

		Long activityId = (Long)attributes.get("activityId");

		if (activityId != null) {
			setActivityId(activityId);
		}

		Long workDayId = (Long)attributes.get("workDayId");

		if (workDayId != null) {
			setWorkDayId(workDayId);
		}

		Date startTime = (Date)attributes.get("startTime");

		if (startTime != null) {
			setStartTime(startTime);
		}

		Date endTime = (Date)attributes.get("endTime");

		if (endTime != null) {
			setEndTime(endTime);
		}
	}

	/**
	* Returns the primary key of this activity assignment.
	*
	* @return the primary key of this activity assignment
	*/
	@Override
	public long getPrimaryKey() {
		return _activityAssignment.getPrimaryKey();
	}

	/**
	* Sets the primary key of this activity assignment.
	*
	* @param primaryKey the primary key of this activity assignment
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_activityAssignment.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the activity assignment ID of this activity assignment.
	*
	* @return the activity assignment ID of this activity assignment
	*/
	@Override
	public long getActivityAssignmentId() {
		return _activityAssignment.getActivityAssignmentId();
	}

	/**
	* Sets the activity assignment ID of this activity assignment.
	*
	* @param activityAssignmentId the activity assignment ID of this activity assignment
	*/
	@Override
	public void setActivityAssignmentId(long activityAssignmentId) {
		_activityAssignment.setActivityAssignmentId(activityAssignmentId);
	}

	/**
	* Returns the group ID of this activity assignment.
	*
	* @return the group ID of this activity assignment
	*/
	@Override
	public long getGroupId() {
		return _activityAssignment.getGroupId();
	}

	/**
	* Sets the group ID of this activity assignment.
	*
	* @param groupId the group ID of this activity assignment
	*/
	@Override
	public void setGroupId(long groupId) {
		_activityAssignment.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this activity assignment.
	*
	* @return the company ID of this activity assignment
	*/
	@Override
	public long getCompanyId() {
		return _activityAssignment.getCompanyId();
	}

	/**
	* Sets the company ID of this activity assignment.
	*
	* @param companyId the company ID of this activity assignment
	*/
	@Override
	public void setCompanyId(long companyId) {
		_activityAssignment.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this activity assignment.
	*
	* @return the user ID of this activity assignment
	*/
	@Override
	public long getUserId() {
		return _activityAssignment.getUserId();
	}

	/**
	* Sets the user ID of this activity assignment.
	*
	* @param userId the user ID of this activity assignment
	*/
	@Override
	public void setUserId(long userId) {
		_activityAssignment.setUserId(userId);
	}

	/**
	* Returns the user uuid of this activity assignment.
	*
	* @return the user uuid of this activity assignment
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _activityAssignment.getUserUuid();
	}

	/**
	* Sets the user uuid of this activity assignment.
	*
	* @param userUuid the user uuid of this activity assignment
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_activityAssignment.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this activity assignment.
	*
	* @return the user name of this activity assignment
	*/
	@Override
	public java.lang.String getUserName() {
		return _activityAssignment.getUserName();
	}

	/**
	* Sets the user name of this activity assignment.
	*
	* @param userName the user name of this activity assignment
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_activityAssignment.setUserName(userName);
	}

	/**
	* Returns the create date of this activity assignment.
	*
	* @return the create date of this activity assignment
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _activityAssignment.getCreateDate();
	}

	/**
	* Sets the create date of this activity assignment.
	*
	* @param createDate the create date of this activity assignment
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_activityAssignment.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this activity assignment.
	*
	* @return the modified date of this activity assignment
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _activityAssignment.getModifiedDate();
	}

	/**
	* Sets the modified date of this activity assignment.
	*
	* @param modifiedDate the modified date of this activity assignment
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_activityAssignment.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the activity ID of this activity assignment.
	*
	* @return the activity ID of this activity assignment
	*/
	@Override
	public long getActivityId() {
		return _activityAssignment.getActivityId();
	}

	/**
	* Sets the activity ID of this activity assignment.
	*
	* @param activityId the activity ID of this activity assignment
	*/
	@Override
	public void setActivityId(long activityId) {
		_activityAssignment.setActivityId(activityId);
	}

	/**
	* Returns the work day ID of this activity assignment.
	*
	* @return the work day ID of this activity assignment
	*/
	@Override
	public long getWorkDayId() {
		return _activityAssignment.getWorkDayId();
	}

	/**
	* Sets the work day ID of this activity assignment.
	*
	* @param workDayId the work day ID of this activity assignment
	*/
	@Override
	public void setWorkDayId(long workDayId) {
		_activityAssignment.setWorkDayId(workDayId);
	}

	/**
	* Returns the start time of this activity assignment.
	*
	* @return the start time of this activity assignment
	*/
	@Override
	public java.util.Date getStartTime() {
		return _activityAssignment.getStartTime();
	}

	/**
	* Sets the start time of this activity assignment.
	*
	* @param startTime the start time of this activity assignment
	*/
	@Override
	public void setStartTime(java.util.Date startTime) {
		_activityAssignment.setStartTime(startTime);
	}

	/**
	* Returns the end time of this activity assignment.
	*
	* @return the end time of this activity assignment
	*/
	@Override
	public java.util.Date getEndTime() {
		return _activityAssignment.getEndTime();
	}

	/**
	* Sets the end time of this activity assignment.
	*
	* @param endTime the end time of this activity assignment
	*/
	@Override
	public void setEndTime(java.util.Date endTime) {
		_activityAssignment.setEndTime(endTime);
	}

	@Override
	public boolean isNew() {
		return _activityAssignment.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_activityAssignment.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _activityAssignment.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_activityAssignment.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _activityAssignment.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _activityAssignment.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_activityAssignment.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _activityAssignment.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_activityAssignment.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_activityAssignment.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_activityAssignment.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ActivityAssignmentWrapper((ActivityAssignment)_activityAssignment.clone());
	}

	@Override
	public int compareTo(ActivityAssignment activityAssignment) {
		return _activityAssignment.compareTo(activityAssignment);
	}

	@Override
	public int hashCode() {
		return _activityAssignment.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<ActivityAssignment> toCacheModel() {
		return _activityAssignment.toCacheModel();
	}

	@Override
	public ActivityAssignment toEscapedModel() {
		return new ActivityAssignmentWrapper(_activityAssignment.toEscapedModel());
	}

	@Override
	public ActivityAssignment toUnescapedModel() {
		return new ActivityAssignmentWrapper(_activityAssignment.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _activityAssignment.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _activityAssignment.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_activityAssignment.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ActivityAssignmentWrapper)) {
			return false;
		}

		ActivityAssignmentWrapper activityAssignmentWrapper = (ActivityAssignmentWrapper)obj;

		if (Validator.equals(_activityAssignment,
					activityAssignmentWrapper._activityAssignment)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ActivityAssignment getWrappedActivityAssignment() {
		return _activityAssignment;
	}

	@Override
	public ActivityAssignment getWrappedModel() {
		return _activityAssignment;
	}

	@Override
	public void resetOriginalValues() {
		_activityAssignment.resetOriginalValues();
	}

	private ActivityAssignment _activityAssignment;
}