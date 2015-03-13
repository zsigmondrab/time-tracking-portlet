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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author BénaBéla
 * @generated
 */
public class TaskAssignmentSoap implements Serializable {
	public static TaskAssignmentSoap toSoapModel(TaskAssignment model) {
		TaskAssignmentSoap soapModel = new TaskAssignmentSoap();

		soapModel.setTaskAssignmentId(model.getTaskAssignmentId());
		soapModel.setTaskId(model.getTaskId());
		soapModel.setWorkDayId(model.getWorkDayId());
		soapModel.setStartTime(model.getStartTime());
		soapModel.setEndTime(model.getEndTime());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static TaskAssignmentSoap[] toSoapModels(TaskAssignment[] models) {
		TaskAssignmentSoap[] soapModels = new TaskAssignmentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TaskAssignmentSoap[][] toSoapModels(TaskAssignment[][] models) {
		TaskAssignmentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TaskAssignmentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TaskAssignmentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TaskAssignmentSoap[] toSoapModels(List<TaskAssignment> models) {
		List<TaskAssignmentSoap> soapModels = new ArrayList<TaskAssignmentSoap>(models.size());

		for (TaskAssignment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TaskAssignmentSoap[soapModels.size()]);
	}

	public TaskAssignmentSoap() {
	}

	public long getPrimaryKey() {
		return _taskAssignmentId;
	}

	public void setPrimaryKey(long pk) {
		setTaskAssignmentId(pk);
	}

	public long getTaskAssignmentId() {
		return _taskAssignmentId;
	}

	public void setTaskAssignmentId(long taskAssignmentId) {
		_taskAssignmentId = taskAssignmentId;
	}

	public long getTaskId() {
		return _taskId;
	}

	public void setTaskId(long taskId) {
		_taskId = taskId;
	}

	public long getWorkDayId() {
		return _workDayId;
	}

	public void setWorkDayId(long workDayId) {
		_workDayId = workDayId;
	}

	public Date getStartTime() {
		return _startTime;
	}

	public void setStartTime(Date startTime) {
		_startTime = startTime;
	}

	public Date getEndTime() {
		return _endTime;
	}

	public void setEndTime(Date endTime) {
		_endTime = endTime;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private long _taskAssignmentId;
	private long _taskId;
	private long _workDayId;
	private Date _startTime;
	private Date _endTime;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}