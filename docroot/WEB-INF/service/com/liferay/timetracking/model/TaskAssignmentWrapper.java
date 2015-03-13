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

package com.liferay.timetracking.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TaskAssignment}.
 * </p>
 *
 * @author BénaBéla
 * @see TaskAssignment
 * @generated
 */
public class TaskAssignmentWrapper implements TaskAssignment,
	ModelWrapper<TaskAssignment> {
	public TaskAssignmentWrapper(TaskAssignment taskAssignment) {
		_taskAssignment = taskAssignment;
	}

	@Override
	public Class<?> getModelClass() {
		return TaskAssignment.class;
	}

	@Override
	public String getModelClassName() {
		return TaskAssignment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("taskAssignmentId", getTaskAssignmentId());
		attributes.put("taskId", getTaskId());
		attributes.put("workDayId", getWorkDayId());
		attributes.put("startTime", getStartTime());
		attributes.put("endTime", getEndTime());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long taskAssignmentId = (Long)attributes.get("taskAssignmentId");

		if (taskAssignmentId != null) {
			setTaskAssignmentId(taskAssignmentId);
		}

		Long taskId = (Long)attributes.get("taskId");

		if (taskId != null) {
			setTaskId(taskId);
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

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
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
	}

	/**
	* Returns the primary key of this task assignment.
	*
	* @return the primary key of this task assignment
	*/
	@Override
	public long getPrimaryKey() {
		return _taskAssignment.getPrimaryKey();
	}

	/**
	* Sets the primary key of this task assignment.
	*
	* @param primaryKey the primary key of this task assignment
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_taskAssignment.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the task assignment ID of this task assignment.
	*
	* @return the task assignment ID of this task assignment
	*/
	@Override
	public long getTaskAssignmentId() {
		return _taskAssignment.getTaskAssignmentId();
	}

	/**
	* Sets the task assignment ID of this task assignment.
	*
	* @param taskAssignmentId the task assignment ID of this task assignment
	*/
	@Override
	public void setTaskAssignmentId(long taskAssignmentId) {
		_taskAssignment.setTaskAssignmentId(taskAssignmentId);
	}

	/**
	* Returns the task ID of this task assignment.
	*
	* @return the task ID of this task assignment
	*/
	@Override
	public long getTaskId() {
		return _taskAssignment.getTaskId();
	}

	/**
	* Sets the task ID of this task assignment.
	*
	* @param taskId the task ID of this task assignment
	*/
	@Override
	public void setTaskId(long taskId) {
		_taskAssignment.setTaskId(taskId);
	}

	/**
	* Returns the work day ID of this task assignment.
	*
	* @return the work day ID of this task assignment
	*/
	@Override
	public long getWorkDayId() {
		return _taskAssignment.getWorkDayId();
	}

	/**
	* Sets the work day ID of this task assignment.
	*
	* @param workDayId the work day ID of this task assignment
	*/
	@Override
	public void setWorkDayId(long workDayId) {
		_taskAssignment.setWorkDayId(workDayId);
	}

	/**
	* Returns the start time of this task assignment.
	*
	* @return the start time of this task assignment
	*/
	@Override
	public java.util.Date getStartTime() {
		return _taskAssignment.getStartTime();
	}

	/**
	* Sets the start time of this task assignment.
	*
	* @param startTime the start time of this task assignment
	*/
	@Override
	public void setStartTime(java.util.Date startTime) {
		_taskAssignment.setStartTime(startTime);
	}

	/**
	* Returns the end time of this task assignment.
	*
	* @return the end time of this task assignment
	*/
	@Override
	public java.util.Date getEndTime() {
		return _taskAssignment.getEndTime();
	}

	/**
	* Sets the end time of this task assignment.
	*
	* @param endTime the end time of this task assignment
	*/
	@Override
	public void setEndTime(java.util.Date endTime) {
		_taskAssignment.setEndTime(endTime);
	}

	/**
	* Returns the company ID of this task assignment.
	*
	* @return the company ID of this task assignment
	*/
	@Override
	public long getCompanyId() {
		return _taskAssignment.getCompanyId();
	}

	/**
	* Sets the company ID of this task assignment.
	*
	* @param companyId the company ID of this task assignment
	*/
	@Override
	public void setCompanyId(long companyId) {
		_taskAssignment.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this task assignment.
	*
	* @return the group ID of this task assignment
	*/
	@Override
	public long getGroupId() {
		return _taskAssignment.getGroupId();
	}

	/**
	* Sets the group ID of this task assignment.
	*
	* @param groupId the group ID of this task assignment
	*/
	@Override
	public void setGroupId(long groupId) {
		_taskAssignment.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this task assignment.
	*
	* @return the user ID of this task assignment
	*/
	@Override
	public long getUserId() {
		return _taskAssignment.getUserId();
	}

	/**
	* Sets the user ID of this task assignment.
	*
	* @param userId the user ID of this task assignment
	*/
	@Override
	public void setUserId(long userId) {
		_taskAssignment.setUserId(userId);
	}

	/**
	* Returns the user uuid of this task assignment.
	*
	* @return the user uuid of this task assignment
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taskAssignment.getUserUuid();
	}

	/**
	* Sets the user uuid of this task assignment.
	*
	* @param userUuid the user uuid of this task assignment
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_taskAssignment.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this task assignment.
	*
	* @return the user name of this task assignment
	*/
	@Override
	public java.lang.String getUserName() {
		return _taskAssignment.getUserName();
	}

	/**
	* Sets the user name of this task assignment.
	*
	* @param userName the user name of this task assignment
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_taskAssignment.setUserName(userName);
	}

	/**
	* Returns the create date of this task assignment.
	*
	* @return the create date of this task assignment
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _taskAssignment.getCreateDate();
	}

	/**
	* Sets the create date of this task assignment.
	*
	* @param createDate the create date of this task assignment
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_taskAssignment.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this task assignment.
	*
	* @return the modified date of this task assignment
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _taskAssignment.getModifiedDate();
	}

	/**
	* Sets the modified date of this task assignment.
	*
	* @param modifiedDate the modified date of this task assignment
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_taskAssignment.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _taskAssignment.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_taskAssignment.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _taskAssignment.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_taskAssignment.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _taskAssignment.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _taskAssignment.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_taskAssignment.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _taskAssignment.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_taskAssignment.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_taskAssignment.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_taskAssignment.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TaskAssignmentWrapper((TaskAssignment)_taskAssignment.clone());
	}

	@Override
	public int compareTo(TaskAssignment taskAssignment) {
		return _taskAssignment.compareTo(taskAssignment);
	}

	@Override
	public int hashCode() {
		return _taskAssignment.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<TaskAssignment> toCacheModel() {
		return _taskAssignment.toCacheModel();
	}

	@Override
	public TaskAssignment toEscapedModel() {
		return new TaskAssignmentWrapper(_taskAssignment.toEscapedModel());
	}

	@Override
	public TaskAssignment toUnescapedModel() {
		return new TaskAssignmentWrapper(_taskAssignment.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _taskAssignment.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _taskAssignment.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_taskAssignment.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TaskAssignmentWrapper)) {
			return false;
		}

		TaskAssignmentWrapper taskAssignmentWrapper = (TaskAssignmentWrapper)obj;

		if (Validator.equals(_taskAssignment,
					taskAssignmentWrapper._taskAssignment)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TaskAssignment getWrappedTaskAssignment() {
		return _taskAssignment;
	}

	@Override
	public TaskAssignment getWrappedModel() {
		return _taskAssignment;
	}

	@Override
	public void resetOriginalValues() {
		_taskAssignment.resetOriginalValues();
	}

	private TaskAssignment _taskAssignment;
}