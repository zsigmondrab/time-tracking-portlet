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

package com.liferay.timetracking.dayoffs.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.timetracking.dayoffs.model.Rule;
import com.liferay.timetracking.dayoffs.service.base.RuleLocalServiceBaseImpl;

import java.util.Date;

/**
 * The implementation of the rule local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.timetracking.dayoffs.service.RuleLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Laszlo Hudak
 * @see com.liferay.timetracking.dayoffs.service.base.RuleLocalServiceBaseImpl
 * @see com.liferay.timetracking.dayoffs.service.RuleLocalServiceUtil
 */
public class RuleLocalServiceImpl extends RuleLocalServiceBaseImpl {

	/**
	 * Adds a Rule with the given name and multiplier and default audit
	 * parameters
	 *
	 * @param name the name of the rule
	 * @param multiplier the value indicateing if the user is allowed to work
	 *        on the day to which the rule is assigne and also can be used for
	 *        calculating the salary
	 * @return the web content article
	 * @throws PortalException if a portal exception occurred
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rule addRule(String ruleName, double multiplier)
		throws PortalException, SystemException {

		long companyId = PortalUtil.getDefaultCompanyId();

		User user = UserLocalServiceUtil.getDefaultUser(companyId);

		Date now = new Date();

		long ruleId = counterLocalService.increment();

		Rule rule = rulePersistence.create(ruleId);

		rule.setCompanyId(companyId);
		rule.setUserId(user.getUserId());
		rule.setUserName(user.getFullName());
		rule.setCreateDate(now);
		rule.setModifiedDate(now);

		//Other Fields
		rule.setName(ruleName);
		rule.setMultiplier(multiplier);

		addRule(rule);

		return rule;
	}

}