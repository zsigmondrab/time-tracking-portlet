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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.liferay.timetracking.dayoffs.model.DaysOfYear;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DaysOfYear in entity cache.
 *
 * @author LĂˇszlĂł HudĂˇk
 * @see DaysOfYear
 * @generated
 */
public class DaysOfYearCacheModel implements CacheModel<DaysOfYear>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{dayOfYearId=");
		sb.append(dayOfYearId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", dayId=");
		sb.append(dayId);
		sb.append(", ruleId=");
		sb.append(ruleId);
		sb.append(", unitId=");
		sb.append(unitId);
		sb.append(", unitType=");
		sb.append(unitType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DaysOfYear toEntityModel() {
		DaysOfYearImpl daysOfYearImpl = new DaysOfYearImpl();

		daysOfYearImpl.setDayOfYearId(dayOfYearId);
		daysOfYearImpl.setGroupId(groupId);
		daysOfYearImpl.setCompanyId(companyId);
		daysOfYearImpl.setUserId(userId);

		if (userName == null) {
			daysOfYearImpl.setUserName(StringPool.BLANK);
		}
		else {
			daysOfYearImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			daysOfYearImpl.setCreateDate(null);
		}
		else {
			daysOfYearImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			daysOfYearImpl.setModifiedDate(null);
		}
		else {
			daysOfYearImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (dayId == Long.MIN_VALUE) {
			daysOfYearImpl.setDayId(null);
		}
		else {
			daysOfYearImpl.setDayId(new Date(dayId));
		}

		daysOfYearImpl.setRuleId(ruleId);
		daysOfYearImpl.setUnitId(unitId);
		daysOfYearImpl.setUnitType(unitType);

		daysOfYearImpl.resetOriginalValues();

		return daysOfYearImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dayOfYearId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		dayId = objectInput.readLong();
		ruleId = objectInput.readLong();
		unitId = objectInput.readLong();
		unitType = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(dayOfYearId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(dayId);
		objectOutput.writeLong(ruleId);
		objectOutput.writeLong(unitId);
		objectOutput.writeInt(unitType);
	}

	public long dayOfYearId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long dayId;
	public long ruleId;
	public long unitId;
	public int unitType;
}