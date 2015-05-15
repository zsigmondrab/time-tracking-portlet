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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.timetracking.dayoffs.model.Rule;
import com.liferay.timetracking.dayoffs.model.impl.RuleImpl;
import com.liferay.timetracking.dayoffs.service.base.RuleLocalServiceBaseImpl;

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

	@Override
	public Rule addRule(String ruleName, double multiplier)
		throws SystemException {

		Rule rule = new RuleImpl();

		addRule(rule);

		return rule;
	}
}