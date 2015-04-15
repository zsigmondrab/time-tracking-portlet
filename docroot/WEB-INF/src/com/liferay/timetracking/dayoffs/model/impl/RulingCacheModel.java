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

import com.liferay.timetracking.dayoffs.model.Ruling;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Ruling in entity cache.
 *
 * @author LĂˇszlĂł HudĂˇk
 * @see Ruling
 * @generated
 */
public class RulingCacheModel implements CacheModel<Ruling>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{ruleId=");
		sb.append(ruleId);
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
		sb.append(", ruleName=");
		sb.append(ruleName);
		sb.append(", multiplier=");
		sb.append(multiplier);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Ruling toEntityModel() {
		RulingImpl rulingImpl = new RulingImpl();

		rulingImpl.setRuleId(ruleId);
		rulingImpl.setGroupId(groupId);
		rulingImpl.setCompanyId(companyId);
		rulingImpl.setUserId(userId);

		if (userName == null) {
			rulingImpl.setUserName(StringPool.BLANK);
		}
		else {
			rulingImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			rulingImpl.setCreateDate(null);
		}
		else {
			rulingImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			rulingImpl.setModifiedDate(null);
		}
		else {
			rulingImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (ruleName == null) {
			rulingImpl.setRuleName(StringPool.BLANK);
		}
		else {
			rulingImpl.setRuleName(ruleName);
		}

		rulingImpl.setMultiplier(multiplier);

		rulingImpl.resetOriginalValues();

		return rulingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ruleId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		ruleName = objectInput.readUTF();
		multiplier = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(ruleId);
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

		if (ruleName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ruleName);
		}

		objectOutput.writeDouble(multiplier);
	}

	public long ruleId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String ruleName;
	public double multiplier;
}