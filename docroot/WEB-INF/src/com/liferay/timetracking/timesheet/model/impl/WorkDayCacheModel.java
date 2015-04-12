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

package com.liferay.timetracking.timesheet.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.liferay.timetracking.timesheet.model.WorkDay;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing WorkDay in entity cache.
 *
 * @author Laszlo Hudak, Istvan Sajtos
 * @see WorkDay
 * @generated
 */
public class WorkDayCacheModel implements CacheModel<WorkDay>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{workDayId=");
		sb.append(workDayId);
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
		sb.append(", dayOfYearId=");
		sb.append(dayOfYearId);
		sb.append(", startTime=");
		sb.append(startTime);
		sb.append(", endTime=");
		sb.append(endTime);
		sb.append(", lunchBreak=");
		sb.append(lunchBreak);
		sb.append(", timestamp=");
		sb.append(timestamp);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WorkDay toEntityModel() {
		WorkDayImpl workDayImpl = new WorkDayImpl();

		workDayImpl.setWorkDayId(workDayId);
		workDayImpl.setGroupId(groupId);
		workDayImpl.setCompanyId(companyId);
		workDayImpl.setUserId(userId);

		if (userName == null) {
			workDayImpl.setUserName(StringPool.BLANK);
		}
		else {
			workDayImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			workDayImpl.setCreateDate(null);
		}
		else {
			workDayImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			workDayImpl.setModifiedDate(null);
		}
		else {
			workDayImpl.setModifiedDate(new Date(modifiedDate));
		}

		workDayImpl.setDayOfYearId(dayOfYearId);
		workDayImpl.setStartTime(startTime);
		workDayImpl.setEndTime(endTime);
		workDayImpl.setLunchBreak(lunchBreak);

		if (timestamp == Long.MIN_VALUE) {
			workDayImpl.setTimestamp(null);
		}
		else {
			workDayImpl.setTimestamp(new Date(timestamp));
		}

		workDayImpl.resetOriginalValues();

		return workDayImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		workDayId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		dayOfYearId = objectInput.readLong();
		startTime = objectInput.readInt();
		endTime = objectInput.readInt();
		lunchBreak = objectInput.readInt();
		timestamp = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(workDayId);
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
		objectOutput.writeLong(dayOfYearId);
		objectOutput.writeInt(startTime);
		objectOutput.writeInt(endTime);
		objectOutput.writeInt(lunchBreak);
		objectOutput.writeLong(timestamp);
	}

	public long workDayId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long dayOfYearId;
	public int startTime;
	public int endTime;
	public int lunchBreak;
	public long timestamp;
}