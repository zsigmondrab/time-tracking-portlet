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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.liferay.timetracking.activities.model.ActivityAssignment;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ActivityAssignment in entity cache.
 *
 * @author Laszlo Hudak, Adam T. Nagy
 * @see ActivityAssignment
 * @generated
 */
public class ActivityAssignmentCacheModel implements CacheModel<ActivityAssignment>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{activityAssignmentId=");
		sb.append(activityAssignmentId);
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
		sb.append(", activityId=");
		sb.append(activityId);
		sb.append(", workDayId=");
		sb.append(workDayId);
		sb.append(", startTime=");
		sb.append(startTime);
		sb.append(", endTime=");
		sb.append(endTime);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ActivityAssignment toEntityModel() {
		ActivityAssignmentImpl activityAssignmentImpl = new ActivityAssignmentImpl();

		activityAssignmentImpl.setActivityAssignmentId(activityAssignmentId);
		activityAssignmentImpl.setGroupId(groupId);
		activityAssignmentImpl.setCompanyId(companyId);
		activityAssignmentImpl.setUserId(userId);

		if (userName == null) {
			activityAssignmentImpl.setUserName(StringPool.BLANK);
		}
		else {
			activityAssignmentImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			activityAssignmentImpl.setCreateDate(null);
		}
		else {
			activityAssignmentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			activityAssignmentImpl.setModifiedDate(null);
		}
		else {
			activityAssignmentImpl.setModifiedDate(new Date(modifiedDate));
		}

		activityAssignmentImpl.setActivityId(activityId);
		activityAssignmentImpl.setWorkDayId(workDayId);

		if (startTime == Long.MIN_VALUE) {
			activityAssignmentImpl.setStartTime(null);
		}
		else {
			activityAssignmentImpl.setStartTime(new Date(startTime));
		}

		if (endTime == Long.MIN_VALUE) {
			activityAssignmentImpl.setEndTime(null);
		}
		else {
			activityAssignmentImpl.setEndTime(new Date(endTime));
		}

		activityAssignmentImpl.resetOriginalValues();

		return activityAssignmentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		activityAssignmentId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		activityId = objectInput.readLong();
		workDayId = objectInput.readLong();
		startTime = objectInput.readLong();
		endTime = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(activityAssignmentId);
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
		objectOutput.writeLong(activityId);
		objectOutput.writeLong(workDayId);
		objectOutput.writeLong(startTime);
		objectOutput.writeLong(endTime);
	}

	public long activityAssignmentId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long activityId;
	public long workDayId;
	public long startTime;
	public long endTime;
}