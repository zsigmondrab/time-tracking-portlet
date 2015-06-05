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

package com.liferay.timetracking.timesheet.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.timetracking.timesheet.service.http.WorkDayServiceSoap}.
 *
 * @author Laszlo Hudak, Istvan Sajtos
 * @see com.liferay.timetracking.timesheet.service.http.WorkDayServiceSoap
 * @generated
 */
public class WorkDaySoap implements Serializable {
	public static WorkDaySoap toSoapModel(WorkDay model) {
		WorkDaySoap soapModel = new WorkDaySoap();

		soapModel.setWorkDayId(model.getWorkDayId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDayOfYearId(model.getDayOfYearId());
		soapModel.setStartTime(model.getStartTime());
		soapModel.setEndTime(model.getEndTime());
		soapModel.setBreak_(model.getBreak_());

		return soapModel;
	}

	public static WorkDaySoap[] toSoapModels(WorkDay[] models) {
		WorkDaySoap[] soapModels = new WorkDaySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WorkDaySoap[][] toSoapModels(WorkDay[][] models) {
		WorkDaySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WorkDaySoap[models.length][models[0].length];
		}
		else {
			soapModels = new WorkDaySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WorkDaySoap[] toSoapModels(List<WorkDay> models) {
		List<WorkDaySoap> soapModels = new ArrayList<WorkDaySoap>(models.size());

		for (WorkDay model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WorkDaySoap[soapModels.size()]);
	}

	public WorkDaySoap() {
	}

	public long getPrimaryKey() {
		return _workDayId;
	}

	public void setPrimaryKey(long pk) {
		setWorkDayId(pk);
	}

	public long getWorkDayId() {
		return _workDayId;
	}

	public void setWorkDayId(long workDayId) {
		_workDayId = workDayId;
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

	public long getDayOfYearId() {
		return _dayOfYearId;
	}

	public void setDayOfYearId(long dayOfYearId) {
		_dayOfYearId = dayOfYearId;
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

	public int getBreak_() {
		return _break_;
	}

	public void setBreak_(int break_) {
		_break_ = break_;
	}

	private long _workDayId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _dayOfYearId;
	private Date _startTime;
	private Date _endTime;
	private int _break_;
}