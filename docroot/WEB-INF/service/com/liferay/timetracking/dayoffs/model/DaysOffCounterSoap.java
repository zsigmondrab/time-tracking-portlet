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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.timetracking.dayoffs.service.http.DaysOffCounterServiceSoap}.
 *
 * @author Laszlo Hudak
 * @see com.liferay.timetracking.dayoffs.service.http.DaysOffCounterServiceSoap
 * @generated
 */
public class DaysOffCounterSoap implements Serializable {
	public static DaysOffCounterSoap toSoapModel(DaysOffCounter model) {
		DaysOffCounterSoap soapModel = new DaysOffCounterSoap();

		soapModel.setDayOffCounterId(model.getDayOffCounterId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setWorkerUserId(model.getWorkerUserId());
		soapModel.setWorkerUserName(model.getWorkerUserName());
		soapModel.setRuleId(model.getRuleId());
		soapModel.setYear(model.getYear());
		soapModel.setAllDays(model.getAllDays());
		soapModel.setRemainingDays(model.getRemainingDays());

		return soapModel;
	}

	public static DaysOffCounterSoap[] toSoapModels(DaysOffCounter[] models) {
		DaysOffCounterSoap[] soapModels = new DaysOffCounterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DaysOffCounterSoap[][] toSoapModels(DaysOffCounter[][] models) {
		DaysOffCounterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DaysOffCounterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DaysOffCounterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DaysOffCounterSoap[] toSoapModels(List<DaysOffCounter> models) {
		List<DaysOffCounterSoap> soapModels = new ArrayList<DaysOffCounterSoap>(models.size());

		for (DaysOffCounter model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DaysOffCounterSoap[soapModels.size()]);
	}

	public DaysOffCounterSoap() {
	}

	public long getPrimaryKey() {
		return _dayOffCounterId;
	}

	public void setPrimaryKey(long pk) {
		setDayOffCounterId(pk);
	}

	public long getDayOffCounterId() {
		return _dayOffCounterId;
	}

	public void setDayOffCounterId(long dayOffCounterId) {
		_dayOffCounterId = dayOffCounterId;
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

	public long getWorkerUserId() {
		return _workerUserId;
	}

	public void setWorkerUserId(long workerUserId) {
		_workerUserId = workerUserId;
	}

	public String getWorkerUserName() {
		return _workerUserName;
	}

	public void setWorkerUserName(String workerUserName) {
		_workerUserName = workerUserName;
	}

	public long getRuleId() {
		return _ruleId;
	}

	public void setRuleId(long ruleId) {
		_ruleId = ruleId;
	}

	public int getYear() {
		return _year;
	}

	public void setYear(int year) {
		_year = year;
	}

	public int getAllDays() {
		return _allDays;
	}

	public void setAllDays(int allDays) {
		_allDays = allDays;
	}

	public int getRemainingDays() {
		return _remainingDays;
	}

	public void setRemainingDays(int remainingDays) {
		_remainingDays = remainingDays;
	}

	private long _dayOffCounterId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _workerUserId;
	private String _workerUserName;
	private long _ruleId;
	private int _year;
	private int _allDays;
	private int _remainingDays;
}