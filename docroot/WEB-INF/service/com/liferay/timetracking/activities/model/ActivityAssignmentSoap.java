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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.timetracking.activities.service.http.ActivityAssignmentServiceSoap}.
 *
 * @author Laszlo Hudak, Adam T. Nagy
 * @see com.liferay.timetracking.activities.service.http.ActivityAssignmentServiceSoap
 * @generated
 */
public class ActivityAssignmentSoap implements Serializable {
	public static ActivityAssignmentSoap toSoapModel(ActivityAssignment model) {
		ActivityAssignmentSoap soapModel = new ActivityAssignmentSoap();

		soapModel.setActivityAssignmentId(model.getActivityAssignmentId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setActivityId(model.getActivityId());
		soapModel.setWorkDayId(model.getWorkDayId());
		soapModel.setStartTime(model.getStartTime());
		soapModel.setEndTime(model.getEndTime());

		return soapModel;
	}

	public static ActivityAssignmentSoap[] toSoapModels(
		ActivityAssignment[] models) {
		ActivityAssignmentSoap[] soapModels = new ActivityAssignmentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ActivityAssignmentSoap[][] toSoapModels(
		ActivityAssignment[][] models) {
		ActivityAssignmentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ActivityAssignmentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ActivityAssignmentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ActivityAssignmentSoap[] toSoapModels(
		List<ActivityAssignment> models) {
		List<ActivityAssignmentSoap> soapModels = new ArrayList<ActivityAssignmentSoap>(models.size());

		for (ActivityAssignment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ActivityAssignmentSoap[soapModels.size()]);
	}

	public ActivityAssignmentSoap() {
	}

	public long getPrimaryKey() {
		return _activityAssignmentId;
	}

	public void setPrimaryKey(long pk) {
		setActivityAssignmentId(pk);
	}

	public long getActivityAssignmentId() {
		return _activityAssignmentId;
	}

	public void setActivityAssignmentId(long activityAssignmentId) {
		_activityAssignmentId = activityAssignmentId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
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

	public long getActivityId() {
		return _activityId;
	}

	public void setActivityId(long activityId) {
		_activityId = activityId;
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

	private long _activityAssignmentId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _activityId;
	private long _workDayId;
	private Date _startTime;
	private Date _endTime;
}