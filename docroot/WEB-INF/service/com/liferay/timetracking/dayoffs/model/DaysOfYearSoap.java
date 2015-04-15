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
 * This class is used by SOAP remote services, specifically {@link com.liferay.timetracking.dayoffs.service.http.DaysOfYearServiceSoap}.
 *
 * @author LĂˇszlĂł HudĂˇk
 * @see com.liferay.timetracking.dayoffs.service.http.DaysOfYearServiceSoap
 * @generated
 */
public class DaysOfYearSoap implements Serializable {
	public static DaysOfYearSoap toSoapModel(DaysOfYear model) {
		DaysOfYearSoap soapModel = new DaysOfYearSoap();

		soapModel.setDayOfYearId(model.getDayOfYearId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDayId(model.getDayId());
		soapModel.setRuleId(model.getRuleId());
		soapModel.setUnitId(model.getUnitId());
		soapModel.setUnitType(model.getUnitType());

		return soapModel;
	}

	public static DaysOfYearSoap[] toSoapModels(DaysOfYear[] models) {
		DaysOfYearSoap[] soapModels = new DaysOfYearSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DaysOfYearSoap[][] toSoapModels(DaysOfYear[][] models) {
		DaysOfYearSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DaysOfYearSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DaysOfYearSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DaysOfYearSoap[] toSoapModels(List<DaysOfYear> models) {
		List<DaysOfYearSoap> soapModels = new ArrayList<DaysOfYearSoap>(models.size());

		for (DaysOfYear model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DaysOfYearSoap[soapModels.size()]);
	}

	public DaysOfYearSoap() {
	}

	public long getPrimaryKey() {
		return _dayOfYearId;
	}

	public void setPrimaryKey(long pk) {
		setDayOfYearId(pk);
	}

	public long getDayOfYearId() {
		return _dayOfYearId;
	}

	public void setDayOfYearId(long dayOfYearId) {
		_dayOfYearId = dayOfYearId;
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

	public Date getDayId() {
		return _dayId;
	}

	public void setDayId(Date dayId) {
		_dayId = dayId;
	}

	public long getRuleId() {
		return _ruleId;
	}

	public void setRuleId(long ruleId) {
		_ruleId = ruleId;
	}

	public long getUnitId() {
		return _unitId;
	}

	public void setUnitId(long unitId) {
		_unitId = unitId;
	}

	public int getUnitType() {
		return _unitType;
	}

	public void setUnitType(int unitType) {
		_unitType = unitType;
	}

	private long _dayOfYearId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _dayId;
	private long _ruleId;
	private long _unitId;
	private int _unitType;
}