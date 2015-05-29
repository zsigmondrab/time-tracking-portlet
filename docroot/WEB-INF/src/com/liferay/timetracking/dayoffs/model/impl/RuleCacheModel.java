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

import com.liferay.timetracking.dayoffs.model.Rule;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Rule in entity cache.
 *
 * @author LÃ¡szlÃ³ HudÃ¡k
 * @see Rule
 * @generated
 */
public class RuleCacheModel implements CacheModel<Rule>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{ruleId=");
		sb.append(ruleId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append(", multiplier=");
		sb.append(multiplier);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Rule toEntityModel() {
		RuleImpl ruleImpl = new RuleImpl();

		ruleImpl.setRuleId(ruleId);
		ruleImpl.setCompanyId(companyId);
		ruleImpl.setUserId(userId);

		if (userName == null) {
			ruleImpl.setUserName(StringPool.BLANK);
		}
		else {
			ruleImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			ruleImpl.setCreateDate(null);
		}
		else {
			ruleImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			ruleImpl.setModifiedDate(null);
		}
		else {
			ruleImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			ruleImpl.setName(StringPool.BLANK);
		}
		else {
			ruleImpl.setName(name);
		}

		ruleImpl.setMultiplier(multiplier);

		ruleImpl.resetOriginalValues();

		return ruleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ruleId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		multiplier = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(ruleId);
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

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeDouble(multiplier);
	}

	public long ruleId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public double multiplier;
}