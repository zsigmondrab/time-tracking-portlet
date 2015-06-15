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

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.timetracking.dayoffs.NoMoreDaysLeftException;
import com.liferay.timetracking.dayoffs.model.DaysOffCounter;
import com.liferay.timetracking.dayoffs.service.base.DaysOffCounterLocalServiceBaseImpl;
import com.liferay.timetracking.dayoffs.service.persistence.DaysOffCounterUtil;

import java.util.Date;

/**
 * The implementation of the days off counter local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.timetracking.dayoffs.service.DaysOffCounterLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Laszlo Hudak
 * @see com.liferay.timetracking.dayoffs.service.base.DaysOffCounterLocalServiceBaseImpl
 * @see com.liferay.timetracking.dayoffs.service.DaysOffCounterLocalServiceUtil
 */
public class DaysOffCounterLocalServiceImpl
	extends DaysOffCounterLocalServiceBaseImpl {
	
	/**
	 * Upon taking a day off, this method registers how many more days can the 
	 * user take off or throws Exception if there are no more days left.
	 *
	 * @param userId the id of the user who approves the days off
	 * @param workerUserId the id of the user who wants to take the days off
	 * @param ruleId the id of the rule which determines the type of the days 
	 *        off
	 * @param year which year does the user want to take off the days
	 * @return the updated registry entry
	 * @throws PortalException if a portal exception occurred
	 * @throws SystemException if a system exception occurred
	 * @throws NoMoreDaysLeftException if the user doesn't have any more days
	 *         to take off
	 */
	@Override
	public DaysOffCounter takeOffDays(
			long userId, long workerUserId, long ruleId, int year,
			int numberOfDays) 
		throws PortalException, SystemException {

		DaysOffCounter daysOffCounter = DaysOffCounterUtil.fetchByW_R_Y(
			workerUserId, ruleId, year);

		int remainingDays = daysOffCounter.getRemainingDays();

		if (remainingDays - numberOfDays < 0) {
			throw new NoMoreDaysLeftException();
		}

		daysOffCounter.setRemainingDays(remainingDays - numberOfDays);
		daysOffCounter.setUserId(userId);
		daysOffCounter.setModifiedDate(new Date());

		daysOffCounterLocalService.updateDaysOffCounter(daysOffCounter);

		return daysOffCounter;
	}
}