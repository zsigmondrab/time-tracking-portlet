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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.liferay.timetracking.timesheet.service.ClpSerializer;
import com.liferay.timetracking.timesheet.service.WorkDayLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Laszlo Hudak, Istvan Sajtos
 */
public class WorkDayClp extends BaseModelImpl<WorkDay> implements WorkDay {
	public WorkDayClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return WorkDay.class;
	}

	@Override
	public String getModelClassName() {
		return WorkDay.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _workDayId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setWorkDayId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _workDayId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("workDayId", getWorkDayId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("dayOfYearId", getDayOfYearId());
		attributes.put("startTime", getStartTime());
		attributes.put("endTime", getEndTime());
		attributes.put("lunchBreak", getLunchBreak());
		attributes.put("timestamp", getTimestamp());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long workDayId = (Long)attributes.get("workDayId");

		if (workDayId != null) {
			setWorkDayId(workDayId);
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

		Long dayOfYearId = (Long)attributes.get("dayOfYearId");

		if (dayOfYearId != null) {
			setDayOfYearId(dayOfYearId);
		}

		Integer startTime = (Integer)attributes.get("startTime");

		if (startTime != null) {
			setStartTime(startTime);
		}

		Integer endTime = (Integer)attributes.get("endTime");

		if (endTime != null) {
			setEndTime(endTime);
		}

		Integer lunchBreak = (Integer)attributes.get("lunchBreak");

		if (lunchBreak != null) {
			setLunchBreak(lunchBreak);
		}

		Date timestamp = (Date)attributes.get("timestamp");

		if (timestamp != null) {
			setTimestamp(timestamp);
		}
	}

	@Override
	public long getWorkDayId() {
		return _workDayId;
	}

	@Override
	public void setWorkDayId(long workDayId) {
		_workDayId = workDayId;

		if (_workDayRemoteModel != null) {
			try {
				Class<?> clazz = _workDayRemoteModel.getClass();

				Method method = clazz.getMethod("setWorkDayId", long.class);

				method.invoke(_workDayRemoteModel, workDayId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_workDayRemoteModel != null) {
			try {
				Class<?> clazz = _workDayRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_workDayRemoteModel, groupId);
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

		if (_workDayRemoteModel != null) {
			try {
				Class<?> clazz = _workDayRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_workDayRemoteModel, companyId);
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

		if (_workDayRemoteModel != null) {
			try {
				Class<?> clazz = _workDayRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_workDayRemoteModel, userId);
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

		if (_workDayRemoteModel != null) {
			try {
				Class<?> clazz = _workDayRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_workDayRemoteModel, userName);
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

		if (_workDayRemoteModel != null) {
			try {
				Class<?> clazz = _workDayRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_workDayRemoteModel, createDate);
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

		if (_workDayRemoteModel != null) {
			try {
				Class<?> clazz = _workDayRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_workDayRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDayOfYearId() {
		return _dayOfYearId;
	}

	@Override
	public void setDayOfYearId(long dayOfYearId) {
		_dayOfYearId = dayOfYearId;

		if (_workDayRemoteModel != null) {
			try {
				Class<?> clazz = _workDayRemoteModel.getClass();

				Method method = clazz.getMethod("setDayOfYearId", long.class);

				method.invoke(_workDayRemoteModel, dayOfYearId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStartTime() {
		return _startTime;
	}

	@Override
	public void setStartTime(int startTime) {
		_startTime = startTime;

		if (_workDayRemoteModel != null) {
			try {
				Class<?> clazz = _workDayRemoteModel.getClass();

				Method method = clazz.getMethod("setStartTime", int.class);

				method.invoke(_workDayRemoteModel, startTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getEndTime() {
		return _endTime;
	}

	@Override
	public void setEndTime(int endTime) {
		_endTime = endTime;

		if (_workDayRemoteModel != null) {
			try {
				Class<?> clazz = _workDayRemoteModel.getClass();

				Method method = clazz.getMethod("setEndTime", int.class);

				method.invoke(_workDayRemoteModel, endTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getLunchBreak() {
		return _lunchBreak;
	}

	@Override
	public void setLunchBreak(int lunchBreak) {
		_lunchBreak = lunchBreak;

		if (_workDayRemoteModel != null) {
			try {
				Class<?> clazz = _workDayRemoteModel.getClass();

				Method method = clazz.getMethod("setLunchBreak", int.class);

				method.invoke(_workDayRemoteModel, lunchBreak);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getTimestamp() {
		return _timestamp;
	}

	@Override
	public void setTimestamp(Date timestamp) {
		_timestamp = timestamp;

		if (_workDayRemoteModel != null) {
			try {
				Class<?> clazz = _workDayRemoteModel.getClass();

				Method method = clazz.getMethod("setTimestamp", Date.class);

				method.invoke(_workDayRemoteModel, timestamp);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getWorkDayRemoteModel() {
		return _workDayRemoteModel;
	}

	public void setWorkDayRemoteModel(BaseModel<?> workDayRemoteModel) {
		_workDayRemoteModel = workDayRemoteModel;
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

		Class<?> remoteModelClass = _workDayRemoteModel.getClass();

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

		Object returnValue = method.invoke(_workDayRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			WorkDayLocalServiceUtil.addWorkDay(this);
		}
		else {
			WorkDayLocalServiceUtil.updateWorkDay(this);
		}
	}

	@Override
	public WorkDay toEscapedModel() {
		return (WorkDay)ProxyUtil.newProxyInstance(WorkDay.class.getClassLoader(),
			new Class[] { WorkDay.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		WorkDayClp clone = new WorkDayClp();

		clone.setWorkDayId(getWorkDayId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setDayOfYearId(getDayOfYearId());
		clone.setStartTime(getStartTime());
		clone.setEndTime(getEndTime());
		clone.setLunchBreak(getLunchBreak());
		clone.setTimestamp(getTimestamp());

		return clone;
	}

	@Override
	public int compareTo(WorkDay workDay) {
		long primaryKey = workDay.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WorkDayClp)) {
			return false;
		}

		WorkDayClp workDay = (WorkDayClp)obj;

		long primaryKey = workDay.getPrimaryKey();

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

		sb.append("{workDayId=");
		sb.append(getWorkDayId());
		sb.append(", groupId=");
		sb.append(getGroupId());
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
		sb.append(", dayOfYearId=");
		sb.append(getDayOfYearId());
		sb.append(", startTime=");
		sb.append(getStartTime());
		sb.append(", endTime=");
		sb.append(getEndTime());
		sb.append(", lunchBreak=");
		sb.append(getLunchBreak());
		sb.append(", timestamp=");
		sb.append(getTimestamp());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.liferay.timetracking.timesheet.model.WorkDay");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>workDayId</column-name><column-value><![CDATA[");
		sb.append(getWorkDayId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
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
			"<column><column-name>dayOfYearId</column-name><column-value><![CDATA[");
		sb.append(getDayOfYearId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startTime</column-name><column-value><![CDATA[");
		sb.append(getStartTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endTime</column-name><column-value><![CDATA[");
		sb.append(getEndTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lunchBreak</column-name><column-value><![CDATA[");
		sb.append(getLunchBreak());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>timestamp</column-name><column-value><![CDATA[");
		sb.append(getTimestamp());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _workDayId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _dayOfYearId;
	private int _startTime;
	private int _endTime;
	private int _lunchBreak;
	private Date _timestamp;
	private BaseModel<?> _workDayRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.timetracking.timesheet.service.ClpSerializer.class;
}