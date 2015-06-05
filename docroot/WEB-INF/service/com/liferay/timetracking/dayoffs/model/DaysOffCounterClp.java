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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.liferay.timetracking.dayoffs.service.ClpSerializer;
import com.liferay.timetracking.dayoffs.service.DaysOffCounterLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Laszlo Hudak
 */
public class DaysOffCounterClp extends BaseModelImpl<DaysOffCounter>
	implements DaysOffCounter {
	public DaysOffCounterClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return DaysOffCounter.class;
	}

	@Override
	public String getModelClassName() {
		return DaysOffCounter.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _dayOffCounterId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDayOffCounterId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dayOffCounterId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dayOffCounterId", getDayOffCounterId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("workerUserId", getWorkerUserId());
		attributes.put("workerUserName", getWorkerUserName());
		attributes.put("ruleId", getRuleId());
		attributes.put("year", getYear());
		attributes.put("allDays", getAllDays());
		attributes.put("remainingDays", getRemainingDays());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dayOffCounterId = (Long)attributes.get("dayOffCounterId");

		if (dayOffCounterId != null) {
			setDayOffCounterId(dayOffCounterId);
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

		Long workerUserId = (Long)attributes.get("workerUserId");

		if (workerUserId != null) {
			setWorkerUserId(workerUserId);
		}

		String workerUserName = (String)attributes.get("workerUserName");

		if (workerUserName != null) {
			setWorkerUserName(workerUserName);
		}

		Long ruleId = (Long)attributes.get("ruleId");

		if (ruleId != null) {
			setRuleId(ruleId);
		}

		Integer year = (Integer)attributes.get("year");

		if (year != null) {
			setYear(year);
		}

		Integer allDays = (Integer)attributes.get("allDays");

		if (allDays != null) {
			setAllDays(allDays);
		}

		Integer remainingDays = (Integer)attributes.get("remainingDays");

		if (remainingDays != null) {
			setRemainingDays(remainingDays);
		}
	}

	@Override
	public long getDayOffCounterId() {
		return _dayOffCounterId;
	}

	@Override
	public void setDayOffCounterId(long dayOffCounterId) {
		_dayOffCounterId = dayOffCounterId;

		if (_daysOffCounterRemoteModel != null) {
			try {
				Class<?> clazz = _daysOffCounterRemoteModel.getClass();

				Method method = clazz.getMethod("setDayOffCounterId", long.class);

				method.invoke(_daysOffCounterRemoteModel, dayOffCounterId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_daysOffCounterRemoteModel != null) {
			try {
				Class<?> clazz = _daysOffCounterRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_daysOffCounterRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_daysOffCounterRemoteModel != null) {
			try {
				Class<?> clazz = _daysOffCounterRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_daysOffCounterRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_daysOffCounterRemoteModel != null) {
			try {
				Class<?> clazz = _daysOffCounterRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_daysOffCounterRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_daysOffCounterRemoteModel != null) {
			try {
				Class<?> clazz = _daysOffCounterRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_daysOffCounterRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_daysOffCounterRemoteModel != null) {
			try {
				Class<?> clazz = _daysOffCounterRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_daysOffCounterRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getWorkerUserId() {
		return _workerUserId;
	}

	@Override
	public void setWorkerUserId(long workerUserId) {
		_workerUserId = workerUserId;

		if (_daysOffCounterRemoteModel != null) {
			try {
				Class<?> clazz = _daysOffCounterRemoteModel.getClass();

				Method method = clazz.getMethod("setWorkerUserId", long.class);

				method.invoke(_daysOffCounterRemoteModel, workerUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWorkerUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getWorkerUserId(), "uuid",
			_workerUserUuid);
	}

	@Override
	public void setWorkerUserUuid(String workerUserUuid) {
		_workerUserUuid = workerUserUuid;
	}

	@Override
	public String getWorkerUserName() {
		return _workerUserName;
	}

	@Override
	public void setWorkerUserName(String workerUserName) {
		_workerUserName = workerUserName;

		if (_daysOffCounterRemoteModel != null) {
			try {
				Class<?> clazz = _daysOffCounterRemoteModel.getClass();

				Method method = clazz.getMethod("setWorkerUserName",
						String.class);

				method.invoke(_daysOffCounterRemoteModel, workerUserName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRuleId() {
		return _ruleId;
	}

	@Override
	public void setRuleId(long ruleId) {
		_ruleId = ruleId;

		if (_daysOffCounterRemoteModel != null) {
			try {
				Class<?> clazz = _daysOffCounterRemoteModel.getClass();

				Method method = clazz.getMethod("setRuleId", long.class);

				method.invoke(_daysOffCounterRemoteModel, ruleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getYear() {
		return _year;
	}

	@Override
	public void setYear(int year) {
		_year = year;

		if (_daysOffCounterRemoteModel != null) {
			try {
				Class<?> clazz = _daysOffCounterRemoteModel.getClass();

				Method method = clazz.getMethod("setYear", int.class);

				method.invoke(_daysOffCounterRemoteModel, year);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getAllDays() {
		return _allDays;
	}

	@Override
	public void setAllDays(int allDays) {
		_allDays = allDays;

		if (_daysOffCounterRemoteModel != null) {
			try {
				Class<?> clazz = _daysOffCounterRemoteModel.getClass();

				Method method = clazz.getMethod("setAllDays", int.class);

				method.invoke(_daysOffCounterRemoteModel, allDays);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getRemainingDays() {
		return _remainingDays;
	}

	@Override
	public void setRemainingDays(int remainingDays) {
		_remainingDays = remainingDays;

		if (_daysOffCounterRemoteModel != null) {
			try {
				Class<?> clazz = _daysOffCounterRemoteModel.getClass();

				Method method = clazz.getMethod("setRemainingDays", int.class);

				method.invoke(_daysOffCounterRemoteModel, remainingDays);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDaysOffCounterRemoteModel() {
		return _daysOffCounterRemoteModel;
	}

	public void setDaysOffCounterRemoteModel(
		BaseModel<?> daysOffCounterRemoteModel) {
		_daysOffCounterRemoteModel = daysOffCounterRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _daysOffCounterRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_daysOffCounterRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DaysOffCounterLocalServiceUtil.addDaysOffCounter(this);
		}
		else {
			DaysOffCounterLocalServiceUtil.updateDaysOffCounter(this);
		}
	}

	@Override
	public DaysOffCounter toEscapedModel() {
		return (DaysOffCounter)ProxyUtil.newProxyInstance(DaysOffCounter.class.getClassLoader(),
			new Class[] { DaysOffCounter.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DaysOffCounterClp clone = new DaysOffCounterClp();

		clone.setDayOffCounterId(getDayOffCounterId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setWorkerUserId(getWorkerUserId());
		clone.setWorkerUserName(getWorkerUserName());
		clone.setRuleId(getRuleId());
		clone.setYear(getYear());
		clone.setAllDays(getAllDays());
		clone.setRemainingDays(getRemainingDays());

		return clone;
	}

	@Override
	public int compareTo(DaysOffCounter daysOffCounter) {
		int value = 0;

		value = getWorkerUserName().compareTo(daysOffCounter.getWorkerUserName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DaysOffCounterClp)) {
			return false;
		}

		DaysOffCounterClp daysOffCounter = (DaysOffCounterClp)obj;

		long primaryKey = daysOffCounter.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{dayOffCounterId=");
		sb.append(getDayOffCounterId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", workerUserId=");
		sb.append(getWorkerUserId());
		sb.append(", workerUserName=");
		sb.append(getWorkerUserName());
		sb.append(", ruleId=");
		sb.append(getRuleId());
		sb.append(", year=");
		sb.append(getYear());
		sb.append(", allDays=");
		sb.append(getAllDays());
		sb.append(", remainingDays=");
		sb.append(getRemainingDays());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.liferay.timetracking.dayoffs.model.DaysOffCounter");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>dayOffCounterId</column-name><column-value><![CDATA[");
		sb.append(getDayOffCounterId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>workerUserId</column-name><column-value><![CDATA[");
		sb.append(getWorkerUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>workerUserName</column-name><column-value><![CDATA[");
		sb.append(getWorkerUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ruleId</column-name><column-value><![CDATA[");
		sb.append(getRuleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>year</column-name><column-value><![CDATA[");
		sb.append(getYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>allDays</column-name><column-value><![CDATA[");
		sb.append(getAllDays());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>remainingDays</column-name><column-value><![CDATA[");
		sb.append(getRemainingDays());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _dayOffCounterId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _workerUserId;
	private String _workerUserUuid;
	private String _workerUserName;
	private long _ruleId;
	private int _year;
	private int _allDays;
	private int _remainingDays;
	private BaseModel<?> _daysOffCounterRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.timetracking.dayoffs.service.ClpSerializer.class;
}