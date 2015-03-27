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

import com.liferay.timetracking.activities.model.Activity;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Activity in entity cache.
 *
 * @author Laszlo Hudak, Adam T. Nagy
 * @see Activity
 * @generated
 */
public class ActivityCacheModel implements CacheModel<Activity>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{activityId=");
		sb.append(activityId);
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
		sb.append(", activityName=");
		sb.append(activityName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Activity toEntityModel() {
		ActivityImpl activityImpl = new ActivityImpl();

		activityImpl.setActivityId(activityId);
		activityImpl.setGroupId(groupId);
		activityImpl.setCompanyId(companyId);
		activityImpl.setUserId(userId);

		if (userName == null) {
			activityImpl.setUserName(StringPool.BLANK);
		}
		else {
			activityImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			activityImpl.setCreateDate(null);
		}
		else {
			activityImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			activityImpl.setModifiedDate(null);
		}
		else {
			activityImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (activityName == null) {
			activityImpl.setActivityName(StringPool.BLANK);
		}
		else {
			activityImpl.setActivityName(activityName);
		}

		activityImpl.resetOriginalValues();

		return activityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		activityId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		activityName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(activityId);
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

		if (activityName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(activityName);
		}
	}

	public long activityId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String activityName;
}