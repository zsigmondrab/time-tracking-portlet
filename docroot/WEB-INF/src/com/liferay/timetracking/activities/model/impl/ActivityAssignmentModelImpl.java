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

package com.liferay.timetracking.activities.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.liferay.timetracking.activities.model.ActivityAssignment;
import com.liferay.timetracking.activities.model.ActivityAssignmentModel;
import com.liferay.timetracking.activities.model.ActivityAssignmentSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the ActivityAssignment service. Represents a row in the &quot;TimeTracking_ActivityAssignment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.timetracking.activities.model.ActivityAssignmentModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ActivityAssignmentImpl}.
 * </p>
 *
 * @author Laszlo Hudak, Adam T. Nagy
 * @see ActivityAssignmentImpl
 * @see com.liferay.timetracking.activities.model.ActivityAssignment
 * @see com.liferay.timetracking.activities.model.ActivityAssignmentModel
 * @generated
 */
@JSON(strict = true)
public class ActivityAssignmentModelImpl extends BaseModelImpl<ActivityAssignment>
	implements ActivityAssignmentModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a activity assignment model instance should use the {@link com.liferay.timetracking.activities.model.ActivityAssignment} interface instead.
	 */
	public static final String TABLE_NAME = "TimeTracking_ActivityAssignment";
	public static final Object[][] TABLE_COLUMNS = {
			{ "activityAssignmentId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "activityId", Types.BIGINT },
			{ "workDayId", Types.BIGINT },
			{ "startTime", Types.TIMESTAMP },
			{ "endTime", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table TimeTracking_ActivityAssignment (activityAssignmentId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,activityId LONG,workDayId LONG,startTime DATE null,endTime DATE null)";
	public static final String TABLE_SQL_DROP = "drop table TimeTracking_ActivityAssignment";
	public static final String ORDER_BY_JPQL = " ORDER BY activityAssignment.startTime ASC";
	public static final String ORDER_BY_SQL = " ORDER BY TimeTracking_ActivityAssignment.startTime ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.timetracking.activities.model.ActivityAssignment"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.timetracking.activities.model.ActivityAssignment"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.timetracking.activities.model.ActivityAssignment"),
			true);
	public static long GROUPID_COLUMN_BITMASK = 1L;
	public static long STARTTIME_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ActivityAssignment toModel(ActivityAssignmentSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ActivityAssignment model = new ActivityAssignmentImpl();

		model.setActivityAssignmentId(soapModel.getActivityAssignmentId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setActivityId(soapModel.getActivityId());
		model.setWorkDayId(soapModel.getWorkDayId());
		model.setStartTime(soapModel.getStartTime());
		model.setEndTime(soapModel.getEndTime());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ActivityAssignment> toModels(
		ActivityAssignmentSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ActivityAssignment> models = new ArrayList<ActivityAssignment>(soapModels.length);

		for (ActivityAssignmentSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.timetracking.activities.model.ActivityAssignment"));

	public ActivityAssignmentModelImpl() {
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
	public Class<?> getModelClass() {
		return ActivityAssignment.class;
	}

	@Override
	public String getModelClassName() {
		return ActivityAssignment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("activityAssignmentId", getActivityAssignmentId());
		attributes.put("groupId", getGroupId());
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

	@JSON
	@Override
	public long getActivityAssignmentId() {
		return _activityAssignmentId;
	}

	@Override
	public void setActivityAssignmentId(long activityAssignmentId) {
		_activityAssignmentId = activityAssignmentId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getActivityId() {
		return _activityId;
	}

	@Override
	public void setActivityId(long activityId) {
		_activityId = activityId;
	}

	@JSON
	@Override
	public long getWorkDayId() {
		return _workDayId;
	}

	@Override
	public void setWorkDayId(long workDayId) {
		_workDayId = workDayId;
	}

	@JSON
	@Override
	public Date getStartTime() {
		return _startTime;
	}

	@Override
	public void setStartTime(Date startTime) {
		_columnBitmask = -1L;

		_startTime = startTime;
	}

	@JSON
	@Override
	public Date getEndTime() {
		return _endTime;
	}

	@Override
	public void setEndTime(Date endTime) {
		_endTime = endTime;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			ActivityAssignment.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ActivityAssignment toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ActivityAssignment)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ActivityAssignmentImpl activityAssignmentImpl = new ActivityAssignmentImpl();

		activityAssignmentImpl.setActivityAssignmentId(getActivityAssignmentId());
		activityAssignmentImpl.setGroupId(getGroupId());
		activityAssignmentImpl.setCompanyId(getCompanyId());
		activityAssignmentImpl.setUserId(getUserId());
		activityAssignmentImpl.setUserName(getUserName());
		activityAssignmentImpl.setCreateDate(getCreateDate());
		activityAssignmentImpl.setModifiedDate(getModifiedDate());
		activityAssignmentImpl.setActivityId(getActivityId());
		activityAssignmentImpl.setWorkDayId(getWorkDayId());
		activityAssignmentImpl.setStartTime(getStartTime());
		activityAssignmentImpl.setEndTime(getEndTime());

		activityAssignmentImpl.resetOriginalValues();

		return activityAssignmentImpl;
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

		if (!(obj instanceof ActivityAssignment)) {
			return false;
		}

		ActivityAssignment activityAssignment = (ActivityAssignment)obj;

		long primaryKey = activityAssignment.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		ActivityAssignmentModelImpl activityAssignmentModelImpl = this;

		activityAssignmentModelImpl._originalGroupId = activityAssignmentModelImpl._groupId;

		activityAssignmentModelImpl._setOriginalGroupId = false;

		activityAssignmentModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ActivityAssignment> toCacheModel() {
		ActivityAssignmentCacheModel activityAssignmentCacheModel = new ActivityAssignmentCacheModel();

		activityAssignmentCacheModel.activityAssignmentId = getActivityAssignmentId();

		activityAssignmentCacheModel.groupId = getGroupId();

		activityAssignmentCacheModel.companyId = getCompanyId();

		activityAssignmentCacheModel.userId = getUserId();

		activityAssignmentCacheModel.userName = getUserName();

		String userName = activityAssignmentCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			activityAssignmentCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			activityAssignmentCacheModel.createDate = createDate.getTime();
		}
		else {
			activityAssignmentCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			activityAssignmentCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			activityAssignmentCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		activityAssignmentCacheModel.activityId = getActivityId();

		activityAssignmentCacheModel.workDayId = getWorkDayId();

		Date startTime = getStartTime();

		if (startTime != null) {
			activityAssignmentCacheModel.startTime = startTime.getTime();
		}
		else {
			activityAssignmentCacheModel.startTime = Long.MIN_VALUE;
		}

		Date endTime = getEndTime();

		if (endTime != null) {
			activityAssignmentCacheModel.endTime = endTime.getTime();
		}
		else {
			activityAssignmentCacheModel.endTime = Long.MIN_VALUE;
		}

		return activityAssignmentCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{activityAssignmentId=");
		sb.append(getActivityAssignmentId());
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
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.timetracking.activities.model.ActivityAssignment");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>activityAssignmentId</column-name><column-value><![CDATA[");
		sb.append(getActivityAssignmentId());
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

	private static ClassLoader _classLoader = ActivityAssignment.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ActivityAssignment.class
		};
	private long _activityAssignmentId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
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
	private long _columnBitmask;
	private ActivityAssignment _escapedModel;
}