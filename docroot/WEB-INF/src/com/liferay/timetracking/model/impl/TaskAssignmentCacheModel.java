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

package com.liferay.timetracking.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.liferay.timetracking.model.TaskAssignment;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TaskAssignment in entity cache.
 *
 * @author BénaBéla
 * @see TaskAssignment
 * @generated
 */
public class TaskAssignmentCacheModel implements CacheModel<TaskAssignment>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{taskAssignmentId=");
		sb.append(taskAssignmentId);
		sb.append(", taskId=");
		sb.append(taskId);
		sb.append(", workDayId=");
		sb.append(workDayId);
		sb.append(", startTime=");
		sb.append(startTime);
		sb.append(", endTime=");
		sb.append(endTime);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TaskAssignment toEntityModel() {
		TaskAssignmentImpl taskAssignmentImpl = new TaskAssignmentImpl();

		taskAssignmentImpl.setTaskAssignmentId(taskAssignmentId);
		taskAssignmentImpl.setTaskId(taskId);
		taskAssignmentImpl.setWorkDayId(workDayId);

		if (startTime == Long.MIN_VALUE) {
			taskAssignmentImpl.setStartTime(null);
		}
		else {
			taskAssignmentImpl.setStartTime(new Date(startTime));
		}

		if (endTime == Long.MIN_VALUE) {
			taskAssignmentImpl.setEndTime(null);
		}
		else {
			taskAssignmentImpl.setEndTime(new Date(endTime));
		}

		taskAssignmentImpl.setCompanyId(companyId);
		taskAssignmentImpl.setGroupId(groupId);
		taskAssignmentImpl.setUserId(userId);

		if (userName == null) {
			taskAssignmentImpl.setUserName(StringPool.BLANK);
		}
		else {
			taskAssignmentImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			taskAssignmentImpl.setCreateDate(null);
		}
		else {
			taskAssignmentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			taskAssignmentImpl.setModifiedDate(null);
		}
		else {
			taskAssignmentImpl.setModifiedDate(new Date(modifiedDate));
		}

		taskAssignmentImpl.resetOriginalValues();

		return taskAssignmentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		taskAssignmentId = objectInput.readLong();
		taskId = objectInput.readLong();
		workDayId = objectInput.readLong();
		startTime = objectInput.readLong();
		endTime = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(taskAssignmentId);
		objectOutput.writeLong(taskId);
		objectOutput.writeLong(workDayId);
		objectOutput.writeLong(startTime);
		objectOutput.writeLong(endTime);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long taskAssignmentId;
	public long taskId;
	public long workDayId;
	public long startTime;
	public long endTime;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}