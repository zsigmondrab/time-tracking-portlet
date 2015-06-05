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

package com.liferay.timetracking.dayoffs.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.liferay.timetracking.dayoffs.model.DaysOfYear;
import com.liferay.timetracking.dayoffs.model.DaysOfYearModel;
import com.liferay.timetracking.dayoffs.model.DaysOfYearSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the DaysOfYear service. Represents a row in the &quot;TimeTracking_DaysOfYear&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.timetracking.dayoffs.model.DaysOfYearModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DaysOfYearImpl}.
 * </p>
 *
 * @author Laszlo Hudak
 * @see DaysOfYearImpl
 * @see com.liferay.timetracking.dayoffs.model.DaysOfYear
 * @see com.liferay.timetracking.dayoffs.model.DaysOfYearModel
 * @generated
 */
@JSON(strict = true)
public class DaysOfYearModelImpl extends BaseModelImpl<DaysOfYear>
	implements DaysOfYearModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a days of year model instance should use the {@link com.liferay.timetracking.dayoffs.model.DaysOfYear} interface instead.
	 */
	public static final String TABLE_NAME = "TimeTracking_DaysOfYear";
	public static final Object[][] TABLE_COLUMNS = {
			{ "dayOfYearId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "dayId", Types.TIMESTAMP },
			{ "ruleId", Types.BIGINT },
			{ "classNameId", Types.BIGINT },
			{ "classPK", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table TimeTracking_DaysOfYear (dayOfYearId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,dayId DATE null,ruleId LONG,classNameId LONG,classPK LONG)";
	public static final String TABLE_SQL_DROP = "drop table TimeTracking_DaysOfYear";
	public static final String ORDER_BY_JPQL = " ORDER BY daysOfYear.dayId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY TimeTracking_DaysOfYear.dayId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.timetracking.dayoffs.model.DaysOfYear"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.timetracking.dayoffs.model.DaysOfYear"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.timetracking.dayoffs.model.DaysOfYear"),
			true);
	public static long CLASSNAMEID_COLUMN_BITMASK = 1L;
	public static long CLASSPK_COLUMN_BITMASK = 2L;
	public static long COMPANYID_COLUMN_BITMASK = 4L;
	public static long DAYID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static DaysOfYear toModel(DaysOfYearSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		DaysOfYear model = new DaysOfYearImpl();

		model.setDayOfYearId(soapModel.getDayOfYearId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setDayId(soapModel.getDayId());
		model.setRuleId(soapModel.getRuleId());
		model.setClassNameId(soapModel.getClassNameId());
		model.setClassPK(soapModel.getClassPK());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<DaysOfYear> toModels(DaysOfYearSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<DaysOfYear> models = new ArrayList<DaysOfYear>(soapModels.length);

		for (DaysOfYearSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.timetracking.dayoffs.model.DaysOfYear"));

	public DaysOfYearModelImpl() {
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
	public Class<?> getModelClass() {
		return DaysOfYear.class;
	}

	@Override
	public String getModelClassName() {
		return DaysOfYear.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dayOfYearId", getDayOfYearId());
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

	@JSON
	@Override
	public long getDayOfYearId() {
		return _dayOfYearId;
	}

	@Override
	public void setDayOfYearId(long dayOfYearId) {
		_dayOfYearId = dayOfYearId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
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
	public Date getDayId() {
		return _dayId;
	}

	@Override
	public void setDayId(Date dayId) {
		_columnBitmask = -1L;

		if (_originalDayId == null) {
			_originalDayId = _dayId;
		}

		_dayId = dayId;
	}

	public Date getOriginalDayId() {
		return _originalDayId;
	}

	@JSON
	@Override
	public long getRuleId() {
		return _ruleId;
	}

	@Override
	public void setRuleId(long ruleId) {
		_ruleId = ruleId;
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

	@JSON
	@Override
	public long getClassNameId() {
		return _classNameId;
	}

	@Override
	public void setClassNameId(long classNameId) {
		_columnBitmask |= CLASSNAMEID_COLUMN_BITMASK;

		if (!_setOriginalClassNameId) {
			_setOriginalClassNameId = true;

			_originalClassNameId = _classNameId;
		}

		_classNameId = classNameId;
	}

	public long getOriginalClassNameId() {
		return _originalClassNameId;
	}

	@JSON
	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public void setClassPK(long classPK) {
		_columnBitmask |= CLASSPK_COLUMN_BITMASK;

		if (!_setOriginalClassPK) {
			_setOriginalClassPK = true;

			_originalClassPK = _classPK;
		}

		_classPK = classPK;
	}

	public long getOriginalClassPK() {
		return _originalClassPK;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			DaysOfYear.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DaysOfYear toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (DaysOfYear)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DaysOfYearImpl daysOfYearImpl = new DaysOfYearImpl();

		daysOfYearImpl.setDayOfYearId(getDayOfYearId());
		daysOfYearImpl.setCompanyId(getCompanyId());
		daysOfYearImpl.setUserId(getUserId());
		daysOfYearImpl.setUserName(getUserName());
		daysOfYearImpl.setCreateDate(getCreateDate());
		daysOfYearImpl.setModifiedDate(getModifiedDate());
		daysOfYearImpl.setDayId(getDayId());
		daysOfYearImpl.setRuleId(getRuleId());
		daysOfYearImpl.setClassNameId(getClassNameId());
		daysOfYearImpl.setClassPK(getClassPK());

		daysOfYearImpl.resetOriginalValues();

		return daysOfYearImpl;
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

		if (!(obj instanceof DaysOfYear)) {
			return false;
		}

		DaysOfYear daysOfYear = (DaysOfYear)obj;

		long primaryKey = daysOfYear.getPrimaryKey();

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
		DaysOfYearModelImpl daysOfYearModelImpl = this;

		daysOfYearModelImpl._originalCompanyId = daysOfYearModelImpl._companyId;

		daysOfYearModelImpl._setOriginalCompanyId = false;

		daysOfYearModelImpl._originalDayId = daysOfYearModelImpl._dayId;

		daysOfYearModelImpl._originalClassNameId = daysOfYearModelImpl._classNameId;

		daysOfYearModelImpl._setOriginalClassNameId = false;

		daysOfYearModelImpl._originalClassPK = daysOfYearModelImpl._classPK;

		daysOfYearModelImpl._setOriginalClassPK = false;

		daysOfYearModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DaysOfYear> toCacheModel() {
		DaysOfYearCacheModel daysOfYearCacheModel = new DaysOfYearCacheModel();

		daysOfYearCacheModel.dayOfYearId = getDayOfYearId();

		daysOfYearCacheModel.companyId = getCompanyId();

		daysOfYearCacheModel.userId = getUserId();

		daysOfYearCacheModel.userName = getUserName();

		String userName = daysOfYearCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			daysOfYearCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			daysOfYearCacheModel.createDate = createDate.getTime();
		}
		else {
			daysOfYearCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			daysOfYearCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			daysOfYearCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		Date dayId = getDayId();

		if (dayId != null) {
			daysOfYearCacheModel.dayId = dayId.getTime();
		}
		else {
			daysOfYearCacheModel.dayId = Long.MIN_VALUE;
		}

		daysOfYearCacheModel.ruleId = getRuleId();

		daysOfYearCacheModel.classNameId = getClassNameId();

		daysOfYearCacheModel.classPK = getClassPK();

		return daysOfYearCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{dayOfYearId=");
		sb.append(getDayOfYearId());
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
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.liferay.timetracking.dayoffs.model.DaysOfYear");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>dayOfYearId</column-name><column-value><![CDATA[");
		sb.append(getDayOfYearId());
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

	private static ClassLoader _classLoader = DaysOfYear.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			DaysOfYear.class
		};
	private long _dayOfYearId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _dayId;
	private Date _originalDayId;
	private long _ruleId;
	private long _classNameId;
	private long _originalClassNameId;
	private boolean _setOriginalClassNameId;
	private long _classPK;
	private long _originalClassPK;
	private boolean _setOriginalClassPK;
	private long _columnBitmask;
	private DaysOfYear _escapedModel;
}