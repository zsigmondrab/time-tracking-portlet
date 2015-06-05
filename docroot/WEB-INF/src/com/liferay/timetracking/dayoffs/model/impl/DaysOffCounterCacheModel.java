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

import com.liferay.timetracking.dayoffs.model.DaysOffCounter;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DaysOffCounter in entity cache.
 *
 * @author Laszlo Hudak
 * @see DaysOffCounter
 * @generated
 */
public class DaysOffCounterCacheModel implements CacheModel<DaysOffCounter>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{dayOffCounterId=");
		sb.append(dayOffCounterId);
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
		sb.append(", workerUserId=");
		sb.append(workerUserId);
		sb.append(", workerUserName=");
		sb.append(workerUserName);
		sb.append(", ruleId=");
		sb.append(ruleId);
		sb.append(", year=");
		sb.append(year);
		sb.append(", allDays=");
		sb.append(allDays);
		sb.append(", remainingDays=");
		sb.append(remainingDays);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DaysOffCounter toEntityModel() {
		DaysOffCounterImpl daysOffCounterImpl = new DaysOffCounterImpl();

		daysOffCounterImpl.setDayOffCounterId(dayOffCounterId);
		daysOffCounterImpl.setCompanyId(companyId);
		daysOffCounterImpl.setUserId(userId);

		if (userName == null) {
			daysOffCounterImpl.setUserName(StringPool.BLANK);
		}
		else {
			daysOffCounterImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			daysOffCounterImpl.setCreateDate(null);
		}
		else {
			daysOffCounterImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			daysOffCounterImpl.setModifiedDate(null);
		}
		else {
			daysOffCounterImpl.setModifiedDate(new Date(modifiedDate));
		}

		daysOffCounterImpl.setWorkerUserId(workerUserId);

		if (workerUserName == null) {
			daysOffCounterImpl.setWorkerUserName(StringPool.BLANK);
		}
		else {
			daysOffCounterImpl.setWorkerUserName(workerUserName);
		}

		daysOffCounterImpl.setRuleId(ruleId);
		daysOffCounterImpl.setYear(year);
		daysOffCounterImpl.setAllDays(allDays);
		daysOffCounterImpl.setRemainingDays(remainingDays);

		daysOffCounterImpl.resetOriginalValues();

		return daysOffCounterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dayOffCounterId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		workerUserId = objectInput.readLong();
		workerUserName = objectInput.readUTF();
		ruleId = objectInput.readLong();
		year = objectInput.readInt();
		allDays = objectInput.readInt();
		remainingDays = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(dayOffCounterId);
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
		objectOutput.writeLong(workerUserId);

		if (workerUserName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(workerUserName);
		}

		objectOutput.writeLong(ruleId);
		objectOutput.writeInt(year);
		objectOutput.writeInt(allDays);
		objectOutput.writeInt(remainingDays);
	}

	public long dayOffCounterId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long workerUserId;
	public String workerUserName;
	public long ruleId;
	public int year;
	public int allDays;
	public int remainingDays;
}