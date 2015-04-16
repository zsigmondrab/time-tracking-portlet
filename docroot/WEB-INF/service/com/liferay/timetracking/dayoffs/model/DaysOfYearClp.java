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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.liferay.timetracking.dayoffs.service.ClpSerializer;
import com.liferay.timetracking.dayoffs.service.DaysOfYearLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author László Hudák
 */
public class DaysOfYearClp extends BaseModelImpl<DaysOfYear>
	implements DaysOfYear {
	public DaysOfYearClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return DaysOfYear.class;
	}

	@Override
	public String getModelClassName() {
		return DaysOfYear.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _dayOfYearId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDayOfYearId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dayOfYearId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dayOfYearId", getDayOfYearId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("dayId", getDayId());
		attributes.put("ruleId", getRuleId());
		attributes.put("classNameId", getClassNameId());
		attributes.put("classPK", getClassPK());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dayOfYearId = (Long)attributes.get("dayOfYearId");

		if (dayOfYearId != null) {
			setDayOfYearId(dayOfYearId);
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

		Date dayId = (Date)attributes.get("dayId");

		if (dayId != null) {
			setDayId(dayId);
		}

		Long ruleId = (Long)attributes.get("ruleId");

		if (ruleId != null) {
			setRuleId(ruleId);
		}

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}
	}

	@Override
	public long getDayOfYearId() {
		return _dayOfYearId;
	}

	@Override
	public void setDayOfYearId(long dayOfYearId) {
		_dayOfYearId = dayOfYearId;

		if (_daysOfYearRemoteModel != null) {
			try {
				Class<?> clazz = _daysOfYearRemoteModel.getClass();

				Method method = clazz.getMethod("setDayOfYearId", long.class);

				method.invoke(_daysOfYearRemoteModel, dayOfYearId);
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

		if (_daysOfYearRemoteModel != null) {
			try {
				Class<?> clazz = _daysOfYearRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_daysOfYearRemoteModel, groupId);
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

		if (_daysOfYearRemoteModel != null) {
			try {
				Class<?> clazz = _daysOfYearRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_daysOfYearRemoteModel, companyId);
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

		if (_daysOfYearRemoteModel != null) {
			try {
				Class<?> clazz = _daysOfYearRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_daysOfYearRemoteModel, userId);
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

		if (_daysOfYearRemoteModel != null) {
			try {
				Class<?> clazz = _daysOfYearRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_daysOfYearRemoteModel, userName);
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

		if (_daysOfYearRemoteModel != null) {
			try {
				Class<?> clazz = _daysOfYearRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_daysOfYearRemoteModel, createDate);
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

		if (_daysOfYearRemoteModel != null) {
			try {
				Class<?> clazz = _daysOfYearRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_daysOfYearRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDayId() {
		return _dayId;
	}

	@Override
	public void setDayId(Date dayId) {
		_dayId = dayId;

		if (_daysOfYearRemoteModel != null) {
			try {
				Class<?> clazz = _daysOfYearRemoteModel.getClass();

				Method method = clazz.getMethod("setDayId", Date.class);

				method.invoke(_daysOfYearRemoteModel, dayId);
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

		if (_daysOfYearRemoteModel != null) {
			try {
				Class<?> clazz = _daysOfYearRemoteModel.getClass();

				Method method = clazz.getMethod("setRuleId", long.class);

				method.invoke(_daysOfYearRemoteModel, ruleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getClassName() {
		if (getClassNameId() <= 0) {
			return StringPool.BLANK;
		}

		return PortalUtil.getClassName(getClassNameId());
	}

	@Override
	public void setClassName(String className) {
		long classNameId = 0;

		if (Validator.isNotNull(className)) {
			classNameId = PortalUtil.getClassNameId(className);
		}

		setClassNameId(classNameId);
	}

	@Override
	public long getClassNameId() {
		return _classNameId;
	}

	@Override
	public void setClassNameId(long classNameId) {
		_classNameId = classNameId;

		if (_daysOfYearRemoteModel != null) {
			try {
				Class<?> clazz = _daysOfYearRemoteModel.getClass();

				Method method = clazz.getMethod("setClassNameId", long.class);

				method.invoke(_daysOfYearRemoteModel, classNameId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public void setClassPK(long classPK) {
		_classPK = classPK;

		if (_daysOfYearRemoteModel != null) {
			try {
				Class<?> clazz = _daysOfYearRemoteModel.getClass();

				Method method = clazz.getMethod("setClassPK", long.class);

				method.invoke(_daysOfYearRemoteModel, classPK);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDaysOfYearRemoteModel() {
		return _daysOfYearRemoteModel;
	}

	public void setDaysOfYearRemoteModel(BaseModel<?> daysOfYearRemoteModel) {
		_daysOfYearRemoteModel = daysOfYearRemoteModel;
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

		Class<?> remoteModelClass = _daysOfYearRemoteModel.getClass();

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

		Object returnValue = method.invoke(_daysOfYearRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DaysOfYearLocalServiceUtil.addDaysOfYear(this);
		}
		else {
			DaysOfYearLocalServiceUtil.updateDaysOfYear(this);
		}
	}

	@Override
	public DaysOfYear toEscapedModel() {
		return (DaysOfYear)ProxyUtil.newProxyInstance(DaysOfYear.class.getClassLoader(),
			new Class[] { DaysOfYear.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DaysOfYearClp clone = new DaysOfYearClp();

		clone.setDayOfYearId(getDayOfYearId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setDayId(getDayId());
		clone.setRuleId(getRuleId());
		clone.setClassNameId(getClassNameId());
		clone.setClassPK(getClassPK());

		return clone;
	}

	@Override
	public int compareTo(DaysOfYear daysOfYear) {
		int value = 0;

		value = DateUtil.compareTo(getDayId(), daysOfYear.getDayId());

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

		if (!(obj instanceof DaysOfYearClp)) {
			return false;
		}

		DaysOfYearClp daysOfYear = (DaysOfYearClp)obj;

		long primaryKey = daysOfYear.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{dayOfYearId=");
		sb.append(getDayOfYearId());
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
		sb.append(", dayId=");
		sb.append(getDayId());
		sb.append(", ruleId=");
		sb.append(getRuleId());
		sb.append(", classNameId=");
		sb.append(getClassNameId());
		sb.append(", classPK=");
		sb.append(getClassPK());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.liferay.timetracking.dayoffs.model.DaysOfYear");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>dayOfYearId</column-name><column-value><![CDATA[");
		sb.append(getDayOfYearId());
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
			"<column><column-name>dayId</column-name><column-value><![CDATA[");
		sb.append(getDayId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ruleId</column-name><column-value><![CDATA[");
		sb.append(getRuleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classNameId</column-name><column-value><![CDATA[");
		sb.append(getClassNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classPK</column-name><column-value><![CDATA[");
		sb.append(getClassPK());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _dayOfYearId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _dayId;
	private long _ruleId;
	private long _classNameId;
	private long _classPK;
	private BaseModel<?> _daysOfYearRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.timetracking.dayoffs.service.ClpSerializer.class;
}