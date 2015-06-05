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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.liferay.timetracking.activities.service.ActivityAssignmentLocalServiceUtil;
import com.liferay.timetracking.activities.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Laszlo Hudak, Adam T. Nagy
 */
public class ActivityAssignmentClp extends BaseModelImpl<ActivityAssignment>
	implements ActivityAssignment {
	public ActivityAssignmentClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ActivityAssignment.class;
	}

	@Override
	public String getModelClassName() {
		return ActivityAssignment.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _activityAssignmentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setActivityAssignmentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _activityAssignmentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("activityAssignmentId", getActivityAssignmentId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("activityId", getActivityId());
		attributes.put("workDayId", getWorkDayId());
		attributes.put("startTime", getStartTime());
		attributes.put("endTime", getEndTime());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long activityAssignmentId = (Long)attributes.get("activityAssignmentId");

		if (activityAssignmentId != null) {
			setActivityAssignmentId(activityAssignmentId);
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

		Long activityId = (Long)attributes.get("activityId");

		if (activityId != null) {
			setActivityId(activityId);
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
	}

	@Override
	public long getActivityAssignmentId() {
		return _activityAssignmentId;
	}

	@Override
	public void setActivityAssignmentId(long activityAssignmentId) {
		_activityAssignmentId = activityAssignmentId;

		if (_activityAssignmentRemoteModel != null) {
			try {
				Class<?> clazz = _activityAssignmentRemoteModel.getClass();

				Method method = clazz.getMethod("setActivityAssignmentId",
						long.class);

				method.invoke(_activityAssignmentRemoteModel,
					activityAssignmentId);
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

		if (_activityAssignmentRemoteModel != null) {
			try {
				Class<?> clazz = _activityAssignmentRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_activityAssignmentRemoteModel, companyId);
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

		if (_activityAssignmentRemoteModel != null) {
			try {
				Class<?> clazz = _activityAssignmentRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_activityAssignmentRemoteModel, userId);
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

		if (_activityAssignmentRemoteModel != null) {
			try {
				Class<?> clazz = _activityAssignmentRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_activityAssignmentRemoteModel, userName);
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

		if (_activityAssignmentRemoteModel != null) {
			try {
				Class<?> clazz = _activityAssignmentRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_activityAssignmentRemoteModel, createDate);
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

		if (_activityAssignmentRemoteModel != null) {
			try {
				Class<?> clazz = _activityAssignmentRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_activityAssignmentRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getActivityId() {
		return _activityId;
	}

	@Override
	public void setActivityId(long activityId) {
		_activityId = activityId;

		if (_activityAssignmentRemoteModel != null) {
			try {
				Class<?> clazz = _activityAssignmentRemoteModel.getClass();

				Method method = clazz.getMethod("setActivityId", long.class);

				method.invoke(_activityAssignmentRemoteModel, activityId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getWorkDayId() {
		return _workDayId;
	}

	@Override
	public void setWorkDayId(long workDayId) {
		_workDayId = workDayId;

		if (_activityAssignmentRemoteModel != null) {
			try {
				Class<?> clazz = _activityAssignmentRemoteModel.getClass();

				Method method = clazz.getMethod("setWorkDayId", long.class);

				method.invoke(_activityAssignmentRemoteModel, workDayId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStartTime() {
		return _startTime;
	}

	@Override
	public void setStartTime(Date startTime) {
		_startTime = startTime;

		if (_activityAssignmentRemoteModel != null) {
			try {
				Class<?> clazz = _activityAssignmentRemoteModel.getClass();

				Method method = clazz.getMethod("setStartTime", Date.class);

				method.invoke(_activityAssignmentRemoteModel, startTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEndTime() {
		return _endTime;
	}

	@Override
	public void setEndTime(Date endTime) {
		_endTime = endTime;

		if (_activityAssignmentRemoteModel != null) {
			try {
				Class<?> clazz = _activityAssignmentRemoteModel.getClass();

				Method method = clazz.getMethod("setEndTime", Date.class);

				method.invoke(_activityAssignmentRemoteModel, endTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getActivityAssignmentRemoteModel() {
		return _activityAssignmentRemoteModel;
	}

	public void setActivityAssignmentRemoteModel(
		BaseModel<?> activityAssignmentRemoteModel) {
		_activityAssignmentRemoteModel = activityAssignmentRemoteModel;
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

		Class<?> remoteModelClass = _activityAssignmentRemoteModel.getClass();

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

		Object returnValue = method.invoke(_activityAssignmentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ActivityAssignmentLocalServiceUtil.addActivityAssignment(this);
		}
		else {
			ActivityAssignmentLocalServiceUtil.updateActivityAssignment(this);
		}
	}

	@Override
	public ActivityAssignment toEscapedModel() {
		return (ActivityAssignment)ProxyUtil.newProxyInstance(ActivityAssignment.class.getClassLoader(),
			new Class[] { ActivityAssignment.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ActivityAssignmentClp clone = new ActivityAssignmentClp();

		clone.setActivityAssignmentId(getActivityAssignmentId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setActivityId(getActivityId());
		clone.setWorkDayId(getWorkDayId());
		clone.setStartTime(getStartTime());
		clone.setEndTime(getEndTime());

		return clone;
	}

	@Override
	public int compareTo(ActivityAssignment activityAssignment) {
		int value = 0;

		value = DateUtil.compareTo(getStartTime(),
				activityAssignment.getStartTime());

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

		if (!(obj instanceof ActivityAssignmentClp)) {
			return false;
		}

		ActivityAssignmentClp activityAssignment = (ActivityAssignmentClp)obj;

		long primaryKey = activityAssignment.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{activityAssignmentId=");
		sb.append(getActivityAssignmentId());
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
		sb.append(", activityId=");
		sb.append(getActivityId());
		sb.append(", workDayId=");
		sb.append(getWorkDayId());
		sb.append(", startTime=");
		sb.append(getStartTime());
		sb.append(", endTime=");
		sb.append(getEndTime());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.timetracking.activities.model.ActivityAssignment");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>activityAssignmentId</column-name><column-value><![CDATA[");
		sb.append(getActivityAssignmentId());
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
			"<column><column-name>activityId</column-name><column-value><![CDATA[");
		sb.append(getActivityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>workDayId</column-name><column-value><![CDATA[");
		sb.append(getWorkDayId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startTime</column-name><column-value><![CDATA[");
		sb.append(getStartTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endTime</column-name><column-value><![CDATA[");
		sb.append(getEndTime());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _activityAssignmentId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _activityId;
	private long _workDayId;
	private Date _startTime;
	private Date _endTime;
	private BaseModel<?> _activityAssignmentRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.timetracking.activities.service.ClpSerializer.class;
}