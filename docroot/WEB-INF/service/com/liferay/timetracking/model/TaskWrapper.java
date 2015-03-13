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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Task}.
 * </p>
 *
 * @author BénaBéla
 * @see Task
 * @generated
 */
public class TaskWrapper implements Task, ModelWrapper<Task> {
	public TaskWrapper(Task task) {
		_task = task;
	}

	@Override
	public Class<?> getModelClass() {
		return Task.class;
	}

	@Override
	public String getModelClassName() {
		return Task.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("taskId", getTaskId());
		attributes.put("taskName", getTaskName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long taskId = (Long)attributes.get("taskId");

		if (taskId != null) {
			setTaskId(taskId);
		}

		String taskName = (String)attributes.get("taskName");

		if (taskName != null) {
			setTaskName(taskName);
		}
	}

	/**
	* Returns the primary key of this task.
	*
	* @return the primary key of this task
	*/
	@Override
	public long getPrimaryKey() {
		return _task.getPrimaryKey();
	}

	/**
	* Sets the primary key of this task.
	*
	* @param primaryKey the primary key of this task
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_task.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the task ID of this task.
	*
	* @return the task ID of this task
	*/
	@Override
	public long getTaskId() {
		return _task.getTaskId();
	}

	/**
	* Sets the task ID of this task.
	*
	* @param taskId the task ID of this task
	*/
	@Override
	public void setTaskId(long taskId) {
		_task.setTaskId(taskId);
	}

	/**
	* Returns the task name of this task.
	*
	* @return the task name of this task
	*/
	@Override
	public java.lang.String getTaskName() {
		return _task.getTaskName();
	}

	/**
	* Sets the task name of this task.
	*
	* @param taskName the task name of this task
	*/
	@Override
	public void setTaskName(java.lang.String taskName) {
		_task.setTaskName(taskName);
	}

	@Override
	public boolean isNew() {
		return _task.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_task.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _task.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_task.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _task.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _task.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_task.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _task.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_task.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_task.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_task.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TaskWrapper((Task)_task.clone());
	}

	@Override
	public int compareTo(Task task) {
		return _task.compareTo(task);
	}

	@Override
	public int hashCode() {
		return _task.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<Task> toCacheModel() {
		return _task.toCacheModel();
	}

	@Override
	public Task toEscapedModel() {
		return new TaskWrapper(_task.toEscapedModel());
	}

	@Override
	public Task toUnescapedModel() {
		return new TaskWrapper(_task.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _task.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _task.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_task.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TaskWrapper)) {
			return false;
		}

		TaskWrapper taskWrapper = (TaskWrapper)obj;

		if (Validator.equals(_task, taskWrapper._task)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Task getWrappedTask() {
		return _task;
	}

	@Override
	public Task getWrappedModel() {
		return _task;
	}

	@Override
	public void resetOriginalValues() {
		_task.resetOriginalValues();
	}

	private Task _task;
}