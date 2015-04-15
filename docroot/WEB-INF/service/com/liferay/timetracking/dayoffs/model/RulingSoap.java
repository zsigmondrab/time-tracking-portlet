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
 * This class is used by SOAP remote services, specifically {@link com.liferay.timetracking.dayoffs.service.http.RulingServiceSoap}.
 *
 * @author LĂˇszlĂł HudĂˇk
 * @see com.liferay.timetracking.dayoffs.service.http.RulingServiceSoap
 * @generated
 */
public class RulingSoap implements Serializable {
	public static RulingSoap toSoapModel(Ruling model) {
		RulingSoap soapModel = new RulingSoap();

		soapModel.setRuleId(model.getRuleId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setRuleName(model.getRuleName());
		soapModel.setMultiplier(model.getMultiplier());

		return soapModel;
	}

	public static RulingSoap[] toSoapModels(Ruling[] models) {
		RulingSoap[] soapModels = new RulingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RulingSoap[][] toSoapModels(Ruling[][] models) {
		RulingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RulingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RulingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RulingSoap[] toSoapModels(List<Ruling> models) {
		List<RulingSoap> soapModels = new ArrayList<RulingSoap>(models.size());

		for (Ruling model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RulingSoap[soapModels.size()]);
	}

	public RulingSoap() {
	}

	public long getPrimaryKey() {
		return _ruleId;
	}

	public void setPrimaryKey(long pk) {
		setRuleId(pk);
	}

	public long getRuleId() {
		return _ruleId;
	}

	public void setRuleId(long ruleId) {
		_ruleId = ruleId;
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

	public String getRuleName() {
		return _ruleName;
	}

	public void setRuleName(String ruleName) {
		_ruleName = ruleName;
	}

	public double getMultiplier() {
		return _multiplier;
	}

	public void setMultiplier(double multiplier) {
		_multiplier = multiplier;
	}

	private long _ruleId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _ruleName;
	private double _multiplier;
}