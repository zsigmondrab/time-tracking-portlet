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
		StringBundler sb = new StringBundler(21);

		sb.append("{workDayId=");
		sb.append(workDayId);
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
		sb.append(", pause=");
		sb.append(pause);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WorkDay toEntityModel() {
		WorkDayImpl workDayImpl = new WorkDayImpl();

		workDayImpl.setWorkDayId(workDayId);
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

		if (startTime == Long.MIN_VALUE) {
			workDayImpl.setStartTime(null);
		}
		else {
			workDayImpl.setStartTime(new Date(startTime));
		}

		if (endTime == Long.MIN_VALUE) {
			workDayImpl.setEndTime(null);
		}
		else {
			workDayImpl.setEndTime(new Date(endTime));
		}

		workDayImpl.setPause(pause);

		workDayImpl.resetOriginalValues();

		return workDayImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		workDayId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		dayOfYearId = objectInput.readLong();
		startTime = objectInput.readLong();
		endTime = objectInput.readLong();
		pause = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(workDayId);
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
		objectOutput.writeLong(startTime);
		objectOutput.writeLong(endTime);
		objectOutput.writeInt(pause);
	}

	public long workDayId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long dayOfYearId;
	public long startTime;
	public long endTime;
	public int pause;
}